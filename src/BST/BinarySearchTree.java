package BST;

public class BinarySearchTree {
    private TreeNode<Integer> root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public void insert(int val){
        var newNode = new TreeNode<Integer>(val);

        if(root == null){
            root = newNode;
            size += 1;
            return;
        }

        var currentNode = root;
        while (true) {

            if(currentNode.value.equals(newNode.value)){
                return;
            }

            if (newNode.value < currentNode.value){
                if (currentNode.left != null){
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = newNode;
                    break;
                }
            }  else {
                if (currentNode.right != null){
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = newNode;
                    break;
                }
            }
        }

        size += 1;
        return;
    }

    public boolean find(int val){
        if(root == null){
            return false;
        }

        var currentNode = root;
        while (currentNode != null) {

            if(currentNode.value == val){
                return true;
            }

            if (currentNode.value < val){
                currentNode = currentNode.left;
            }  else {
                currentNode = currentNode.right;
            }
        }

        return false;
    }

    private boolean isLeafNode(TreeNode<Integer> node){
        var nextLeftNode = node.left;
        var nextRightNode = node.right;
        return nextLeftNode == null && nextRightNode == null;
    }

    public void delete(int val){
        if(root == null){
            return;
        }

        var currentNode = root;
        TreeNode<Integer> parentNode = null;

        while (currentNode != null && currentNode.value != val) {
            parentNode = currentNode;

            if (val < currentNode.value){
                currentNode = currentNode.left;
            }  else {
                currentNode = currentNode.right;
            }
        }


        if(currentNode == null){
            return;
        }



        size--;

        if(isLeafNode(currentNode)){
            if(currentNode.value.equals(root.value)){
                root = null;
                return;
            }

            if (parentNode == null){
                return;
            }

            if(currentNode.value < parentNode.value){
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }

        } else if(currentNode.left == null) {
            if(currentNode.value.equals(root.value)){
                root = currentNode.right;
                return;
            }

            if (parentNode == null){
                return;
            }

            if(currentNode.value < parentNode.value){
                parentNode.left = currentNode.right;
            } else {
                parentNode.right = currentNode.right;
            }

        } else if (currentNode.right == null) {
            if(currentNode.value.equals(root.value)){
                root = currentNode.left;
                return;
            }

            if (parentNode == null){
                return;
            }

            if(currentNode.value < parentNode.value){
                parentNode.left = currentNode.left;
            } else {
                parentNode.right = currentNode.left;
            }
        } else {
            var smallestNodeFromRight = findLeast(currentNode.right);

            delete(smallestNodeFromRight.value);

            if(currentNode.value.equals(root.value)){
                root.value = smallestNodeFromRight.value;;
            } else if(parentNode != null) {
                parentNode.value = smallestNodeFromRight.value;
            }
        }
    }

    private TreeNode<Integer> findLeast(TreeNode<Integer> node){
        var temp = node;

        while(temp.left != null){
            temp = temp.left;
        }

        return temp;
    }

    public void printTree(TreeNode<Integer> current, int depth) {

        if (current != null) {
            printTree(current.right, depth + 1);
            for (int i = 0; i < depth; i++)
                System.out.print("   ");
            System.out.println(current.value);
            printTree(current.left, depth + 1);
        }

    }

    public void display(){
        printTree(root, 0);
    }
}
