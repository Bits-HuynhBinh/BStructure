package com.hnb.bstructure.datastore;

import com.hnb.bstructure.api.FakeData;
import com.hnb.bstructure.daocontroller.ProductController;
import com.hnb.bstructure.datastore.IDataStore;
import com.hnb.bstructure.model.Product;

import java.util.List;

/**
 * Created by USER on 9/9/2015.
 */
public class DBDataStore implements IDataStore
{

    public DBDataStore()
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


    public void insertProduct(Product product, InsertProductDetailCallback callback)
    {
        try
        {
            ProductController.insertProduct(product);
            callback.onSuccess(product);
        }
        catch (Exception ex)
        {
            callback.onError(ex);

        }
    }
}
