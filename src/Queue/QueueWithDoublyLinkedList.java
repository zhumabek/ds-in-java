package Queue;

import LinkedList.DoublyLinkedList;

public class QueueWithDoublyLinkedList<T> {
    private final DoublyLinkedList<T> items;

    public QueueWithDoublyLinkedList(){
        this.items = new DoublyLinkedList<>();
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public int size(){
        return this.items.size();
    }

    public T peek() {
        var firstElem = this.items.getHead();

        return firstElem == null ? null : firstElem.value;
    }

    public void enqueue(T val){
        this.items.prepend(val);
    }

    public T dequeue(){
        var popped = this.items.popFromTail();

        return popped == null ? null : popped.value;
    }
}
