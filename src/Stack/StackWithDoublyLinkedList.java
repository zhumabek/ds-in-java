package Stack;

import LinkedList.DoublyLinkedList;

public class StackWithDoublyLinkedList<T> {
    private final DoublyLinkedList<T> items;

    public StackWithDoublyLinkedList(){
        this.items = new DoublyLinkedList<>();
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public void push(T val){
        this.items.append(val);
    }

    public T pop(){
        var popped = this.items.popFromTail();

        return popped == null ? null : popped.value;
    }

    public int size(){
        return this.items.size();
    }

    public T peek(){
        var topElement = this.items.getTail();
        return topElement == null ? null : topElement.value;
    }
}
