package org.launchcode.liftoffproject.models;

import java.util.ArrayList;

public class ProductData {

    public static ArrayList<Product> findByColumnAndValue(String column, String value, Iterable<Product> allProducts) {

        ArrayList<Product> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return (ArrayList<Product>) allProducts;
        }

        if (column.equals("all")){
            results = findByValue(value, allProducts);
            return results;
        }
        for (Product product : allProducts) {

            String aValue = getFieldValue(product, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(product);
            }
        }

        return results;
    }

    public static String getFieldValue(Product product, String fieldName){
        String theValue;

        if (fieldName.equals("name")){
            theValue = product.getName();
        } if (fieldName.equals("vendor")){
            theValue = product.getVendor().toString();
        } else{
            theValue = product.toString();
        }

        return theValue;
    }

    public static ArrayList<Product> findByValue(String value, Iterable<Product> allProducts) {
        String lower_val = value.toLowerCase();

        ArrayList<Product> results = new ArrayList<>();

        for (Product product : allProducts) {

            if (product.getType().toLowerCase().contains(lower_val)) {
                results.add(product);
            } else if (product.getName().toString().toLowerCase().contains(lower_val)) {
                results.add(product);
            } else if (product.getVendor().toString().toLowerCase().contains(lower_val)) {
                results.add(product);
            } else if (product.toString().toLowerCase().contains(lower_val)) {
                results.add(product);
            }

        }

        return results;
    }

}
