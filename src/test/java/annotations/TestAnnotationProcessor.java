package annotations;

import lombok.SneakyThrows;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("java.annotations.TestAnnotation")
public class TestAnnotationProcessor extends AbstractProcessor {
	@Override
	public synchronized void init(ProcessingEnvironment processingEnv) {
		super.init(processingEnv);
	}

	@SneakyThrows
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		StringBuilder sb = new StringBuilder();
		sb.append("private ObjectMapper mapper = new ObjectMapper");
		for (Element element : roundEnv.getElementsAnnotatedWith(TestAnnotation.class)){
			System.out.println(element);
		}
		return true;
	}
}
