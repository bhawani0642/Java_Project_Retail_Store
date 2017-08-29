package com.SpencerHomeAppliancesShop;
import java.util.*;
public class MyShop{
        
    public static RetailStore store;
    
     public static void main(String []args){
        boolean bOpenShop = true;
        System.out.println("Welcome to Spencer Home Appliances SHOP");
        System.out.println("----------------------------");
        
        
        if (!bOpenShop){
            System.out.println("- SHOP IS CLOSED-");
            return;
        }
        
        /*Here open the store*/
        store = new RetailStore("Spencer Home Appliances SHOP");
        
        /* stock the products in the store*/
        store.addProduct("LG Television T101","",200,4);
        store.addProduct("LG Refrigerator R601","",300,4);
        store.addProduct("LG Micro Oven M701","",400,4);
        store.addProduct("Sony 24 inch TV","",500,20);
        
        /* open the shop*/
        openShop();
        
     }
     
    /* display main menu*/
    public static void openShop()
    {
        String custName = "";
        String prodName = "";
        int prodQuantityNeeded=0;
        int prodQuantityAvailable=0;
        int custContact =0;
        int confirmBooking=0;
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        
        List<String> menuList  = new ArrayList<String>();
        //Adding the products 
        menuList.add("LG Television T101");
        menuList.add("LG Refrigerator R601");
        menuList.add("LG Micro Oven M701");
        menuList.add("LG Micro Oven M701");
        menuList.add("Samsung Galaxy Phone");
        
        int n=-1;
        
        while (n != 6)
        {
            clearScreen();
        
            /* display menu options */
            
            System.out.println("\n\nPLEASE ENTER THE PRODUCT YOU WANT TO BOOK");
            System.out.println("\n\n");
            
            System.out.println("1. " + menuList.get(0) + " (" + store.checkProductAvailability(menuList.get(0)) + " )");
            System.out.println("2. " + menuList.get(1)+ " (" + store.checkProductAvailability(menuList.get(1)) + " )");
            System.out.println("3. " + menuList.get(2)+ " (" + store.checkProductAvailability(menuList.get(2)) + " )");
            System.out.println("4. " + menuList.get(3)+ " (" + store.checkProductAvailability(menuList.get(3)) + " )");
            System.out.println("5. " + menuList.get(4)+ " (" + store.checkProductAvailability(menuList.get(4)) + " )");/* a non-existing product for testing*/
            System.out.println("6. CLOSE SHOP");
            System.out.println("\n\nPlease select product number: ");
            n = reader.nextInt();
            
            if (n==6){
                System.out.println("\n\n THANK YOU. GOOD BYE.");
                return;
            }
            
            if (n >=1 && n<=5)
            {
                prodName = (String)menuList.get(n-1);
                System.out.println("\n\nProduct: " + prodName);
                System.out.println("\n\nProvide Customer Name: ");
                
                custName = readString();
                
                System.out.println("\n\nProvide Customer Contact: ");
                
                custContact = readInteger();
                
                System.out.println("\n\nProvide Quantity: ");
                prodQuantityNeeded = readInteger();
                
                int customerID = store.addCustomer(custName,custContact);
                
                
                /*print order*/
                clearScreen();
                System.out.println("\n\n\n\n\n\nDear customer " + custName );
                System.out.println("Your phone number is " + custContact);
                System.out.println("Your ordered " + prodQuantityNeeded + " of " + prodName );
                
                prodQuantityAvailable =
                                store.checkProductAvailability(menuList.get(n-1));
                
                System.out.println("\n\nAvailable Quantity: " + prodQuantityAvailable);
                
                
                Product p;
                for (int i=0,TotalProdAddedToCustList=0;i<store.productList.size();i++)
                {
                    p= store.productList.get(i);
                    if (p.productName == prodName)
                    {
                        TotalProdAddedToCustList++;
                        if (TotalProdAddedToCustList <= prodQuantityAvailable && TotalProdAddedToCustList<=prodQuantityNeeded )
                            (store.getCustomer(customerID)).bookedProductList.add(p);
                    }
                }
                double netAmnt = store.calculateNetAmount(customerID,10);
                
                /*System.out.println("\n\nNet Amount:" + netAmnt);*/
                System.out.println("\n\nConfirm Booking: 1=Yes,0=No:");
                
                confirmBooking = readInteger();
                if (confirmBooking == 1)
                {
                    if (prodQuantityNeeded >= prodQuantityAvailable)
                        store.bookProduct(customerID,prodName,prodQuantityAvailable);
                    else
                        store.bookProduct(customerID,prodName,prodQuantityNeeded);

                    System.out.print("\n\nThank you for booking");
                    System.out.print("\n\nContinue");
                    
                    String s = reader.nextLine();
                }
                if (confirmBooking == 0)
                {
                    System.out.print("\n\nThank you. Visit Again");
                    System.out.print("\n\nContinue");
                    String s = reader.nextLine();
                }
                
                n=-1; //reinitialize
                
            } //menu option selected n>=1 and n<=5
        }//back to shop
    }//end openShop
    
    
    /* clears the console*/
    public static void clearScreen() {  
            System.out.print("\033[H\033[2J");  
            System.out.print("\f");  
            System.out.flush();  
    }//end clearScreen

    /* read the string*/
    public static String readString() {  
                String str="";
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                boolean breadLine = false;
                while (breadLine==false) {
                       str = reader.nextLine();
                       if (str.length() >0)
                            breadLine = true;
                }
                return str;
        }
    /* read the integer*/
    public static int readInteger() {  
                int number=-1;
                
                Scanner reader = new Scanner(System.in);  // Reading from System.in
                boolean breadLine = false;
                while (breadLine==false) {
                       number  = reader.nextInt();
                       if (number>=0)
                            breadLine = true;
                }
                return number;
        }
}