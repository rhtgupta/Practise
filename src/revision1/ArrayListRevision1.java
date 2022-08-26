package revision1;

import java.util.Arrays;
import java.util.Objects;

public class ArrayListRevision1<E> {

    private int defaultSize;
    private Object[] arrayList;
    private int index;

    ArrayListRevision1() {
        defaultSize = 2;
        arrayList = new Object[defaultSize];
        index = -1;
    }

    public void add(E data) {
        if (index == arrayList.length - 1) {
            ensureCapacity();
        }
        index++;
        arrayList[index] = data;
    }

    public E get(int index) {
        if (index < 0 || index > arrayList.length) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) arrayList[index];
        return element;
    }

    public int size() {
        return index + 1;
    }

    public E remove(int elementIndex) {
        if (elementIndex < 0 || elementIndex > arrayList.length) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) arrayList[elementIndex];
        for (int i = elementIndex; i < arrayList.length - 1; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        index--;
        return element;
    }

    private void ensureCapacity() {
        int newCapacity = arrayList.length * 2;
        Object[] tempArrayList = arrayList;
        arrayList = new Object[newCapacity];
        for (int i = 0; i < tempArrayList.length; i++) {
            arrayList[i] = tempArrayList[i];
        }
    }

    public void print() {
        for (int i = 0; i <= index; i++) {
            System.out.print(arrayList[i] + " ");
        }
    }

    public static void main(String[] args) {
        ArrayListRevision1 arrayList = new ArrayListRevision1();
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        arrayList.add(50);
        arrayList.print();
        arrayList.remove(2);
        System.out.println("");
        arrayList.print();
        System.out.println("");
        System.out.println(arrayList.size());
    }

}
