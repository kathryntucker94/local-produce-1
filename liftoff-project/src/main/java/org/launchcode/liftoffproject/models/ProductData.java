package org.launchcode.liftoffproject.models;

import java.util.ArrayList;

public class ProductData {


    public static String getFieldValue(Product product, String fieldName){
        String theValue;

        if (fieldName.equals("product")){
            theValue = product.toString();
        } if (fieldName.equals("vendor")){
            theValue = product.getVendor().toString();
        } else{
            theValue = product.toString();
        }

        return theValue;
    }

    //    /**
//     * Search all Product fields for the given term.
//     *
//     * @param value The search term to look for.
//     * @param allProducts The list of products to search.
//     * @return      List of all products with at least one field containing the value.
//     */

    public static ArrayList<Product> findByValue(String value, Iterable<Product> allProducts) {
        String lower_val = value.toLowerCase();

        ArrayList<Product> results = new ArrayList<>();

        for (Product product : allProducts) {

            if (product.getType().toLowerCase().contains(lower_val)) {
                results.add(product);
            } else if (product.getName().toString().toLowerCase().contains(lower_val)) {
                results.add(product);
            } else if (product.getDescription().toLowerCase().contains(lower_val)) {
                results.add(product);
            } else if (product.getVendor().getLocation().toLowerCase().contains(lower_val)) {
                results.add(product);
            }else if (product.getVendor().getName().toLowerCase().contains(lower_val)) {
                results.add(product);
            }
        }

        return results;
    }

}
