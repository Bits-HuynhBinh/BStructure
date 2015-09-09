package com.hnb.bstructure.api;

import com.hnb.bstructure.model.Product;

import java.util.Collection;
import java.util.List;

/**
 * Created by HuynhBinh on 9/8/15.
 */
public class RestAPI
{

    public RestAPI()
    {
    }


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


    public void getProductList(ProductListCallback callback)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("Callback cannot be null!!!");
        }

        if (isThereInternetConnection())
        {
            try
            {

                List<Product> listProducts = FakeData.getListProduct();

                callback.onLoaded(listProducts);
            }
            catch (Exception e)
            {
                callback.onError(new Exception(e.getCause()));
            }
        }
        else
        {
            callback.onError(new Exception());
        }
    }


    public void getUserById(final String userId, final ProductDetailCallback callback)
    {
        if (callback == null)
        {
            throw new IllegalArgumentException("Callback cannot be null!!!");
        }

        if (isThereInternetConnection())
        {
            try
            {
                Product product = FakeData.getProductDetail("1");
                callback.onLoaded(product);
            }
            catch (Exception e)
            {
                callback.onError(new Exception(e.getCause()));
            }
        }
        else
        {
            callback.onError(new Exception());
        }
    }

    private boolean isThereInternetConnection()
    {


        return true;
    }


}
