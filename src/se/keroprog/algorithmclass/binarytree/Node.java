package se.keroprog.algorithmclass.binarytree;

/**
 * Node class for Algorithm and Data Structures assignment
 * Created by Kristoffer on 2016-11-16.
 */
public class Node {

    Item item;
    Node left, right;

    Node(int value){
        this.item = new Item(value);
        this.left = null;
        this.right = null;
    }

    void insert(int value) {
        if (value < this.item.value){
            if (this.left == null) this.left = new Node(value);
            else left.insert(value);
        } else if (value > this.item.value){
            if (this.right == null) this.right = new Node(value);
            else right.insert(value);
        } else if (value == this.item.value) item.amount++;
    }

    void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.println(item.value);
        if (right!= null) right.printInOrder();

    }

    void printPreOrder() {
        System.out.println(item.value);
        if (left != null) left.printPreOrder();
        if (right!= null) right.printPreOrder();
    }

    void printInOrderWithAmount(){
        if (left != null) left.printInOrderWithAmount();
        System.out.println(item.value + " * " + item.amount);
        if (right!= null) right.printInOrderWithAmount();
    }

    void printPostOrder() {
        if (left!= null) left.printPostOrder();
        if (right!= null) right.printPostOrder();
        System.out.println(item.value);
    }

    int findAmountOf(int value) {

        if (value == this.item.value) return item.amount;
        if (this.left == null && this.right == null) return 0;
        if (this.left != null && value < this.item.value) return left.findAmountOf(value);
        if (this.right != null && value > this.item.value) return right.findAmountOf(value);
        return 0;
    }

    int findTotalSum() {
        int tempLeft = 0, tempRight = 0;
        if (this.left == null && this.right == null) return this.item.value * this.item.amount;
        if (this.left != null) tempLeft = left.findTotalSum();
        if (this.right != null) tempRight = right.findTotalSum();

        return this.item.value * this.item.amount + tempLeft + tempRight;

    }

    boolean balance() {
        int leftLevel = 0, rightLevel = 0;

        if (this.left == null && this.right == null) return true; // Node is a leaf
        if (this.left != null && this.right != null) { // Node has two children
            return  (this.left.balance() && this.right.balance()); // Returns true if both children are balanced, otherwise false
        }
        // Node has only one child
        if (this.right == null) leftLevel = this.left.levels(); // check to the left
        if (this.left == null) rightLevel = this.right.levels(); // check to the right

        // Returns the true/false of levels differing by more than 1
        return Math.abs(leftLevel - rightLevel) < 2;
    }

    int levels() {
        int leftLevel = 0, rightLevel = 0;

        if (this.left == null && this.right == null) return 1;

        if (this.left != null) leftLevel =  this.left.levels() + 1;
        if (this.right != null) rightLevel = this.right.levels() +1;

        return leftLevel >= rightLevel ? leftLevel : rightLevel;
    }
}
