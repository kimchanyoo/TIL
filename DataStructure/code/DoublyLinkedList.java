class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("Doubly List (Fwd): ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

DoublyLinkedList<Integer> dList = new DoublyLinkedList<>();
dList.addLast(10);
dList.addLast(20);
dList.addLast(30);
dList.printList(); // 출력: Doubly List (Fwd): 10 <-> 20 <-> 30 <-> null