package com.hnb.bstructure.daocontroller;

import com.hnb.bstructure.api.FakeData;
import com.hnb.bstructure.model.Product;

import java.util.List;

/**
 * Created by HuynhBinh on 9/9/15.
 */
public class ProductController
{
    public static void insertProduct(Product product)
    {

    }

    public static List<Product> getProductList()
    {
        return FakeData.getListProduct();
    }

    public static Product getProduct(String id)
    {
        return FakeData.getProductDetail(id);
    }


}
