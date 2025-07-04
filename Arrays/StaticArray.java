package Arrays;

public class StaticArray<T> {
    private int capacity;
    private Object[] data;

    public StaticArray(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity]; // Arrays are reified type in Java, type erasure is not allowed
    }

    public StaticArray() {
        this(5);
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
        return capacity;
    }
    
    public void checkBounds(int index) {
        if(index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    @Override
    public String toString() {
        return java.util.Arrays.toString(data);
    }
}