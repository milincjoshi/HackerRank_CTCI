//Stacks: Balanced Brackets 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Stacks_Balanced_Brackets {

    class Stack{
        
        //1 member
        Node top;
        
        //2 member
        class Node{
            char data;
            Node next;
        }
        
        public void push(char c){
            if(top == null){
                Node node = new Node();
                node.data = c;
                top = node;
            }
            else{
                Node node = new Node();
                node.data = c;
                
                node.next = top;
                top = node;
            }
        }
        
        public Node pop(){
            if(top == null){
                throw new EmptyStackException();
            }
            else{
                Node node = top;
                top = top.next;
                
                return node;
            }
            
        }
        
        public char peek(){
            return top.data;
        }
        
        public boolean isEmpty(){
            return top == null;
        }

    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        Solution solution = new Solution();
        int a0;
        for(a0 = 0; a0 < t; a0++){
            Solution.Stack stack = solution.new Stack();
            String s = in.next();
        
            boolean flag = false;
            
            char[] characters = s.toCharArray();
  
            for(char c : characters){
                
                if(c == '(' || c == '{' || c == '['){
                    stack.push(c);                
                }
                if(c == ')' || c == '}' || c == ']'){
                   
                   if(!stack.isEmpty()){
                       char d = stack.peek();
                       if(c == ')' && d == '('){stack.pop();//System.out.println(d+" - popped"); 
                                               }
                       else if(c == '}' && d == '{'){stack.pop(); //System.out.println(d+" - popped"); 
                                               }
                       else if(c == ']' && d == '['){stack.pop();// System.out.println(d+" - popped"); 
                                               }      
                       
                       else{
                           stack.push(c);
                       }
                       
                   }
                   else{
                       stack.push(c);
                   }
                }
        
            }
                   
            if(stack.isEmpty()){
                   flag = true;
            }
            else{
                flag = false;
            }
            
            if(flag){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            
        }//end for test cases
        
        
        
        
    }
}
