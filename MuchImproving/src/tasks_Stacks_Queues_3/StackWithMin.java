package tasks_Stacks_Queues_3;

import java.util.Stack;

//3.2 How would you design a stack which, in addition to push and pop, also has a
//function min which returns the minimum element? Push, pop and min should all
//operate in 0(1) time.

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
