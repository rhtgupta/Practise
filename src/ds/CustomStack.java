package ds;

import java.util.Arrays;
import java.util.Stack;

public class CustomStack<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int top = -1;
    private Object stack[];

    CustomStack() {
        stack = new Object[DEFAULT_CAPACITY];
    }

    public void push(E element) {
        if (top + 1 == stack.length) {
            int newSize = stack.length * 2;
            stack = Arrays.copyOf(stack, newSize);
        }
        stack[++top] = element;
    }

    public E pop() {
        E element = (E) stack[top];
        stack[top] = null;
        top--;
        return element;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
