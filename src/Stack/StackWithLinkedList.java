package Stack;

import LinkedList.DoublyLinkedList;

public class StackWithLinkedList<T> {
    private final DoublyLinkedList<T> items;

    public StackWithLinkedList(){
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
