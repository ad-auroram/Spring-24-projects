
public class Queue<T extends Comparable<T>> {
    private Node root;

    public Queue() {
        root = null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void clear(){
        root=null;
    }

    public void insert(T item){
        root=merge(new Node(item), root);
    }
    public T delete(){
        if(isEmpty()){
            System.out.println("Queue is empty!");
            return null;
        }
        T min = root.element;
        root = merge(root.left, root.right);
        return min;
    }

    public void print(){
        print(root, "");
        System.out.println();
    }

    private void print(Node node, String indent){
        if (node != null){
            print(node.right, indent+"   ");
            System.out.println( indent+ node.element);
            print(node.left, indent+"   ");
        }
    }

    private Node merge (Node x, Node y){
        if (x==null) return y;
        if (y==null) return x;
        if (x.element.compareTo(y.element)>0){
            Node temp = x;
            x = y;
            y = temp;
        }
        x.right = merge(x.right, y);
        if (x.left == null) {
            x.left = x.right;
            x.right = null;
        }else{
            if (x.left.dist < x.right.dist){
                Node temp = x.left;
                x.left=x.right;
                x.right=temp;
            }
            x.dist = x.right.dist+1;
        }
        return x;
    }


    private class Node{
        private T element;
        private int dist;
        private Node left;
        private Node right;

        public Node(T element){
            this.element = element;
            this.dist = 0;
            this.left=null;
            this.right=null;
        }
    }

    public static void main( String [ ] args ) {
        Queue<Integer> test = new Queue<>();
        int[] nums = {12, 34, 53, 17, 28, 36, 22};
        for (int num:nums){
            test.insert(num);
        }
        test.print();
        System.out.println("---------");
        test.insert(7);
        test.insert(5);
        test.print();
        for(int i=0; i<8; i++){
            test.delete();
        }
        System.out.println("---------");
        test.print();
        test.delete();
        System.out.println("---------");
        test.print();
        test.delete();
    }
}
