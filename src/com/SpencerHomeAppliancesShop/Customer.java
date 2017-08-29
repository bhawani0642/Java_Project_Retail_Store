package com.SpencerHomeAppliancesShop;

import java.util.*;
public class Customer
{
    /*Customer should know about his
    customerID ,customerName, contactNumber and the details of
    products booked by the customer*/
    int customerID;
    String customerName;
    int contactNumber;
    List <Product>bookedProductList;
    
    /*The Constructor creates Customer object with the given id, name &
    contact no*/
    public Customer (int custID,String name,int contactNo)
    {
       customerID  = custID;
       customerName = name;
       contactNumber = contactNo;
       bookedProductList = new ArrayList<Product>();
    }
    
    
    /*
    Public void addBookedProduct(Product obj) :
    The method adds the product which is booked by the customer to
    his bookedProductList. */
    public void addBookedProduct(Product obj)
    {
        bookedProductList.add(obj);
    }
    
}