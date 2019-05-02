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

   @RabbitListener ( queues = RabbitConfig.QUEUE_ORDERS )
   public void processOrder( Order order )
   {
      logger.debug( "Order received : " + order );
   }

}
