package revision;

import java.util.Arrays;

public class CustomStackImplementation<E> {

    private static int INITIAL_CAPACITY = 10;
    private int top = -1;
    private Object stack[];

    CustomStackImplementation() {
        stack = new Object[INITIAL_CAPACITY];
    }

    public void push(E e) {
        if (top + 1 == stack.length) {
            ensureLength();
        }
        stack[++top] = e;
    }

    public E pop() {
        E element = (E) stack[top];
        stack[top] = null;
        top--;
        return element;
    }

    public E peek() {
        E element = (E) stack[top];
        return element;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void ensureLength() {
        int newCapacity = stack.length * 2;
        stack = Arrays.copyOf(stack, newCapacity);
    }

}
