package org.launchcode.liftoffproject.models;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

public class Utility {

   public int sizeOf(Iterable<?> item) {
       int counter = 0;
       for (Object i : item) {
           counter++;
       }
       return counter;
   }


}
