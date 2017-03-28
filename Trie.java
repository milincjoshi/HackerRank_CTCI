import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Trie {
    
    //new code
    Node head;

	public Trie(){
		head = new Node('*');
	}
	class Node{
		Character c;
		HashMap<Character, Node> hm;
		Boolean isCompleteWord;
		
		public Node(char c){
			this.c = c;
			hm = new HashMap<Character, Node>();
		}
	}

	public void addString(String s){

		Node head = this.head;

		Node node = head;

		for(int i=0; i<s.length();i++){
			char c = s.charAt(i);
			
			HashMap<Character, Node> hm = node.hm;

			//node does not exist
			if(hm.get(c) == null){
				Node node_to_add = new Node(c);
				hm.put(c,node_to_add);
				node = node_to_add;
			}//node exists
			else{
				Node node_received = hm.get(c);
				node = node_received;
			}
            
            if(i == s.length()-1){
				node.isCompleteWord = true;
			}

		}

	}

    
    public void printTrie(String s){

        boolean found_contacts = true;
        
        Node node = head;
        HashMap<Character, Node> hm = node.hm;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            //System.out.println(c);
            if(hm.get(c) == null){
                found_contacts = false;
                break;
            }
            else{
                node = hm.get(c);
                hm = node.hm;                
            }
        }
        
        //
        if(!found_contacts){
            System.out.println(0);
        }
        else{
        
            ArrayList<Node> node_list = new ArrayList<Node>();
            node_list.add(node);
            int i=0,count=0;
            while(i<node_list.size()){
                //System.out.println(node_list.get(i).c);
                hm = node_list.get(i).hm;
                //System.out.print(node_list.get(i).c);
                for(Character c : hm.keySet()){
                    node_list.add(hm.get(c));
                }
                if(node_list.get(i).isCompleteWord != null && node_list.get(i).isCompleteWord){
                     count++;
                }
                i++;
            }

            System.out.println(count);
        }
	}
	
    //end new node
    
    
    public static void main(String[] args) {
        
        Trie trie = new Trie();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
        
            if(op.equals("add")){
                trie.addString(contact);
            }
            if(op.equals("find")){
                trie.printTrie(contact);                
            }
        
        }
        
        
        
    }
}
