package org.launchcode.liftoffproject.models;

public class Utility {

   public int sizeOf(Iterable<?> item) {
       int counter = 0;
       for (Object i : item) {
           counter++;
       }
       return counter;
   }
}
