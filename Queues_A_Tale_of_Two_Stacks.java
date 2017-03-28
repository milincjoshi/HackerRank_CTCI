//Queues: A Tale of Two Stacks 

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TwoStacks<T>{
	
	Stack<T> inbox;
	Stack<T> outbox;

	public TwoStacks(){

		inbox = new Stack<T>();
		outbox = new Stack<T>();

	}
	class Stack<T>{
		
		Node top;
		
		class Node{
			T data;
			Node next;			
		}

		public void push(T data){
			Node node = new Node();
			node.data = data;
			if(top == null){
				top = node;
			}
			else{
				node.next = top;
				top = node; // assign top to node
			}
		}

		public Node pop(){
			Node node = top;
			top = top.next;
			return node;
		}

		public T peek(){
			return top.data;
		}

		public boolean isEmpty(){
			if(top == null){
				return true;
			}
			else{
				return false;
			}
		}
	}
	
	public void inqueue(T i){
		inbox.push(i);
		
	}
	
	public Stack.Node dequeue() throws NullPointerException {

		if(outbox.top == null && inbox.top == null){
			System.out.println("Empty Stacks");
			return null;
		}
		if(outbox.top == null){
			

			while(inbox.top != null){
				Stack.Node node_to_insert = inbox.pop();
				outbox.push((T)node_to_insert.data);
			}

			Stack.Node node = outbox.pop();
			return node;

		}
		else{

			Stack.Node node = outbox.pop();
			return node;
	
		}

	}

	public T peek(){
        
        if(outbox.top == null){
		
            while(inbox.top != null){
				Stack.Node node_to_insert = inbox.pop();
				outbox.push((T)node_to_insert.data);
			}

			Stack.Node node = outbox.top;
			return (T)node.data;

		}
		return outbox.peek();
	}

	public static void main(String[] args){

		TwoStacks<Integer> twoStacks = new TwoStacks<Integer>();


		//

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                //queue.enqueue(scan.nextInt());
    			twoStacks.inqueue(scan.nextInt());

            } else if (operation == 2) { // dequeue
				twoStacks.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(twoStacks.peek());
            }
        }
        scan.close();
		//

		
	
	}
}