package com.hnb.bstructure.repository;

import com.hnb.bstructure.datastore.APIWrapper;
import com.hnb.bstructure.datastore.IDataStore;
import com.hnb.bstructure.datastore.DBDataStore;
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
            APIWrapper productAPIWrapper = new APIWrapper();
            productAPIWrapper.getProductList(new APIWrapper.ProductListCallback()
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
            DBDataStore productDBDataStore = new DBDataStore();
            productDBDataStore.getProductList(new IDataStore.ProductListCallback()
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
            APIWrapper productAPIWrapper = new APIWrapper();
            productAPIWrapper.getProduct(id, new IDataStore.ProductDetailCallback()
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

            DBDataStore productDBDataStore = new DBDataStore();
            productDBDataStore.getProduct(id, new IDataStore.ProductDetailCallback()
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
