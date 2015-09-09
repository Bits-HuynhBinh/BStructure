package com.hnb.bstructure.api;

import com.hnb.bstructure.model.Product;

import java.util.Collection;

/**
 * Created by HuynhBinh on 9/9/15.
 */
public interface IRestApi
{

    public interface ProductListCallback
    {
        void onLoaded(Collection<Product> collection);

        void onError(Exception exception);
    }


    public interface ProductDetailCallback
    {
        void onLoaded(Product product);

        void onError(Exception exception);
    }

    public interface InsertProductDetailCallback
    {
        void onSuccess(Product product);

        void onError(Exception exception);
    }
}
