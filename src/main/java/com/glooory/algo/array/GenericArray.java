package com.glooory.algo.array;

public class GenericArray<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size;

    public GenericArray(int size) {
        if (size > 0) {
            this.data = new Object[size];
        } else if (size == 0) {
            this.data = new Object[DEFAULT_SIZE];
        } else {
            throw new IllegalArgumentException("Illegal Argument Size : " + size);
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(T item) {
        if (isEmpty() || item == null) {
            return false;
        }

        return indexOf(item) >= 0;
    }

    public T add(T item) {
        checkShouldGrow();
        this.data[size] = item;
        this.size++;
        return item;
    }

    public void add(int index, T item) {
        checkIndexForAdd(index);
        checkShouldGrow();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        this.data[index] = item;
        this.size++;
    }

    public boolean remove(T item) {
        if (isEmpty() || item == null) {
            return false;
        }

        int index = indexOf(item);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    public T remove(int index) {
        checkIndex(index);

        T cur = elementData(index);
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return cur;
    }

    public T get(int index) {
        checkIndex(index);
        return elementData(index);
    }

    public T set(int index, T item) {
        checkIndex(index);
        this.data[index] = item;
        return item;
    }

    public int indexOf(T item) {
        if (item == null) {
            for (int j = 0; j < this.data.length; j++) {
                if (null == this.data[j]) {
                    return j;
                }
            }
        } else {
            for (int i = 0; i < this.data.length; i++) {
                if (item.equals(this.data[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    private T elementData(int index) {
        return (T) this.data[index];
    }

    private void checkShouldGrow() {
        if (this.size == this.data.length) {
            grow();
        }
    }

    private void grow() {
        int len = this.data.length;
        Object[] newOnes = new Object[len * 2];
        for (int i = 0; i < len; i++) {
            newOnes[i] = data[i];
        }
        this.data = newOnes;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Illegal Index - " + index);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IllegalArgumentException("Illegal Index - " + index);
        }
    }
}
