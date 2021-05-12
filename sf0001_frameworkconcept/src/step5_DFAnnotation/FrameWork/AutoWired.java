package step5_DFAnnotation.FrameWork; // FrameWork에 있는 기능중 하나인 Autowired를 만들어볼건데

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
// 1. 생성
@Retention(RUNTIME)
@Target(FIELD)
public @interface AutoWired {
	String beanName(); // 2. String으로 선언 
}
