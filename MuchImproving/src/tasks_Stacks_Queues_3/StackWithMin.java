package tasks_Stacks_Queues_3;

import java.util.Stack;

@SuppressWarnings("serial")
public class StackWithMin extends Stack<Integer> {
	Stack<Integer> minimums;

	public StackWithMin() {
		minimums = new Stack<Integer>();
	}

	public void push(int value) {
		if (value <= getMin()) {
			minimums.push(value);
		}
		super.push(value);
	}

	public Integer pop() {
		int value = super.pop();
		if (value == getMin()) {
			minimums.pop();
		}
		return value;
	}

	public int getMin() {
		if (minimums.isEmpty()) {
			// Error value
			return Integer.MAX_VALUE;
		} else {
			return minimums.peek();
		}
	}
}
