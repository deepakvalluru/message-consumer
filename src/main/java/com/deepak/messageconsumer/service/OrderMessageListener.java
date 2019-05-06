package com.deepak.messageconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.deepak.messageconsumer.config.RabbitConfig;
import com.deepak.messageconsumer.model.Order;

@Component
public class OrderMessageListener
{
   static final Logger logger = LoggerFactory.getLogger( OrderMessageListener.class );

   @RabbitListener ( queues = RabbitConfig.QUEUE_ORDERS_PRIORITY )
   public void processPriorityOrder( Order order )
   {
      logger.debug( "Priority Order received : {}", order );
      if( order.getAmount() == 20.04 )
      {
         // payload is requeued 3 times ( as per config ) and then moved to the Dead Letter Queue
         // After configured TTL is over, the message is requeued back to the priority orders queue again.
         logger.debug( "RETRYING AGAIN AFTER A FEW SECONDS" );
         throw new RuntimeException( "RETRY AGAIN" );
      }
      else if( order.getAmount() == 0 )
      {
         logger.debug( "DO NOT REQUEUE" );
         throw new AmqpRejectAndDontRequeueException( "DO NOT RETRY" );
      }
   }

   @RabbitListener ( queues = RabbitConfig.QUEUE_ORDERS_NONPRIORITY )
   public void processNonPriorityOrder( Order order )
   {
      logger.debug( "Non-prioirty Order received : {}", order );
   }

}
