package com.hnb.bstructure.cloudcontroller;

import com.hnb.bstructure.api.RestAPI;
import com.hnb.bstructure.data.IProductDataStore;
import com.hnb.bstructure.model.Product;

import java.util.Collection;

/**
 * Created by USER on 9/9/2015.
 */
public class ProductCloudDataStore implements IProductDataStore
{

    RestAPI restAPI;

    public ProductCloudDataStore()
    {
        restAPI = new RestAPI();
    }

    public void getProductList(final ProductListCallback callback)
    {
        restAPI.getProductList(new RestAPI.ProductListCallback()
        {
            @Override
            public void onLoaded(Collection<Product> collection)
            {
                callback.onLoaded(collection);
                putProductsToCache(collection);
            }

            @Override
            public void onError(Exception exception)
            {
                callback.onError(exception);
            }
        });
    }


    public void getProduct(String id, final ProductDetailCallback callback)
    {
        restAPI.getUserById(id, new RestAPI.ProductDetailCallback()
        {
            @Override
            public void onLoaded(Product product)
            {
                callback.onLoaded(product);
                putProductToCache(product);
            }

            @Override
            public void onError(Exception exception)
            {
                callback.onError(exception);
            }
        });

    }

    private void putProductsToCache(Collection<Product> collection)
    {

    }

    private void putProductToCache(Product product)
    {

    }


}
