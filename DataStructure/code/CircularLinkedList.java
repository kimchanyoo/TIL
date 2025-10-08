class CircularLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void printList(int limit) {
        if (head == null) {
            System.out.println("Circular List: Empty");
            return;
        }

        Node<T> current = head;
        System.out.print("Circular List (Limit " + limit + "): ");
        for (int i = 0; i < limit; i++) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("... (goes back to " + head.data + ")");
    }
}

CircularLinkedList<Character> cList = new CircularLinkedList<>();
cList.addLast('X');
cList.addLast('Y');
cList.addLast('Z');
cList.printList(5); // 출력: Circular List (Limit 5): X -> Y -> Z -> X -> Y -> ... (goes back to X)