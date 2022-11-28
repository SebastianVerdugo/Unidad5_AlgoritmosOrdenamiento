package OrdenamientoBurbujaEDD;

import java.util.Random;
import java.util.Scanner;

public class OrdenamientoBurbuja {
	void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
 
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
    	System.out.println("Algoritmo ordenamiento burbuja");
    	System.out.println();
        OrdenamientoBurbuja ob = new OrdenamientoBurbuja();
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
        ob.printArray(arr);
        
        long inicio= System.currentTimeMillis();
        ob.bubbleSort(arr);
        long fin= System.currentTimeMillis();
        System.out.println("\nArray ordenado:");
        ob.printArray(arr);
        long tiempo = fin-inicio;
        System.out.println("El algoritmo tardo en ejecutarse: "+tiempo+" milisegundos");
    }
}
