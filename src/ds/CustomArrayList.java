package ds;

import java.util.Arrays;

public class CustomArrayList<E> {

    private static int INITIAL_CAPACITY = 4;
    private int index = 0;
    private Object arrayList[];

    public CustomArrayList() {
        arrayList = new Object[INITIAL_CAPACITY];
    }

    public void add(E e) {
        if (index == arrayList.length) {
            ensureCapacity();
        }
        arrayList[index] = e;
        index++;
    }

    public E get(int itemIndex) {
        if (itemIndex < 0 || itemIndex > index) {
            throw new IndexOutOfBoundsException();
        }
        E item = (E) arrayList[itemIndex];
        return item;
    }

    public int size() {
        return arrayList.length;
    }

    public E remove(int itemIndex) {
        if (itemIndex < 0 || itemIndex > index) {
            throw new IndexOutOfBoundsException();
        }
        E item = (E) arrayList[itemIndex];
        for (int i = itemIndex; i < arrayList.length - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        index--;
        return item;
    }

    private void ensureCapacity() {
        int newCapacity = arrayList.length * 2;
        arrayList = Arrays.copyOf(arrayList, newCapacity);
    }

}
