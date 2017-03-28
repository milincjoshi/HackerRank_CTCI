import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sorting_Bubble_Sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        
        int swaps = 0;
        
        for(int i=0; i<n;i++){
            for(int j=0; j<n;j++){
                if(a[i]>a[j] && i<j){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                    swaps++;
                }
            }            
        }
        
        System.out.println("Array is sorted in "+swaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }
}
