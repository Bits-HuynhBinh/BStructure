package com.hnb.bstructure.dbcontroller;

import com.hnb.bstructure.api.FakeData;
import com.hnb.bstructure.data.IProductDataStore;
import com.hnb.bstructure.model.Product;

import java.util.List;

/**
 * Created by USER on 9/9/2015.
 */
public class ProductDBDataStore implements IProductDataStore
{

    public ProductDBDataStore()
    {

    }

    public void getProductList(ProductListCallback callback)
    {
        try
        {
            List<Product> listProducts = FakeData.getListProduct();
            if (listProducts != null)
            {
                callback.onLoaded(listProducts);
            }
            else
            {
                callback.onError(new Exception());
            }

        }
        catch (Exception ex)
        {
            callback.onError(new Exception());
        }

    }


    public void getProduct(String id, ProductDetailCallback callback)
    {
        try
        {
            Product product = FakeData.getProductDetail(id);
            if (product != null)
            {
                callback.onLoaded(product);
            }
            else
            {
                callback.onError(new Exception());
            }
        }
        catch (Exception ex)
        {
            callback.onError(new Exception());
        }
    }
}
