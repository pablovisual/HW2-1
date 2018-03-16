package com.jetbrains;

import java.io.*;
import java.util.Scanner;
public class Main
{
    public static void main(String args[]) throws IOException
    {

        //read customer.txt content into array.
        //after you're done signing up. write array back into .txt file.
        Menu m = new Menu();
        int choice = 0;
        System.out.println("111");
        Scanner cin = new Scanner(System.in);
        System.out.println("222");
        Customers cu = new Customers("customer.txt");
        cu.displayCustomers();
        System.out.println("333");
        Inventory iv = new Inventory("inventory.txt");
        iv.displayCars();
        System.out.println("444");
        //iv.sortYear();
        //System.out.println("555");
        //display menu and implement functions
        System.out.println("Welcome to Carmax!\n");
        while(true)
        {
            m.carMaxMenu();
            System.out.print("\nPlease input your choice: ");
            choice = cin.nextInt();
            cin.nextLine(); //gets rid of trailing new-line(\n) character.

            if(choice == 1)
            {
                m.logIn(cu, iv);
            }

            else if(choice == 2)
            {
                m.signUp(cu);
                cu.displayCustomers();
            }

            else if(choice == 3)
                break;

            else
                System.out.println("Please choose one of the 3 choices!!!");
        }

        cu.updateCustomersFile("customer.txt");
        iv.updateInventoryFile("inventory.txt");
    }
}
