package Arrays;

import java.util.EmptyStackException;

public class Stack<T> {
    private DynamicArray<T> array;

    public Stack() {
        this.array = new DynamicArray<>();
    }

    public void push(T value) {
        array.add(value);
    }

    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T element = array.get(size()-1);
        array.removeAt(size()-1);
        return element;
    }

    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return array.get(size()-1);
    }

    public int size() {
        return array.size();
    }

    public boolean isEmpty() {
        return array.size() == 0;
    } 
}
