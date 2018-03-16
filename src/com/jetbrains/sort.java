/*package com.jetbrains;

/*public class sort
{
    //selection sort
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

    public void sortYear(Inventory iv)
    {
        int arr[] = new int[iv.getNumOfCars()];
        for(int index = 0; index < arr.length; index++)
            arr[index] = iv.cars[index].getYear();

        arr = selSort(arr);

        for(int i = 0; i < arr.length; i++)
            System.out.printf("%-8s", arr[i]);
    }
}*/