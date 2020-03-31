package datastructures;

public class DynamicArray<String> {

    private Object[] data;

    // Counter for the number of elements in our array
    private int size = 0;

    // The capacity of our array - or how many elements it can hold.
    // What we double when the number of elements exceeds the capacity of the array.
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index) {
        return (String) data[index]; //O(n)
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    //-> O(n) + O(n) + O(1) => O(n)
    public void insert(int index, String value) {
        if (size == initialCapacity)
            resize(); //O(n)

        for (int i = size; i > index; i--) //O(n)
            data[i] = data[i - 1];

        data[index] = value; //O(1)
        size++;
    }

    private void resize() {
        Object[] newData = new Object[initialCapacity * 2];
        for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        initialCapacity = initialCapacity * 2;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i] + ", ");
        }
    }

    // Some array implementations offer methods like insert (also known as pushBack).
    // Which is like insert, only in does the insert at the end of the array.
    public void add(String value) {
        if (size == initialCapacity)
            resize();
        data[++size - 1] = value;
    }

    public void delete(int index) {
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value))
                return true;
        }
        return false;
    }

}