package com.deepak.messageconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
   }

   @RabbitListener ( queues = RabbitConfig.QUEUE_ORDERS_NONPRIORITY )
   public void processNonPriorityOrder( Order order )
   {
      logger.debug( "Non-prioirty Order received : {}", order );
   }

}
