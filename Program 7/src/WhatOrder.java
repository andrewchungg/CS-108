
import java.util.Scanner;

public class WhatOrder {
   // TODO: Define a generic method called checkOrder() that 
   //       takes in four variables of generic type as arguments. 
   //       The return type of the method is integer
   
   public static <TheType extends Comparable<TheType>> int checkOrder(TheType a, TheType b, TheType c, TheType d){
      int flag = 0;
      if (a.compareTo(b) > 0 && b.compareTo(c) > 0 && c.compareTo(d) > 0) {
         flag = 1;
      }
      else if (a.compareTo(b) < 0 && b.compareTo(c) < 0 && c.compareTo(d) < 0){
         flag = -1;
      }
      return flag;
   }
   
      // Check the order of the input: return -1 for ascending, 
      // 0 for neither, 1 for descending



   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // Check order of four strings
      System.out.println("Order: " + checkOrder(scnr.next(), scnr.next(), scnr.next(), scnr.next())); 

      // Check order of four doubles
      System.out.println("Order: " + checkOrder(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble()));
   }
}