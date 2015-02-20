package tasks_Stacks_Queues_3;

public class StackArray {
	// 3.1 Describe how you could use a single array to implement three
	// stacks.

	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	// pointers to track top element
	int[] stackPointer = { -1, -1, -1 };

	public void push(int stackNumber, int value) throws Exception {
		// check if we have space
		if (stackPointer[stackNumber] + 1 >= stackSize) {
			throw new Exception("Out of space.");
		}
		stackPointer[stackNumber]++;
		buffer[absTopOfStack(stackNumber)] = value;
	}

	public int pop(int stackNumber) throws Exception {
		if (stackPointer[stackNumber] == -1) {
			throw new Exception("Trying to pop an empty stack.");
		}
		// get top
		int value = buffer[absTopOfStack(stackNumber)];
		stackPointer[stackNumber]--;
		return value;
	}

	int peek(int stackNumber) {
		int index = absTopOfStack(stackNumber);
		return buffer[index];
	}

	boolean isEmpty(int stackNumber) {
		return stackPointer[stackNumber] == -1;
	}

	// returns index of top of stack
	int absTopOfStack(int stackNumber) {
		return stackNumber * stackSize + stackPointer[stackNumber];
	}
}
