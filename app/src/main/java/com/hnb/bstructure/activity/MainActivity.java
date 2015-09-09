package com.hnb.bstructure.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hnb.bstructure.R;
import com.hnb.bstructure.model.Product;
import com.hnb.bstructure.usecase.GetProductListUseCase;

import java.util.Collection;


public class MainActivity extends ActionBarActivity
{

    Button btnLoadAll;
    TextView txtData;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView()
    {
        btnLoadAll = (Button) findViewById(R.id.btnLoadAll);
        txtData = (TextView) findViewById(R.id.txtData);


        btnLoadAll.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                GetProductListUseCase getProductListUseCase = new GetProductListUseCase();
                getProductListUseCase.execute(new GetProductListUseCase.Callback()
                {
                    @Override
                    public void onProductListLoaded(Collection<Product> productList)
                    {

                        StringBuilder stringBuider = new StringBuilder();
                        for (Product pro : productList)
                        {
                            stringBuider.append(pro.toString());
                        }
                        txtData.setText(stringBuider.toString());
                    }

                    @Override
                    public void onError(Exception exception)
                    {
                        txtData.setText(exception.getMessage());
                    }
                });
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
