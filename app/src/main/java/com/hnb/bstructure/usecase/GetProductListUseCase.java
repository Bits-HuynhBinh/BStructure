package com.hnb.bstructure.usecase;

import com.hnb.bstructure.model.Product;
import com.hnb.bstructure.repository.ProductRepository;
import com.hnb.bstructure.thread.BackgroundThreadExecutor;
import com.hnb.bstructure.thread.UIThreadExecutor;

import java.util.Collection;

/**
 * Created by USER on 9/9/2015.
 */
public class GetProductListUseCase implements Runnable
{
    public interface Callback
    {
        void onProductListLoaded(Collection<Product> productList);

        void onError(Exception exception);
    }


    ProductRepository productRepository;
    BackgroundThreadExecutor backgroundThreadExecutor;
    UIThreadExecutor uiThreadExecutor;

    Callback callback;


    public GetProductListUseCase()
    {
        productRepository = new ProductRepository();
        backgroundThreadExecutor = BackgroundThreadExecutor.getInstance();
        uiThreadExecutor = UIThreadExecutor.getInstance();
    }

    public void execute(Callback callback)
    {

        this.callback = callback;
        this.backgroundThreadExecutor.execute(this);

    }


    @Override
    public void run()
    {
        productRepository.getProductList(new ProductRepository.ProductListCallback()
        {
            @Override
            public void onLoaded(Collection<Product> collection)
            {
                notifySuccess(collection);
            }

            @Override
            public void onError(Exception exception)
            {
                notifyError(exception);
            }
        });
    }

    public void notifySuccess(final Collection<Product> productList)
    {
        this.uiThreadExecutor.post(new Runnable()
        {
            @Override
            public void run()
            {
                callback.onProductListLoaded(productList);
            }
        });
    }

    public void notifyError(final Exception ex)
    {
        this.uiThreadExecutor.post(new Runnable()
        {
            @Override
            public void run()
            {
                callback.onError(ex);
            }
        });
    }


}
