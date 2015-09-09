package com.hnb.bstructure.model;

/**
 * Created by HuynhBinh on 9/8/15.
 */
public class Product
{
    private String id;
    private String name;
    private String description;
    private double price;
    private String brand;

    public Product()
    {

    }

    public Product(String id)
    {

    }


    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    @Override
    public String toString()
    {
        return "Product:\n" + this.getId() + "\n" + this.getName() + "\n" + this.getDescription() + "\n" + this.getPrice() + "\n\n";
    }
}
