//Arrays: Left Rotation 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution_Array_Left_Rotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
      
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            b[i] = a[i];
        }
        
        if(k<n){
            k = n-k;
            for(int i=0; i<n; i++){
                if(k>=n){k=0;}
                a[k] = b[i];
                k++;                
            }
        }
        else if (k == n){
            return a;
        }
        else{
            k = k-n+1;
            for(int i=0; i<n; i++){
                if(k>=n){k=0;}
                a[k] = b[i];
                k++;                
            }
            
        }
        
        return a;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
