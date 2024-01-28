package Stack;

import LinkedList.SinglyLinkedList;

public class StackWithSinglyLinkedList<T> {
    private final SinglyLinkedList<T> items;

    public StackWithSinglyLinkedList(){
        this.items = new SinglyLinkedList<>();
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public void push(T val){
        this.items.prepend(val);
    }

    public T pop(){
        var popped = this.items.popFromHead();

        return popped == null ? null : popped.value;
    }

    public int size(){
        return this.items.size();
    }

    public T peek(){
        var topElement = this.items.getHead();
        return topElement == null ? null : topElement.value;
    }
}
