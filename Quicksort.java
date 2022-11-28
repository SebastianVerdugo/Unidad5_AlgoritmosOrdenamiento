package QuicksortEDD;

import java.util.Random;
import java.util.Scanner;

public class Quicksort {
 
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
  
    static int partition(int[] arr, int low, int high)
    {
  
        int pivot = arr[high];
  
        int i = (low - 1);
  
        for (int j = low; j <= high - 1; j++) {
  
            if (arr[j] < pivot) {
  
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
  
    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
 
            int pi = partition(arr, low, high);
  
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
  
    static void printArray(int[] arr, int size)
    {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
  
        System.out.println();
    }
  
    public static void main(String[] args)
    {
    	System.out.println("Algoritmo Quicksort");
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
        printArray(arr, n);
        long inicio= System.currentTimeMillis();
        quickSort(arr, 0, n - 1);
        long fin= System.currentTimeMillis();
        System.out.println("\nArray ordenado: ");
        printArray(arr, n);
        long tiempo = fin-inicio;
        System.out.println("El algoritmo tardo en ejecutarse: "+tiempo+" milisegundos");
    }

}
