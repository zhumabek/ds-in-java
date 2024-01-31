import BST.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        var bst = new BinarySearchTree();


        bst.insert(10);
        bst.insert(13);
        bst.insert(5);
        bst.insert(2);
        bst.insert(11);
        bst.insert(16);
        bst.insert(7);
        bst.insert(1);

        bst.display();
        System.out.println("-----------------------------------------");
        bst.delete(2);
        bst.delete(7);
        bst.display();

        System.out.println("-----------------------------------------");
        bst.delete(10);
        bst.display();

        System.out.println("-----------------------------------------");
        bst.delete(13);
        bst.display();
    }
}