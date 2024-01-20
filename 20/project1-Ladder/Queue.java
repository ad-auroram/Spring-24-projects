public class Queue<E> {

    public static class Node<E> {
        public E data;
        public Node nextVal;

        public Node(E value) {
            this.data = value;
            this.nextVal = null;
        }

    }


    private Node head; // the first element of the list
    private Node tail; // the last element of the list
    private int size;

    public void enqueueItem(E value) {
        if (tail != null) {
            tail.nextVal = new Node<>(value);
            tail = tail.nextVal;
        } else {
            tail = new Node<>(value);
            head = tail;
        }

    }

    public Node dequeueItem() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node temp = head;
            head = head.nextVal;
            return temp;
        }
        return null;
    }

    public String printContents() {
        if (head == null) {
            return "List in empty!";
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.nextVal;

            }
        }
        return "Done!";
    }

}







