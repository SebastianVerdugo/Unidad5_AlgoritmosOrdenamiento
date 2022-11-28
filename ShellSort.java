package ShellsortEDD;

import java.util.Random;
import java.util.Scanner;

public class ShellSort {
	
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    int sort(int arr[])
    {
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < n; i += 1)
            {
                int temp = arr[i];
 
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
 
                arr[j] = temp;
            }
        }
        return 0;
    }
 
    public static void main(String args[])
    {
    	System.out.println("Algoritmo Shellsort");
    	System.out.println();
    	Scanner  sc= new Scanner (System.in);
     	Random na = new Random ();
    	System.out.print("Escriba la cantidad de datos que tendra el array:");
    	int n =sc.nextInt();
    	System.out.println();
        int arr[] = new int [n];
        for(int i=0; i<arr.length; i++)
        {
        	arr[i]= na.nextInt(n)+1;
        }
        
        System.out.println("\nArray original:");
        printArray(arr);
 

        ShellSort ob = new ShellSort();
        long inicio= System.currentTimeMillis();
        ob.sort(arr);
        long fin= System.currentTimeMillis();
        System.out.println("\nArray ordenado:");
        printArray(arr);
        long tiempo = fin-inicio;
        System.out.println("El algoritmo tardo en ejecutarse: "+tiempo+" milisegundos");
    }

}
