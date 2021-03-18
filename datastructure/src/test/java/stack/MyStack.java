package stack;

import java.util.Arrays;

public class MyStack implements StackInterface {

	private final int capacity;
	private int[] arr;
	private int max;
	private int pointer;

	public MyStack(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
		this.max = capacity;
		this.pointer = 0;
	}

	@Override
	public int getSize() {
		return pointer;
	}

	@Override
	public int getCapacity() {
		return capacity;
	}

	@Override
	public int push(int value) {
		return arr[pointer++] = value;
	}

	@Override
	public int pop() {
		return arr[--pointer];
	}

	@Override
	public int peek() {
		return arr[pointer - 1];
	}

	@Override
	public void dump() {
		System.out.println(Arrays.toString(arr));
	}

	@Override
	public void clear() {
		pointer = 0;
		arr = new int[max];
	}

	@Override
	public boolean isEmpty() {
		return getSize() == 0;
	}

	@Override
	public boolean isFull() {
		return getSize() == capacity;
	}

	@Override
	public int indexOf(int target) {
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
}
