package com.jetbrains;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Inventory
{
    int numOfCars;
    Car cars[];

    public Inventory(String fileName) throws IOException
    {
        //Read inventory.txt and initialize Car array
        File inputFile = new File(fileName);
        Scanner cin = new Scanner(inputFile);
        int index = 0;
        cars = new Car[1_000];

        while(cin.hasNext())
        {
            // Read inventory.txt and initialize Car array
            String elements[] = cin.nextLine().split("/");
            cars[index] = new Car(elements[0], elements[1], elements[2], Integer.parseInt(elements[3])
                    , Integer.parseInt(elements[4]), Double.parseDouble(elements[5]),
                    elements[6].charAt(0), elements[7].charAt(0));
            index++;
        }

        numOfCars = index;
        cin.close();
    }

    public void displayCars()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.printf("%-15s", "VIN");
        System.out.printf("%-10s", "Brand");
        System.out.printf("%-10s", "Model");
        System.out.printf("%-8s", "Year");
        System.out.printf("%-10s", "Mileage");
        System.out.printf("%-10s", "Price");
        System.out.printf("%-10s", "Color");
        System.out.println("New");

        for(int count = 0; count < numOfCars; count++)
        {
            System.out.printf("%-15s", cars[count].getVin());
            System.out.printf("%-10s", cars[count].getBrand());
            System.out.printf("%-10s", cars[count].getModel());
            System.out.printf("%-8s", cars[count].getYear());
            System.out.printf("%-10s", cars[count].getMileage());
            System.out.printf("%-10s", df.format(cars[count].getPrice()));
            System.out.printf("%-10s", cars[count].getColor());
            //System.out.println(cars[count].isBrandNew());
            if(cars[count].isBrandNew())
                System.out.println('Y');

            else
                System.out.println('N');
        }
    }

    public void updateInventoryFile(String fileName)throws IOException
    {
        //Overwrite inventory.txt with Car array
        FileWriter FW = new FileWriter(fileName, true);
        PrintWriter PW = new PrintWriter(FW);
        //PW.println(cars);
        for(int index = numOfCars - 1; index < numOfCars; index++)//index is set to numOfCars - 1 in order to add the new line of string
        {
            PW.print("\n" + cars[index].getVin() + "/");
            PW.print(cars[index].getBrand() + "/");
            PW.print(cars[index].getModel() + "/");
            PW.print(cars[index].getYear() + "/");
            PW.print(cars[index].getMileage() + "/");
            PW.print(cars[index].getPrice() + "/");
            PW.print(cars[index].getColor() + "/");
            PW.println(cars[index].isBrandNew());
        }
        PW.close();
    }

    public int[] selSort(int arr[])
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }

        return arr;
    }

    public void sortYear()
    {
        int arr[] = new int[getNumOfCars()];
        for(int index = 0; index < arr.length; index++)
            arr[index] = cars[index].getYear();

        arr = selSort(arr);

        for(int i = 0; i < arr.length; i++)
            System.out.printf("%-8s", arr[i]);
    }

    public void setNumOfCars(int num) { numOfCars = num; }
    public int getNumOfCars() {return this.numOfCars; }
}