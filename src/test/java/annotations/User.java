package annotations;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
@TestAnnotation(prettier = true)
public class User {
	@TestAnnotation
	public User(String name) {
		this.name = name;
	}

	@TestAnnotation
	private String name;

	@TestAnnotation
	private void testt(){
		System.out.println("yesBaby");
	}

}




