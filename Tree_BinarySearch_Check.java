/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

int counter = 0;

ArrayList<Node> main_list;

void printInOrder(Node node){
    
   
    
    if(node.left != null){
         if(node.left.data > node.data ){
            counter = 1;
         }
         printInOrder(node.left);    
    }
    main_list.add(node);
    if(node.right != null){
        if( node.right.data < node.data){
            counter = 1;
        }
        printInOrder(node.right);   
    }
}

boolean checkBST(Node root) {
    
        main_list = new ArrayList<Node>();
    
        Node node = root;
        printInOrder(node);

        for(int i=0; i<main_list.size()-1; i++){
            if(main_list.get(i).data>=main_list.get(i+1).data){
                return false;
            }
        }

    /*
        if(counter == 0){
            return true;
        }
        else{
            return false;
        }
    */
    
    return true;
    
}
