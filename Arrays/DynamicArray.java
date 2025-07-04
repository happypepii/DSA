package Arrays;

public class DynamicArray<T> {
    private int capacity;
    private Object[] data;
    private int size = 0; // the actual size of the array

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
    }
    
    public DynamicArray() {
        this(5);
    }

    public void add(T value) {
        if(size == capacity){
            expand();
        }
        data[size] = value;
        size++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1]; // shift left
        }
        data[size - 1] = null; // clear last slot
        size--;
        if (size > 0 && size <= capacity / 4) {
            shrink();
        }
    }

    public void insertAt(int index, T value) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        if(size == capacity) {
            expand();
        }
        for (int i = size ; i > index ; i--) {
            data[i] = data[i-1]; // shift right
        }
        data[index] = value;
        size++;
    }

    public void set(int index, T value) {
        checkBounds(index);
        data[index] = value;
    }

    public T get(int index) {
        checkBounds(index);
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void checkBounds(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    private void expand() {
        capacity *= 2;
        data = java.util.Arrays.copyOf(data, capacity);
    }

    private void shrink() {
        int newCapacity = Math.max(1, capacity / 2); // prevent from shrinking to size 0
        data = java.util.Arrays.copyOf(data, newCapacity);
        capacity = newCapacity;
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(data);
    }
}
