package main;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int vec[] = {13, 7, 6, 12};
        printSEM(vec);
    }

    public static void printSEM(int vec[]) {
        if (vec.length == 0) {
            System.out.println("No elements");
            return;
        }
        Stack<Integer> stack = new Stack();
        stack.push(vec[0]);
        for (int i = 1; i < vec.length; i++) {
            int currentVec = vec[i];

            while (!stack.isEmpty()) {
                int elementStack = stack.pop();
                if (currentVec > elementStack) {
                    System.out.println(elementStack + "->" + currentVec);
                } else {
                    stack.push(elementStack);
                    break;
                }
            }
            stack.push(currentVec);
        }
        stack.stream().map(n -> n + "".concat("-> -1")).forEach(System.out::println);

    }
}
