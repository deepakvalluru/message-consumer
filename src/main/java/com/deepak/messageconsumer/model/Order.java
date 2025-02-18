package com.deepak.messageconsumer.model;

import java.io.Serializable;

public class Order implements Serializable
{

   private static final long serialVersionUID = 1L;

   private String            orderNumber;
   private String            productId;
   private double            amount;
   private String            priority;

   /**
    * 
    */
   public Order()
   {

   }

   /**
    * @param orderNumber
    * @param productId
    * @param amount
    */
   public Order( String orderNumber, String productId, double amount, String priority )
   {
      super();
      this.orderNumber = orderNumber;
      this.productId = productId;
      this.amount = amount;
      this.priority = priority;
   }

   /**
    * @return the orderNumber
    */
   public String getOrderNumber()
   {
      return orderNumber;
   }

   /**
    * @param orderNumber the orderNumber to set
    */
   public void setOrderNumber( String orderNumber )
   {
      this.orderNumber = orderNumber;
   }

   /**
    * @return the productId
    */
   public String getProductId()
   {
      return productId;
   }

   /**
    * @param productId the productId to set
    */
   public void setProductId( String productId )
   {
      this.productId = productId;
   }

   /**
    * @return the amount
    */
   public double getAmount()
   {
      return amount;
   }

   /**
    * @param amount the amount to set
    */
   public void setAmount( double amount )
   {
      this.amount = amount;
   }

   /**
    * @return the priority
    */
   public String getPriority()
   {
      return priority;
   }

   /**
    * @param priority the priority to set
    */
   public void setPriority( String priority )
   {
      this.priority = priority;
   }

   @Override
   public String toString()
   {
      return "Order [orderNumber=" + orderNumber
             + ", productId="
             + productId
             + ", amount="
             + amount
             + ", priority="
             + priority
             + "]";
   }

}
