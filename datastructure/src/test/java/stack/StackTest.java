package stack;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class StackTest {

	@Test
	public void myStack() {
		MyStack stack = new MyStack(10);

		assertThat(stack.getCapacity()).isEqualTo(10);
		assertThat(stack.getSize()).isEqualTo(0);
		stack.dump();

		assertThat(stack.push(2)).isEqualTo(2);
		assertThat(stack.pop()).isEqualTo(2);
		assertThat(stack.getSize()).isEqualTo(0);
		stack.dump();

		assertThat(stack.push(3)).isEqualTo(3);
		assertThat(stack.push(6)).isEqualTo(6);
		assertThat(stack.push(4)).isEqualTo(4);
		assertThat(stack.pop()).isEqualTo(4);
		stack.dump();

		assertThat(stack.getSize()).isEqualTo(2);
		assertThat(stack.peek()).isEqualTo(6);
		assertThat(stack.peek()).isEqualTo(6);
		assertThat(stack.getSize()).isEqualTo(2);
		stack.dump();

		assertThat(stack.indexOf(3)).isEqualTo(0);
		assertThat(stack.indexOf(7)).isEqualTo(-1);

		stack.clear();
		stack.dump();
		assertThat(stack.getSize()).isEqualTo(0);
		assertThat(stack.getCapacity()).isEqualTo(10);

		assertThat(stack.isEmpty()).isTrue();
		assertThat(stack.isFull()).isFalse();
	}

	public void t (){
		List t = new Stack<>();
	}
}
