package se.keroprog.algorithmclass.binarytree;

/**
 * Tree class for Algorithm and Data Structures assignment
 * Created by Kristoffer on 2016-11-16.
 */
public class Tree {
    private Node root;

    public Tree(){
        root = null;
    }

    public void insert(int value){
        if(root == null){
            root = new Node(value);
        }else {
            root.insert(value);
        }
    }

    public void printInOrder(){

        root.printInOrder();

    }

    public void printPreOrder(){
        root.printPreOrder();
    }

    public void printInOrderWithAmount(){
        root.printInOrderWithAmount();
    }

    public void printPostOrder(){
        root.printPostOrder();
    }

    public boolean delete(int value){
        // If null root
        if(root == null)
            return false;

        // If value in root
        if (root.item.value == value) {
            if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else // has two children
            root.item = getAt(root); // Replaces root's item with the next highest value in Tree
            return true;
        }
        // If value not in root
        Node parent = root;
        Node current = root;
        while (current.item.value != value){ // finding the value in Tree
            parent = current;
            if (value < current.item.value){     // is it left?
                if (current.left == null) return false; // value is not in Tree
                current = current.left;
            }
            else {                          // or is it right?
                if (current.right == null) return false; // value is not in Tree
                current = current.right;
            }
        }
        // value found

        if (current == parent.left){ // is current the left node of parent?

            if (current.left == null) parent.left = current.right;
            else if (current.right == null) parent.left = current.left;
            else // two children
                current.item = getAt(current);
            return true;
        }
        if (current == parent.right){ // or is it the right node of parent?
            if (current.left == null) parent.right = current.right;
            else if (current.right == null) parent.right = current.left;
            else //two children
                current.item = getAt(current);
            return true;
        }
        return false;
    }

    public Item getAt(Node parent){

        Node current = parent.right;
        // Find the closest higher number
        if (current.left == null) {
            parent.right = current.right;
            return current.item;
        }
        while (current.left != null){
            parent = current;
            current = current.left;
        }
        parent.left = current.right; // Links the right of the deleted node to its previous position as parent.left
        return current.item;
    }

    public int findAmountOf(int value){

        int amount = root.findAmountOf(value);
        System.out.println(value + " appears " + amount + " times");
        return amount;
    }

    public int findTotalSum(){

        int sum =  root.findTotalSum();


        return sum;
    }

    public int levels(){
        if(root == null) return 0;
        return root.levels();
    }

    public boolean balance(){
        if (root == null)
            return true;
        return root.balance();
    }


    public void flush() {
        root = null;
    }
}
