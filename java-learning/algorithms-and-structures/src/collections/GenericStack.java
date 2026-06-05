package collections;

import java.util.ArrayList;

public class GenericStack<T> {

    private ArrayList<T> internalList;

    public GenericStack() {
        this.internalList = new ArrayList<>();
    }

    public void push(T item) {
        this.internalList.add(item);
    }

    public boolean isEmpty() {
        return this.internalList.size() == 0;
    }

    public T pop() {
        if(this.isEmpty()) {
            throw new IllegalStateException("Stack is empty! Cannot pop.");
        }
        int topIndex = this.internalList.size() - 1;
        return this.internalList.remove(topIndex);
    }
}