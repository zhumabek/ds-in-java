package Queue;

import LinkedList.SinglyLinkedList;

public class QueueWithSinglyLinkedList<T> {
    private final SinglyLinkedList<T> items;

    public QueueWithSinglyLinkedList(){
        this.items = new SinglyLinkedList<>();
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
        this.items.append(val);
    }

    public T dequeue(){
        var popped = this.items.popFromHead();

        return popped == null ? null : popped.value;
    }
}
