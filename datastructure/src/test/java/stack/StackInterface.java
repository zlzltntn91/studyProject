package stack;

public interface StackInterface {
	int getSize();
	int getCapacity();
	int push(int value);
	int pop();
	int peek();
	void dump();
	void clear();
	boolean isEmpty();
	boolean isFull();
	int indexOf(int target);
}
