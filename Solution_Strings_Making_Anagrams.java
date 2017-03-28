//Strings: Making Anagrams 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution_Strings_Making_Anagrams  {
    public static int numberNeeded(String first, String second) {
       HashMap<Character,Integer> hm_first = new HashMap<Character,Integer>();
        HashMap<Character,Integer> hm_second = new HashMap<Character,Integer>();
        char[] charArray_first = first.toCharArray();
        char[] charArray_second = second.toCharArray();
        
        for(int i=0; i<charArray_first.length; i++){
            Integer x = hm_first.get(charArray_first[i]);
            if(x == null){
                hm_first.put(charArray_first[i], 1);
            }
            else{
                hm_first.put(charArray_first[i], x+1);                
            }
        }
        for(int i=0; i<charArray_second.length; i++){
            Integer x = hm_second.get(charArray_second[i]);
            if(x == null){
                hm_second.put(charArray_second[i], 1);
            }
            else{
                hm_second.put(charArray_second[i], x+1);                
            }
        }

        int count = 0;
      
        
        for(Character c : hm_first.keySet()){
            Integer a = hm_second.get(c);
            Integer b = hm_first.get(c);
                
                if(a == null && b != null){
                    count+=b;
                }
                if(b == null && a != null){
                    count+=a;
                }
                
                if( (a != null) && (b != null) && (Math.abs(a-b) > 0) ){
                    if(a>b){count+=(a-b); }
                    if(b>a){count+=(b-a);  }
                }
        
         }
        for(Character c : hm_second.keySet()){
            Integer a = hm_second.get(c);
            Integer b = hm_first.get(c);
                
                if(a == null && b != null){
                    count+=b;
                }
                if(b == null && a != null){
                    count+=a;
                }
                
                // if( (a != null) && (b != null) && (Math.abs(a-b) > 0) ){
                //     if(a>b){count+=(a-b); System.out.println("a>b for "+a+" "+b+" "+c+" "+b+" added");}
                //     if(b>a){count+=(b-a); System.out.println("b>a or b>afor "+a+" "+b+" "+c+" "+a+" added"); }
                // }
        
         }
        
        /*
            for(Character c : hm_first.keySet()){
            System.out.print(c+" "+hm_first.get(c)+" - ");
        }
        System.out.println();
        for(Character c : hm_second.keySet()){
            System.out.print(c+" "+hm_second.get(c)+" - ");
        }
        */
        
        //System.out.println("hm 2 "+hm_first.size());
        //System.out.println("hm 1 "+hm_second.size());
        //System.out.println("count "+count);
        return count;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
