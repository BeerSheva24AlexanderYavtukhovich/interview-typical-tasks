package telran.interview;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStackInt {
    private final ArrayList<Integer> stack;
    private final ArrayList<Integer> maxStack;

    public MyStackInt() {
        stack = new ArrayList<>();
        maxStack = new ArrayList<>();
    }

    public void push(int num) {
        stack.add(num);
        if (maxStack.isEmpty() || num >= maxStack.get(maxStack.size() - 1)) {
            maxStack.add(num);
        }
    }

    public int pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        int num = stack.remove(stack.size() - 1);
        if (num == maxStack.get(maxStack.size() - 1)) {
            maxStack.remove(maxStack.size() - 1);
        }
        return num;
    }

    public int peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int getMaxElement() {
        if (maxStack.isEmpty()) {
            throw new EmptyStackException();
        }
        return maxStack.get(maxStack.size() - 1);
    }

}
