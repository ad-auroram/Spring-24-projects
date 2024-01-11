public class Queue<E> {

    public class Node<E> {
        public E data;
        public Node nextVal;

        public Node(E value) {
            this.data = value;
            this.nextVal = null;
        }

    }


    public class List {
        private Node head; // the first element of the list
        private Node tail; // the last element of the list
        private int size;

        public void enqueueItem(E value) {
            if (tail != null) {
                tail.nextVal = new Node<>(value);
                tail.nextVal = tail;
            } else {
                tail.nextVal = new Node<>(value);
                head = tail;
            }

        }

        public void popItem(E value) {
            if (head == null) {
                System.out.println("List is empty");
            } else {
                head = head.nextVal;
            }
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
}






