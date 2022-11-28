package DualPivotQuicksortEDD;

import java.util.Random;
import java.util.Scanner;

public class DualPivotQuicksort {
	
	static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	 
	static void dualPivotQuickSort(int[] arr,
	                               int low, int high)
	{
	    if (low < high)
	    {
	         
	        int[] piv;
	        piv = partition(arr, low, high);
	         
	        dualPivotQuickSort(arr, low, piv[0] - 1);
	        dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
	        dualPivotQuickSort(arr, piv[1] + 1, high);
	    }
	}
	 
	static int[] partition(int[] arr, int low, int high)
	{
	    if (arr[low] > arr[high])
	        swap(arr, low, high);
	         
	    int j = low + 1;
	    int g = high - 1, k = low + 1,
	        p = arr[low], q = arr[high];
	         
	    while (k <= g)
	    {
	         
	        if (arr[k] < p)
	        {
	            swap(arr, k, j);
	            j++;
	        }
	         
	        else if (arr[k] >= q)
	        {
	            while (arr[g] > q && k < g)
	                g--;
	                 
	            swap(arr, k, g);
	            g--;
	             
	            if (arr[k] < p)
	            {
	                swap(arr, k, j);
	                j++;
	            }
	        }
	        k++;
	    }
	    j--;
	    g++;
	     
	    swap(arr, low, j);
	    swap(arr, high, g);
	 
	    return new int[] { j, g };
	}
	 
	// Driver code
	public static void main(String[] args)
	{
		System.out.println("Algoritmo Dual Pivot Quicksort");
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
	    for (int i = 0; i < arr.length; i++)
	        System.out.print(arr[i] + " ");
	    long inicio= System.currentTimeMillis();
	    dualPivotQuickSort(arr, 0, arr.length-1);
	    long fin= System.currentTimeMillis();
	    System.out.println("\nArray ordenado:");
	    for (int i = 0; i < arr.length; i++)
	        System.out.print(arr[i] + " ");
	         
	    System.out.println();
	    
        long tiempo = fin-inicio;
        System.out.println("El algoritmo tardo en ejecutarse: "+tiempo+" milisegundos");
	}

}
