package com.hnb.bstructure.api;

import com.hnb.bstructure.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuynhBinh on 9/8/15.
 */
public class FakeData
{

    public static List<Product> getListProduct()
    {
        List<Product> productList = new ArrayList<>();

        Product product = new Product();
        product.setId("I00001");
        product.setName("Macbook air");
        product.setDescription("Mac book air description......");
        product.setPrice(1000.00);
        product.setBrand("Apple");
        productList.add(product);


        product = new Product();
        product.setId("I00002");
        product.setName("Nexus 5 2015");
        product.setDescription("Nexus 5 2015 description......");
        product.setPrice(500.00);
        product.setBrand("Google");
        productList.add(product);


        product = new Product();
        product.setId("I00003");
        product.setName("Surface 2014");
        product.setDescription("Surface 2014 description......");
        product.setPrice(1200.00);
        product.setBrand("Microsoft");
        productList.add(product);


        product = new Product();
        product.setId("I00004");
        product.setName("Asus zend book pro");
        product.setDescription("Asus zend book pro 2015555 description......");
        product.setPrice(1500.00);
        product.setBrand("Asus");
        productList.add(product);


        return productList;
    }


    public static Product getProductDetail(String id)
    {
        Product product = new Product();
        product.setId("I00001");
        product.setName("Macbook air");
        product.setDescription("Mac book air description......");
        product.setPrice(1000.00);
        product.setBrand("Apple");
        return product;


    }

}
