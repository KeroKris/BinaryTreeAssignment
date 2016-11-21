package se.keroprog.algorithmclass.binarytree;

/**
 * Main and testing Class for Tree, containing tests for:
 * inserting
 * deleting
 * find amount
 * printing; inOrder, preOrder, postOrder
 * finding total sum of Tree values
 *
 */
public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();

        System.out.println("Inserting unbalanced Tree");
        tree.insert(15);
        tree.insert(10);
        tree.insert(7);
        tree.insert(5);
        tree.insert(30);
        tree.insert(17);
        tree.insert(55);

        System.out.println("Printing Tree, PreOrder");
        tree.printPreOrder();



        System.out.println("number of levels = " + tree.levels());
        System.out.println("Tree is balanced = " + tree.balance());

        System.out.println("\nFlushing Tree...\n");
        tree.flush();

        System.out.println("Inserting balanced Tree");
        tree.insert(15);
        tree.insert(7);
        tree.insert(10);
        tree.insert(5);
        tree.insert(30);
        tree.insert(17);
        tree.insert(55);

        System.out.println("Number of levels = " + tree.levels());
        System.out.println("Tree is balanced = " + tree.balance());

        //Testing the printouts
        System.out.println("\nPrinting Tree, InOrder");
        tree.printInOrder();
        System.out.println("\nPrinting Tree, PreOrder");
        tree.printPreOrder();
        System.out.println("\nPrinting Tree, PostOrder");
        tree.printPostOrder();
        System.out.println();

        // Testing the findAmount method, compare to print
        tree.findAmountOf(5);
        tree.findAmountOf(30);
        tree.findAmountOf(2);
        System.out.println();

        // Testing the inserting duplicates, findAmountOf, Printing with amount and findTotalSum
        System.out.println("Inserting 5 and 30");
        tree.insert(5);
        tree.insert(30);
        tree.findAmountOf(5);
        tree.findAmountOf(30);
        System.out.println("Printing Tree, InOrder with amount");
        tree.printInOrderWithAmount();
        System.out.println("Total sum of Tree is: " + tree.findTotalSum());

        // Testing deleting
        System.out.println("deleting 30");
        tree.delete(30);

        // Showing effects of deletion
        System.out.println();
        System.out.println("Printing Tree, InOrder with amount");
        tree.printInOrderWithAmount();

        tree.findAmountOf(30);
        System.out.println("Total sum of Tree is: " + tree.findTotalSum());

        System.out.println("\nDeleting root (15)");
        tree.delete(15);

        System.out.println("Tree in PreOrder:");
        tree.printPreOrder();
        System.out.println("Total sum of Tree is: " + tree.findTotalSum());


        System.out.println("\nHave a good day!");

        tree.flush();

        tree.insert(7);
        tree.insert(10);
        tree.insert(3);
        tree.insert(0);
        tree.insert(60);
        tree.insert(34);
        tree.insert(-198);
        tree.insert(54);
        tree.insert(24);
        tree.insert(-3);
        tree.insert(43);
        tree.insert(1);

        System.out.println(tree.balance());

    }
}
