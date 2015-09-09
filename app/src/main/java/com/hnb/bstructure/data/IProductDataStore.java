package com.hnb.bstructure.data;

import com.hnb.bstructure.model.Product;

import java.util.Collection;

/**
 * Created by USER on 9/9/2015.
 */
public interface IProductDataStore
{
    interface ProductListCallback
    {
        void onLoaded(Collection<Product> collection);

        void onError(Exception exception);
    }

    interface ProductDetailCallback
    {
        void onLoaded(Product product);

        void onError(Exception exception);
    }

}
