package LinkedList;

public class DoublyLinkedList<T> {
    public Node<T> head;
    public Node<T> tail;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void append(T val){
        var newNode = new Node<>(val);

        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
            this.size += 1;
            return;
        }

        this.size += 1;

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
    }

    public void prepend(T val){
        var newNode = new Node<>(val);

        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
            this.size += 1;
            return;
        }

        this.size += 1;

        newNode.next = this.head;
        this.head.prev = newNode;
        this.head = newNode;
    }

    public Node<T> popFromHead(){
        if(isEmpty()){
            return null;
        }

        this.size -= 1;

        var newHead = this.head.next;

        var popped = this.head;

        if (newHead == null){
            this.head = null;
            this.tail = null;

        } else {
            newHead.prev = null;
            this.head = newHead;
        }

        popped.next = null;

        return popped;
    }

    public Node<T> popFromTail(){
        if(isEmpty()){
            return null;
        }

        this.size -= 1;

        var newTail = this.tail.prev;
        var popped = this.tail;
        if(newTail == null){
            this.head = null;
            this.tail = null;
        } else {
            newTail.next = null;
            this.tail = newTail;
        }

        popped.prev = null;

        return popped;
    }

    public Node<T> getHead(){
        return this.head;
    }

    public Node<T> getTail(){
        return this.tail;
    }

    public void display(){
        if (isEmpty()){
            System.out.println("Empty, size: " + size());
            return;
        }

        System.out.println("Size: " + size());
        System.out.println("Head: " + getHead().value);
        System.out.println("Tail: " + getTail().value);

        var output = new StringBuilder();
        var currentNode = this.head;

        while (currentNode != null){
            output.append(currentNode.value).append(" -> ");
            currentNode = currentNode.next;
        }

        output.append("null");

        System.out.println(output);
    }
}
