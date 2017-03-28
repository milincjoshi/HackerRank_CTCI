import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Primality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            
            boolean isPrime = true;
            for(int i=2; i*i<=n;i++){
                if(n%i == 0){
                    isPrime = false;
                    break;
                }
            }
            
            if(n<2){
                System.out.println("Not prime");
            }
            else if(isPrime){
                System.out.println("Prime");
            }
            else{
                System.out.println("Not prime");                
            }
            
        }
    }
}
