class SinglyLinkedList<T> {
    private Node<T> head;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void printList() {
        Node<T> current = head;
        System.out.print("Singly List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}


SinglyLinkedList<String> sList = new SinglyLinkedList<>();
sList.addFirst("C");
sList.addFirst("B");
sList.addFirst("A");
sList.printList(); // 출력: Singly List: A -> B -> C -> null
