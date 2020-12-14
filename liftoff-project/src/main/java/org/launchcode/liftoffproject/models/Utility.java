package org.launchcode.liftoffproject.models;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import java.util.HashMap;

public class Utility {

   static HashMap<String, String> searchChoices = new HashMap<>();

   public Utility (){
       searchChoices.put("all", "All");
       searchChoices.put("type", "Type");
       searchChoices.put("location", "Location");
       searchChoices.put("vendor", "Vendor");
   }

}
