package com.hnb.bstructure.datastore;

import com.hnb.bstructure.api.IRestApi;
import com.hnb.bstructure.api.RestAPI;
import com.hnb.bstructure.datastore.IDataStore;
import com.hnb.bstructure.model.Product;

import java.util.Collection;

/**
 * Created by USER on 9/9/2015.
 */
public class APIWrapper implements IDataStore
{

    RestAPI restAPI;

    public APIWrapper()
    {
        restAPI = new RestAPI();
    }

    public void getProductList(final ProductListCallback callback)
    {
        restAPI.getProductList(new IRestApi.ProductListCallback()
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
        restAPI.getUserById(id, new IRestApi.ProductDetailCallback()
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

    public  void insertProduct(Product product, InsertProductDetailCallback callback)
    {

    }

    private void putProductsToCache(Collection<Product> collection)
    {

    }

    private void putProductToCache(Product product)
    {

    }


}
