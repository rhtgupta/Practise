package revision1;

import java.util.NoSuchElementException;

public class StackRevision1<E> {

    private Object[] stackArray;
    private int top = -1;
    private int defaultCapacity;

    StackRevision1() {
        defaultCapacity = 4;
        stackArray = new Object[defaultCapacity];
    }

    public void push(E element) {
        if (top == stackArray.length - 1) {
            ensureCapacity();
        }
        top++;
        stackArray[top] = element;
    }

    public E pop() {
        if (top == -1) {
            throw new NoSuchElementException();
        }
        E element = (E) stackArray[top];
        top--;
        return element;
    }

    public E peek() {
        if (top == -1) {
            throw new NoSuchElementException();
        }
        E element = (E) stackArray[top];
        return element;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top == -1 ? 0 : top + 1;
    }

    private void ensureCapacity() {
        Object[] temp = stackArray;
        int newCapacity = stackArray.length * 2;
        stackArray = new Object[newCapacity];
        for (int i = 0; i < temp.length; i++) {
            stackArray[i] = temp[i];
        }
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
    }

    public static void main(String[] args) {
        StackRevision1<Integer> stack = new StackRevision1<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(" ");
        stack.print();
        stack.pop();
        System.out.println(" ");
        stack.print();
        stack.push(40);
        stack.push(50);
        System.out.println(" ");
        stack.print();
        stack.pop();
        System.out.println(" ");
        stack.print();
    }

}
