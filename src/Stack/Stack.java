package Stack;

import java.util.ArrayList;

public class Stack<T> {
    private final ArrayList<T> items;

    public Stack(){
        this.items = new ArrayList<>();
    }

    public boolean isEmpty(){
        return this.items.isEmpty();
    }

    public void push(T val){
        this.items.add(val);
    }

    public T pop(){
        return this.items.remove(size() - 1);
    }

    public int size(){
        return this.items.size();
    }

    public T peek(){
        return this.items.get(size() - 1);
    }
}
