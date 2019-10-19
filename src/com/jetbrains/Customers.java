package com.jetbrains;

import java.io.*;
import java.util.Scanner;
public class Customers
{
    private int numOfMembers;
    Member members[];

    public Customers(String fileName)throws IOException
    {
        //Read customers.txt and initialize Member array
        File inputFile = new File(fileName);
        Scanner cin = new Scanner(inputFile);
        members = new Member[1_000];
        int index = 0;

        while (cin.hasNext())
        {
            // Read customers.txt and initialize Member array
            String elements[] = cin.nextLine().split("/");
            members[index] = new Member(elements[0], elements[1], elements[2], elements[3], elements[4]);
            index++;
        }

        numOfMembers = index;
        cin.close();
    }

    public void displayCustomers()
    {
        System.out.println("xxxxxxxxxxx "+ numOfMembers);
        System.out.printf("%-10s" ,"Id");
        System.out.printf("%-13s", "Password");
        System.out.printf("%-15s", "FirstName");
        System.out.printf("%-14s", "LastName");
        System.out.println("Email");

        for(int index = 0; index < numOfMembers; index++)
        {
            System.out.printf("%-10s" ,members[index].getID());
            System.out.printf("%-13s" ,members[index].getPW());
            System.out.printf("%-15s" ,members[index].getFirstName());
            System.out.printf("%-14s" ,members[index].getLastName());
            System.out.println(members[index].getEmail());
        }
    }

    public void updateCustomersFile(String fileName)throws IOException
    {
        //Overwrite customers.txt with Member array
        FileWriter FW = new FileWriter(fileName, true);
        PrintWriter PW = new PrintWriter(FW);

        //write users to file.
        for(int index = numOfMembers - 1; index < numOfMembers; index++)//index is set to numOfMembers - 1 in order to add the new line of string
        {
            PW.print("\n" + members[index].getID() + "/");
            PW.print(members[index].getPW() + "/");
            PW.print(members[index].getFirstName() + "/");
            PW.print(members[index].getLastName() + "/");
            PW.println(members[index].getEmail());
        }
        PW.close();
    }

    public void setNumOfMembers(int num){ numOfMembers = num; }
    public int getNumOfMembers(){ return this.numOfMembers; }

}
