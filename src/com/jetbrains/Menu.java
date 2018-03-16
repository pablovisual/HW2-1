package com.jetbrains;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;

public class Menu
{
    private Scanner cin = new Scanner(System.in);

    public void carMaxMenu()
    {
        System.out.println("1.Log in");
        System.out.println("2.Sign up");
        System.out.println("3.Exit");
    }

    public void signUp(Customers cu)throws IOException
    {

        //Customers cu = new Customers("customer.txt");
        String inputID;
        String inputPASSWORD;
        String inputPWAgain;
        String inputFN;
        String inputLN;
        String inputEMAIL;

        while(true)
        {
            boolean check = true;
            System.out.print("Please input user id: ");
            inputID = cin.nextLine();

            for(int index = 0; index < cu.getNumOfMembers(); index++)
            {
                if (inputID.equals(cu.members[index].getID()))
                {
                    System.out.println("Username already taken!");
                    check = false;
                }
            }

            if(check)
                break;
        }

        System.out.print("Please input password: ");
        inputPASSWORD = cin.nextLine();

        //make sure passwords match.

        boolean match = false;
        while (!match)
        {
            System.out.print("Please input password again: ");
            inputPWAgain = cin.nextLine();

            if (inputPWAgain.equals(inputPASSWORD))
                match = true;

            else
            {
                System.out.println("Passwords don't match!");
                match = false;
            }
        }

        System.out.print("Please input your first name: ");
        inputFN = cin.nextLine();
        System.out.print("Please input your last name: ");
        inputLN = cin.nextLine();
        System.out.print("Please input your email: ");
        inputEMAIL = cin.nextLine();
        System.out.println("Thank you for your sign up!");

        String arr[] = {inputID, inputPASSWORD, inputFN, inputLN, inputEMAIL};

        cu.members[cu.getNumOfMembers()] = new Member(arr[0], arr[1], arr[2], arr[3], arr[4]);
        cu.setNumOfMembers(cu.getNumOfMembers() + 1);
    }

    public void logIn(Customers cu, Inventory iv)throws IOException
    {
        boolean check = false;
        while(!check)
        {
            System.out.print("\nPlease input your user id: ");
            String userInput = cin.nextLine();
            System.out.print("Please input password: ");
            String userPW = cin.nextLine();

            for(int index = 0; index < cu.getNumOfMembers(); index++)
            {
                if (userInput.equals(cu.members[index].getID()) && userPW.equals(cu.members[index].getPW()) && !(userInput.equals("admin") && userPW.equals("adminpass")))
                {
                    System.out.println("\nWelcome back " + cu.members[index].getFirstName() + " " + cu.members[index].getLastName() + "!\n");
                    inventoryMenu(iv);
                    System.out.println("\nBye~ " + cu.members[index].getFirstName() + " " + cu.members[index].getLastName() + "\n");
                    check = true;
                    break;
                }

                else if(userInput.equals("admin") && userPW.equals("adminpass"))
                {
                    System.out.println("\nWelcome back " + cu.members[index].getFirstName() + " " + cu.members[index].getLastName() + "!\n");
                    administrationAction(iv, cu);
                    check = true;
                    break;
                }

                else
                {
                    System.out.println("Incorrect password or user name!");
                    check = false;
                }
            }
        }
    }

    public void inventoryMenu(Inventory iv)
    {
        while(true)
        {
            System.out.println("1. Display inventory");
            System.out.println("2. Sort all cars");
            System.out.println("3. Log out\n");

            System.out.print("Please input your choice: ");
            int choice = cin.nextInt();
            cin.nextLine(); //gets rid of trailing new-line(\n) character.

            if (choice == 1)
            {
                newOldMenu();
                System.out.print("Please input your choice: ");
                choice = cin.nextInt();

                if (choice == 1)
                {
                    //this will display the cars info that are new(symbol Y)
                    /*for(int index = 0; index < iv.getNumOfMembers(); index++)
                    {
                        if(cu.members[index].)
                    }*/
                    System.out.println();
                }

                else if (choice == 2)
                {
                    //this will display the cars info that are used(that has the symbol N)
                    System.out.println("\nthere");
                }
            }

            else if(choice == 2)
            {
                sortCarInfoMenu();
                //sort all the cars;
                System.out.print("Please input your choice: ");
                choice = cin.nextInt();
                cin.nextLine();

                if(choice == 1)
                {
                    //iv.displayCars();
                    DecimalFormat df = new DecimalFormat("#.00");
                    System.out.printf("%-15s", "VIN");
                    System.out.printf("%-10s", "Brand");
                    System.out.printf("%-10s", "Model");
                    System.out.printf("%-8s", "Year");
                    System.out.printf("%-10s", "Mileage");
                    System.out.printf("%-10s", "Price");
                    System.out.printf("%-10s", "Color");
                    System.out.println("New");

                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-15s", iv.cars[count].getVin());
                        System.out.printf("%-10s", iv.cars[count].getBrand());
                        System.out.printf("%-10s", iv.cars[count].getModel());
                        System.out.printf("%-8s", iv.cars[count].getYear());
                        System.out.printf("%-10s", iv.cars[count].getMileage());
                        System.out.printf("%-10s", df.format(iv.cars[count].getPrice()));
                        System.out.printf("%-10s", iv.cars[count].getColor());
                        System.out.println(iv.cars[count].isBrandNew());
                    }
                }

                else if(choice == 2)
                {
                    //iv.displayCars();
                    DecimalFormat df = new DecimalFormat("#.00");
                    System.out.printf("%-15s", "VIN");
                    System.out.printf("%-10s", "Brand");
                    System.out.printf("%-10s", "Model");
                    System.out.printf("%-8s", "Year");
                    System.out.printf("%-10s", "Mileage");
                    System.out.printf("%-10s", "Price");
                    System.out.printf("%-10s", "Color");
                    System.out.println("New");

                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-15s", iv.cars[count].getVin());
                        System.out.printf("%-10s", iv.cars[count].getBrand());
                        System.out.printf("%-10s", iv.cars[count].getModel());
                        System.out.printf("%-8s", iv.cars[count].getYear());
                        System.out.printf("%-10s", iv.cars[count].getMileage());
                        System.out.printf("%-10s", df.format(iv.cars[count].getPrice()));
                        System.out.printf("%-10s", iv.cars[count].getColor());
                        System.out.println(iv.cars[count].isBrandNew());
                    }
                }

                else if(choice == 3)
                {
                    //iv.displayCars();
                    DecimalFormat df = new DecimalFormat("#.00");
                    System.out.printf("%-15s", "VIN");
                    System.out.printf("%-10s", "Brand");
                    System.out.printf("%-10s", "Model");
                    System.out.printf("%-8s", "Year");
                    System.out.printf("%-10s", "Mileage");
                    System.out.printf("%-10s", "Price");
                    System.out.printf("%-10s", "Color");
                    System.out.println("New");

                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-15s", iv.cars[count].getVin());
                        System.out.printf("%-10s", iv.cars[count].getBrand());
                        System.out.printf("%-10s", iv.cars[count].getModel());
                        System.out.printf("%-8s", iv.cars[count].getYear());
                        System.out.printf("%-10s", iv.cars[count].getMileage());
                        System.out.printf("%-10s", df.format(iv.cars[count].getPrice()));
                        System.out.printf("%-10s", iv.cars[count].getColor());
                        System.out.println(iv.cars[count].isBrandNew());
                    }
                }

                else if(choice == 4)
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

                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-15s", iv.cars[count].getVin());
                        System.out.printf("%-10s", iv.cars[count].getBrand());
                        System.out.printf("%-10s", iv.cars[count].getModel());
                        System.out.println();
                    }
                        iv.sortYear();
                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-10s", iv.cars[count].getMileage());
                        System.out.printf("%-10s", df.format(iv.cars[count].getPrice()));
                        System.out.printf("%-10s", iv.cars[count].getColor());
                        System.out.println(iv.cars[count].isBrandNew());
                    }

                }

                else if(choice == 5)
                {
                    //iv.displayCars();
                    DecimalFormat df = new DecimalFormat("#.00");
                    System.out.printf("%-15s", "VIN");
                    System.out.printf("%-10s", "Brand");
                    System.out.printf("%-10s", "Model");
                    System.out.printf("%-8s", "Year");
                    System.out.printf("%-10s", "Mileage");
                    System.out.printf("%-10s", "Price");
                    System.out.printf("%-10s", "Color");
                    System.out.println("New");

                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-15s", iv.cars[count].getVin());
                        System.out.printf("%-10s", iv.cars[count].getBrand());
                        System.out.printf("%-10s", iv.cars[count].getModel());
                        System.out.printf("%-8s", iv.cars[count].getYear());
                        System.out.printf("%-10s", iv.cars[count].getMileage());
                        System.out.printf("%-10s", df.format(iv.cars[count].getPrice()));
                        System.out.printf("%-10s", iv.cars[count].getColor());
                        System.out.println(iv.cars[count].isBrandNew());
                    }
                }

                else if(choice == 6)
                {
                    //iv.displayCars();
                    DecimalFormat df = new DecimalFormat("#.00");
                    System.out.printf("%-15s", "VIN");
                    System.out.printf("%-10s", "Brand");
                    System.out.printf("%-10s", "Model");
                    System.out.printf("%-8s", "Year");
                    System.out.printf("%-10s", "Mileage");
                    System.out.printf("%-10s", "Price");
                    System.out.printf("%-10s", "Color");
                    System.out.println("New");

                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-15s", iv.cars[count].getVin());
                        System.out.printf("%-10s", iv.cars[count].getBrand());
                        System.out.printf("%-10s", iv.cars[count].getModel());
                        System.out.printf("%-8s", iv.cars[count].getYear());
                        System.out.printf("%-10s", iv.cars[count].getMileage());
                        System.out.printf("%-10s", df.format(iv.cars[count].getPrice()));
                        System.out.printf("%-10s", iv.cars[count].getColor());
                        System.out.println(iv.cars[count].isBrandNew());
                    }
                }

                else if(choice == 7)
                {
                    //iv.displayCars();
                    DecimalFormat df = new DecimalFormat("#.00");
                    System.out.printf("%-15s", "VIN");
                    System.out.printf("%-10s", "Brand");
                    System.out.printf("%-10s", "Model");
                    System.out.printf("%-8s", "Year");
                    System.out.printf("%-10s", "Mileage");
                    System.out.printf("%-10s", "Price");
                    System.out.printf("%-10s", "Color");
                    System.out.println("New");

                    for(int count = 0; count < iv.getNumOfCars(); count++)
                    {
                        System.out.printf("%-15s", iv.cars[count].getVin());
                        System.out.printf("%-10s", iv.cars[count].getBrand());
                        System.out.printf("%-10s", iv.cars[count].getModel());
                        System.out.printf("%-8s", iv.cars[count].getYear());
                        System.out.printf("%-10s", iv.cars[count].getMileage());
                        System.out.printf("%-10s", df.format(iv.cars[count].getPrice()));
                        System.out.printf("%-10s", iv.cars[count].getColor());
                        System.out.println(iv.cars[count].isBrandNew());
                    }
                }

                else
                    System.out.println("Please choice from the menu above!!!");
            }

            else if(choice == 3)
                break;

            else
                System.out.println("Please pick a number from the menu screen!!!");
        }
    }

    public void newOldMenu()
    {
        System.out.println("\n1. New");
        System.out.println("2. Used\n");
    }

    public void sortCarInfoMenu()
    {
        System.out.println("1. Sort by VIN");
        System.out.println("2. Sort by Brand");
        System.out.println("3. Sort by Model");
        System.out.println("4. Sort by Year");
        System.out.println("5. Sort by Mileage");
        System.out.println("6. Sort by Price");
        System.out.println("7. Sort by Color");
    }

    public void administrationMenu()
    {
        System.out.println("1. Display inventory");
        System.out.println("2. Add Car");
        System.out.println("3. Delete Car");
        System.out.println("4. Update Car");
        System.out.println("5. Display Customer");
        System.out.println("6. Add Customer");
        System.out.println("7. Delete Customer");
        System.out.println("8. Update Customer");
        System.out.println("9. Logout\n");
    }

    public void administrationAction(Inventory iv, Customers cu) throws IOException
    {
        String id;
        String passw;//password
        String fn;//first name
        String ln;//last name
        String email;

        String vin = "";
        String brand = "";
        String mod = ""; //model
        int year = 0;
        int mile = 0; //mileage
        double price = 0.0;
        char color = ' ';
        char olnew = ' '; //old or new

        String str[] = {vin, brand, mod};
        int num[] = {year, mile};
        double decimal[] = {price};
        char letter[] = {color, olnew};
        while(true)
        {
            administrationMenu();
            System.out.print("Please input your choice: ");
            int choice = cin.nextInt();
            cin.nextLine();
            System.out.println();

            if(choice == 1)
                iv.displayCars();

            else if(choice == 2)
            {
                System.out.print("VIN: ");
                vin = cin.nextLine();
                System.out.print("Brand: ");
                brand = cin.nextLine();
                System.out.print("Model: ");
                mod = cin.nextLine();
                System.out.print("Year: ");
                year = cin.nextInt();
                System.out.print("Mileage: ");
                mile = cin.nextInt();
                System.out.print("Price: ");
                price = cin.nextDouble();
                System.out.print("Color: ");
                color = cin.next().charAt(0);
                System.out.print("New: ");
                olnew = cin.next().charAt(0);

                DecimalFormat df = new DecimalFormat("#.00");
                System.out.printf("%-15s", "VIN");
                System.out.printf("%-10s", "Brand");
                System.out.printf("%-10s", "Model");
                System.out.printf("%-8s", "Year");
                System.out.printf("%-10s", "Mileage");
                System.out.printf("%-10s", "Price");
                System.out.printf("%-10s", "Color");
                System.out.println("New");

                System.out.printf("%-15s", vin);
                System.out.printf("%-10s", brand);
                System.out.printf("%-10s", mod);
                System.out.printf("%-8s", year);
                System.out.printf("%-10s", mile);
                System.out.printf("%-10s", df.format(price));
                System.out.printf("%-10s", color);
                System.out.println(olnew);
                System.out.println("\nSuccess, this car has been added.\n");



                iv.cars[iv.getNumOfCars()] = new Car(str[0], str[1], str[2], num[0], num[1], decimal[0], letter[0], letter[1]);
                iv.setNumOfCars(iv.getNumOfCars() + 1);

                iv.displayCars();
                System.out.println();
            }

            else if(choice == 3)
                return;

            else if(choice == 4)
            {
                iv.displayCars();
                System.out.println();

                System.out.print("Please input VIN: ");
                vin = cin.nextLine();
                System.out.println();

                for(int index = 0; index < iv.getNumOfCars(); index++)
                {
                    if(vin.equals(iv.cars[index].getVin()))
                    {
                        updateCar();
                        System.out.println();

                        System.out.print("Please selection an option: ");
                        choice = cin.nextInt();
                        cin.nextLine();
                        System.out.println();

                        if(choice == 1)
                        {
                            System.out.print("Please input brand: ");
                            brand = cin.nextLine();
                            str[1] = brand;
                            iv.cars[iv.getNumOfCars()] = new Car(str[0], str[1], str[2], num[0], num[1], decimal[0], letter[0], letter[1]);
                            System.out.println("It's updated. Thank you.\n");
                            iv.displayCars();
                        }

                        else if(choice == 2)
                        {
                            System.out.print("Please input model: ");
                            mod = cin.nextLine();
                            System.out.println("It's updated. Thank you.\n");
                        }

                        else if(choice == 3)
                        {
                            System.out.print("Please input year: ");
                            year = cin.nextInt();
                            System.out.println("It's updated. Thank you.\n");
                        }

                        else if(choice == 4)
                        {
                            System.out.print("Please input mileage: ");
                            mile = cin.nextInt();
                            System.out.println("It's updated. Thank you.\n");
                        }

                        else if(choice == 5)
                        {
                            System.out.print("Please input price: ");
                            price = cin.nextDouble();
                            System.out.println("It's updated. Thank you.\n");
                        }

                        else if(choice == 6)
                        {
                            System.out.print("Please input color: ");
                            color = cin.next().charAt(0);
                            System.out.println("It's updated. Thank you.\n");
                        }
                    }

                    else
                        System.out.println("Could not find the VIN in our database.\n");
                }
            }

            else if(choice == 5)
                cu.displayCustomers();

            else if(choice == 6)
                signUp(cu);

            else if(choice == 7)
                return;

            else if(choice == 8)
            {
                cu.displayCustomers();
                System.out.println();

                System.out.print("Please input ID: ");
                id = cin.nextLine();
                System.out.println();

                for(int count = 0; count < cu.getNumOfMembers(); count++)
                {
                    if(id.equals(cu.members[count].getID()))
                    {
                        updateCustomer();
                        System.out.println();

                        System.out.print("Please input your choice: ");
                        choice = cin.nextInt();
                        System.out.println();

                        if(choice == 1)
                        {
                            System.out.print("Please input new password: ");
                            passw = cin.nextLine();

                            cu.displayCustomers();
                        }

                        else if(choice == 2)
                        {
                            System.out.print("Please input new first name: ");
                            fn = cin.nextLine();

                            cu.displayCustomers();
                        }

                        else if(choice == 3)
                        {
                            System.out.print("Please input new last name: ");
                            ln = cin.nextLine();

                            cu.displayCustomers();
                        }

                        else if(choice == 4)
                        {
                            System.out.print("Please input new email: ");
                            email = cin.nextLine();

                            cu.displayCustomers();
                        }
                    }

                    else
                        System.out.println("Sorry no Id found in our database.\n");
                }

            }

            else if(choice == 9)
                break;

            else
                System.out.println("Please choose what's above.");
        }
    }

    public void updateCar()
    {
        System.out.println("1. Update Brand");
        System.out.println("2. Update Model");
        System.out.println("3. Update Year");
        System.out.println("4. Update Mileage");
        System.out.println("5. Update Price");
        System.out.println("6. Update Color");
    }

    public void updateCustomer()
    {
        System.out.println("1. Update Password");
        System.out.println("2. Update First Name");
        System.out.println("3. Update Last Name");
        System.out.println("4. Update Email");
    }
}