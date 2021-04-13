package annotations;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface TestAnnotation {
	boolean prettier() default false;
}
