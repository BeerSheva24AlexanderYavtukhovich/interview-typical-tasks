package telran.interview;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStackInt {
    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> maxStack;

    public MyStackInt() {
        stack = new LinkedList<>();
        maxStack = new LinkedList<>();
    }

    public void push(int num) {
        stack.addLast(num);
        if (maxStack.isEmpty() || num >= maxStack.getLast()) {
            maxStack.addLast(num);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int num = stack.removeLast();
        if (num == maxStack.getLast()) {
            maxStack.removeLast();
        }
        return num;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMaxElement() {
        if (maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.getLast();
    }
}
