package com.hnb.bstructure.repository;

import com.hnb.bstructure.cloudcontroller.ProductCloudDataStore;
import com.hnb.bstructure.data.IProductDataStore;
import com.hnb.bstructure.dbcontroller.ProductDBDataStore;
import com.hnb.bstructure.model.Product;

import java.util.Collection;

/**
 * Created by USER on 9/9/2015.
 */
public class ProductRepository
{

    private static ProductRepository INSTANCE;

    public static synchronized ProductRepository getInstance()
    {
        if (INSTANCE == null)
        {
            INSTANCE = new ProductRepository();
        }
        return INSTANCE;
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


    public void getProductList(final ProductListCallback callback)
    {

        boolean isCached = true;

        if (isCached)
        {
            ProductCloudDataStore productCloudDataStore = new ProductCloudDataStore();
            productCloudDataStore.getProductList(new ProductCloudDataStore.ProductListCallback()
            {
                @Override
                public void onLoaded(Collection<Product> collection)
                {
                    callback.onLoaded(collection);
                }

                @Override
                public void onError(Exception exception)
                {
                    callback.onError(exception);
                }
            });
        }
        else
        {
            ProductDBDataStore productDBDataStore = new ProductDBDataStore();
            productDBDataStore.getProductList(new IProductDataStore.ProductListCallback()
            {
                @Override
                public void onLoaded(Collection<Product> collection)
                {
                    callback.onLoaded(collection);
                }

                @Override
                public void onError(Exception exception)
                {
                    callback.onError(exception);
                }
            });

        }


    }

    public void getProduct(String id, final ProductDetailCallback callback)
    {
        boolean isCached = true;
        if (isCached)
        {
            ProductCloudDataStore productCloudDataStore = new ProductCloudDataStore();
            productCloudDataStore.getProduct(id, new IProductDataStore.ProductDetailCallback()
            {
                @Override
                public void onLoaded(Product product)
                {
                    callback.onLoaded(product);
                }

                @Override
                public void onError(Exception exception)
                {
                    callback.onError(exception);

                }
            });
        }
        else
        {

            ProductDBDataStore productDBDataStore = new ProductDBDataStore();
            productDBDataStore.getProduct(id, new IProductDataStore.ProductDetailCallback()
            {
                @Override
                public void onLoaded(Product product)
                {
                    callback.onLoaded(product);
                }

                @Override
                public void onError(Exception exception)
                {
                    callback.onError(exception);
                }
            });

        }

    }
}
