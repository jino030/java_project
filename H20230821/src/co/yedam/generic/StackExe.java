package co.yedam.generic;

import java.util.Stack;

// Stack: LastInFirstOut
public class StackExe {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		stack.push("One");
		stack.push("Two");
		stack.push("Three");

		while (!stack.isEmpty()) {
			String val = stack.pop();
			System.out.println(val);
		}
	}
}
