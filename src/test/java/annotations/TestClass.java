package annotations;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class TestClass {

	@Test
	public void test() throws InvocationTargetException, IllegalAccessException {
		User user = new User("김은수");
		Annotation[] annotations = user.getClass().getDeclaredAnnotations();
		Arrays.stream(annotations).forEach(System.out::println);
		System.out.println("---------------------------------------------");

		Field[] fields = user.getClass().getDeclaredFields();
		for (Field field : fields) {
//			field.set
		}
		Arrays.stream(fields).forEach(System.out::println);


		System.out.println("---------------------------------------------");

		for(Method method : user.getClass().getDeclaredMethods()){
			method.setAccessible(true);
			Arrays.stream(method.getAnnotations()).forEach(System.out::println);
			method.invoke(user);
		}
	}
}
