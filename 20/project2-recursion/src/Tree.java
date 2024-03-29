// ******************ERRORS********************************
// Throws UnderflowException as appropriate

import java.sql.SQLOutput;
import java.util.ArrayList;

class UnderflowException extends RuntimeException {
    /**
     * Construct this exception object.
     *
     * @param message the error message.
     */
    public UnderflowException(String message) {
        super(message);
    }
}

public class Tree<E extends Comparable<? super E>> {
    private BinaryNode<E> root;  // Root of tree
    private String treeName;     // Name of tree

    /**
     * Create an empty tree
     *
     * @param label Name of tree
     */
    public Tree(String label) {
        treeName = label;
        root = null;
    }

    /**
     * Create tree from list.  Sets root to tree.
     *
     * @param nodeValues List of elements
     * @param label      Name of tree
     * @ordered true if want an ordered tree
     */
    public Tree(E[] nodeValues, String label, boolean ordered) {
        treeName = label;
        if (ordered) {
            root = null;
            for (int i = 0; i < nodeValues.length; i++) {
                bstInsert(nodeValues[i]);
            }
        } else {
            root = buildUnordered(nodeValues, 0, nodeValues.length - 1);
        }
    }


    /**
     * Build a NON BST tree by inorder
     *
     * @param nodeValues nodes to be added
     * @return root of new tree
     */
    private BinaryNode<E> buildUnordered(E[] nodeValues, int low, int high) {
        if (low > high) return null;
        int mid = (low + high) / 2;
        BinaryNode<E> curr = new BinaryNode<>(nodeValues[mid], null, null);
        curr.left = buildUnordered(nodeValues, low, mid - 1);
        curr.right = buildUnordered(nodeValues, mid + 1, high);
        return curr;
    }


    /**
     * Change name of tree
     *
     * @param name new name of tree
     */
    public void changeName(String name) {
        this.treeName = name;
    }

    /**
     * Return a string displaying the tree contents as a single line
     */
    public String toString() {
        if (root == null)
            return treeName + " Empty tree";
        else
            return treeName + toString(root, "");
    }

    private String toString(BinaryNode<E> node, String space){
        if (node == null) return "";
        String left = toString(node.left, space+"    ")+"\n";
        String right = toString(node.right, space+"    ")+"\n";
        return space + right + space+node.element + space + left;
    }

    /**
     * Return a string displaying the tree contents as a single line
     */
    public String toString2() {
        if (root == null)
            return treeName + " Empty tree";
        else
            return treeName + " " + toString2(root);
    }

    /**
     * Internal method to return a string of items in the tree in order
     * This routine runs in O(n)
     *
     * @param t the node that roots the subtree.
     */
    public String toString2(BinaryNode<E> t) {
        if (t == null) return "";
        StringBuilder string = new StringBuilder();
        string.append(toString2(t.left));
        string.append(t.element.toString() + " ");
        string.append(toString2(t.right));
        return string.toString();
    }


    /**
     * The complexity of finding the deepest node is O(n)
     *
     * @return the value of the node at the deepest level
     */
    public int deepestNode() {
        if (root==null) return 0;
        int level = 0;
        return deepestNode(root, level);
    }

    private int deepestNode(BinaryNode<E> node, int level){
        if (node == null) return 0;
        int right = deepestNode(node.right, level + 1);
        int left = deepestNode(node.left, level + 1);
        if (left > right) {
            return left;
        }else if (right > left){
            return right;
        }else{
            return (Integer)node.element;
        }

    }

    /**
     * The complexity of finding the flip is O(n)
     * reverse left and right children recursively
     */
    public void flip() {
        flip(root);
    }

    private void flip(BinaryNode<E> node) {
        if (node != null){
            BinaryNode<E> temp = node.right;
            node.right = node.left;
            node.left = temp;
            flip(node.left);
            flip(node.right);
        }
    }

    /**
     * Counts number of nodes in specified level
     * The complexity of nodesInLevel is O(2^n)
     *
     * @param level Level in tree, root is level zero
     * @return count of number of nodes at specified level
     */
    public int nodesInLevel(int level) {
        if (root == null) return 0;
        if (level == 0) return 1;
        return nodesInLevel(root, level, 0);
    }

    private int nodesInLevel(BinaryNode<E> node, int level, int currLvl){
        if (node == null) return 0;
        if (currLvl == level){
            return 1;
        }
        return nodesInLevel(node.left, level, currLvl+1) + nodesInLevel(node.right, level, currLvl+1);
    }

    /**
     * Print all paths from root to leaves
     * The complexity of printAllPaths is O(n)
     */
    public void printAllPaths() {
        if (root == null){
            System.out.println("Tree is empty");
        }
        printAllPaths(root, "");
    }

    private void printAllPaths(BinaryNode<E> node, String path){
        if (node == null){
            return;
        }
        path += node.element + " ";
        if (node.left == null && node.right == null){
            System.out.println(path);
        }
        printAllPaths(node.right, path);
        printAllPaths(node.left, path);
    }


    /**
     * Counts all non-null binary search trees embedded in tree
     * The complexity of countBST is O(n)
     *
     * @return Count of embedded binary search trees
     */
    public Integer countBST() {
        if (root == null) return 0;
        int count = 0;
        return countBST((BinaryNode<Integer>) root, count);
    }

    private int countBST(BinaryNode<Integer> node, int count){
        if (node == null) return 0;
        if (node.left == null || node.right == null) return 0;
        if (node.right.element > node.element && node.left.element < node.element){
            count += 1;
        }
        return count + countBST(node.left, count) + countBST(node.right, count);
    }

    /**
     * Insert into a bst tree; duplicates are allowed
     * The complexity of bstInsert depends on the tree.  If it is balanced the complexity is O(log n)
     *
     * @param x the item to insert.
     */
    public void bstInsert(E x) {

        root = bstInsert(x, root);
    }

    /**
     * Internal method to insert into a subtree.
     * In tree is balanced, this routine runs in O(log n)
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<E> bstInsert(E x, BinaryNode<E> t) {
        if (t == null)  //The pledge
            return new BinaryNode<E>(x, null, null);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = bstInsert(x, t.left);
        } else {
            t.right = bstInsert(x, t.right);
        }
        return t;
    }

    /**
     * Determines if item is in tree
     *
     * @param item the item to search for.
     * @return true if found.
     */
    public boolean contains(E item) {
        return contains(item, root);
    }

    /**
     * Internal method to find an item in a subtree.
     * This routine runs in O(log n) as there is only one recursive call that is executed and the work
     * associated with a single call is independent of the size of the tree: a=1, b=2, k=0
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains(E x, BinaryNode<E> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else {
            return true;    // Match
        }
    }

    /**
     * Remove all paths from tree that sum to less than given value
     * @param sum: minimum path sum allowed in final tree
     */
    public void pruneK(Integer sum) {
        root = (BinaryNode<E>) pruneK((BinaryNode<Integer>) root, sum);
    }

    private BinaryNode<Integer> pruneK(BinaryNode<Integer> node, Integer sum) {
        if (node == null) return null;

        sum -= node.element;
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                return node;
            } else {
                return null;
            }
        }
        node.left = pruneK(node.left, sum);
        node.right = pruneK(node.right, sum);

        if (node.left == null && node.right == null && sum == 0) {
            return node;
        }

        if (node.left == null && node.right == null) {
            return null;
        }
        return node;
    }


    /**
     * Build tree given inOrder and preOrder traversals.  Each value is unique
     *
     * @param inOrder  List of tree nodes in inorder
     * @param preOrder List of tree nodes in preorder
     */
    public void buildTreeTraversals(E[] inOrder, E[] preOrder) {
        root = null;
    }

    /**
     * Find the least common ancestor of two nodes
     *
     * @param a first node
     * @param b second node
     * @return String representation of ancestor
     /
    public String lca(BinaryNode<E> t, E a, E b) {
        return null;
    }

     * We ensure the tree is an Integer tree (for sum makes sense)
     * @return integer representing sum of all nodes
     */
    public Integer sumAll() {
        BinaryNode<Integer> r = (BinaryNode<Integer>) root;
        return sumAll(r);
    }

    /**
     * Sum the elements of the tree
     * @param t root of subtree to be summed
     * @return integer representing sum of all nodes
     */
    public Integer sumAll(BinaryNode<Integer> t) {
        return t.element + sumAll(t.right)+ sumAll(t.left);
    }

    /**
     * Find tghe least Common ancester of nodes with values a and b
     * @param a First node value
     * @param b Second node value
     * @return value of node which is the least common ancestor
     */
    public E lca(E a, E b) {
        if (root == null) return null;
        return lca(root, a, b);
    }

    private E lca(BinaryNode<E> node, E a, E b){
        if (node == null) return null;
        if (node.element.equals(a) || node.element.equals(b)) return node.element;
        E rightlca = lca(node.right, a, b);
        E leftlca = lca(node.left, a, b);
        if (rightlca != null && leftlca != null){
            return root.element;
        } else if(leftlca != null){
            return leftlca;
        } else{
            return rightlca;
        }
    }

    /**
     * Balance the tree
     */
     public void balanceTree() {
         ArrayList<Integer> nodes = new ArrayList<>();
         balanceTree(root, nodes);
         int count = nodes.size();
         Integer[] vals = new Integer[count];
         for(int i=0; i<count; i++) {
             vals[i] = nodes.get(i);
         }

         Tree<Integer> tree = new Tree<Integer>(vals, treeName,false);
         root = (BinaryNode<E>) tree.root;
    }

    private void balanceTree(BinaryNode<E> t, ArrayList<Integer> nodes){
        if (t==null) return;

        balanceTree(t.left, nodes);
        nodes.add((Integer)t.element);
        balanceTree(t.right, nodes);


    }


    /**
     * In a BST, keep only nodes between range
     * @param a lowest value
     * @param b highest value
     */
    public void keepRange(int a, int b) {
        keepRange(null, root, a, b);
    }

    private void keepRange(BinaryNode<E> parent, BinaryNode<E>node, int a, int b){
        if (node == null) return;
        if (a > (Integer)node.element || b<(Integer)node.element){
            deleteNode(parent, node);
        }
        keepRange(node, node.left, a, b);
        keepRange(node, node.right, a, b);
    }

    private void deleteNode(BinaryNode<E> parent, BinaryNode<E> node){
        if (node.left == null){
            replace(parent, node, node.right);
        } else if (node.right == null) {
            replace(parent, node, node.left);
        }else{
            node.element= findMin(node);
            minNode(node, node.right);
        }
    }

    private E findMin(BinaryNode<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.element;
    }
    private void minNode(BinaryNode<E> parent, BinaryNode<E> node){
        if (node.left == null) {
            replace(parent, node, node.right);
        } else {
            minNode(node, node.left);
        }
    }


    private void replace(BinaryNode<E> parent, BinaryNode<E> oldKid, BinaryNode<E> newKid){
        if (parent.left == oldKid){
            parent.left = newKid;
        }
        if (parent.right == oldKid){
            parent.right = newKid;
        }
    }

    // Basic node stored in unbalanced binary  trees
    public static class BinaryNode<E> {
        E element;            // The data in the node
        BinaryNode<E> left;   // Left child
        BinaryNode<E> right;  // Right child

        // Constructors
        BinaryNode(E theElement) {
            this(theElement, null, null);
        }

        BinaryNode(E theElement, BinaryNode<E> lt, BinaryNode<E> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }

        /**
         * StringBuilder represents a mutable sequence of characters.  StringBuilder is faster than String.
         * @return String representation of BinaryNode
         */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node:");
            sb.append(element);
            return sb.toString();
        }

    }


}
