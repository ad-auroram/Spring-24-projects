public class Queue<E> {

    public static class Node<E> {
        public E data;
        public Node nextVal;

        public Node(E value) {
            this.data = value;
            this.nextVal = null;
        }

    }


    public Node head; // the first element of the list
    public Node tail; // the last element of the list
    public int size;

    public void enqueueItem(E value) {
        if (tail != null) {
            tail.nextVal = new Node<>(value);
            tail = tail.nextVal;
            size ++;
            if (head == null){
                head = tail;
            }
        } else {
            head = new Node<>(value);
            tail = head;
            size ++;
        }

    }

    public Node dequeueItem() {
        if (head == null) {
            System.out.println("Queue is empty, no solution found.");
        } else {
            Node temp = new Node(head.data);
            head = head.nextVal;
            if(head == null) {
                tail = null;
            }
            size --;
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







