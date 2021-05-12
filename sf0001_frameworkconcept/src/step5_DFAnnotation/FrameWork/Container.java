package step5_DFAnnotation.FrameWork;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
	private static final Container theInstance = new Container();
	Map<String, Object> mapElements = new HashMap<>();

	private Container() {
		prepare();
		injectDependency();
	}

	public static Container getInstance() {
		return theInstance;
	}

	public void prepare() {

		try {
			List<Pair<String, String>> list = ContextParser.parseContext();
			for (Pair<String, String> p : list) {
				// 클래스 로더를 통해서 해당 클래스를 로드한다. 실행 준비 단계
				Class beanClass = Class.forName(p.getS());
				mapElements.put(p.getF(), beanClass.newInstance());
				// 이렇게 담으면 이름과, 객체가 짝 지어져 있을것 같다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object getBean(String beanName) {
		return mapElements.get(beanName); // 객체들을 찾아라
	}

	private void injectDependency() { // injectDependency 함수 선언하고 , 내용들을 정의
		for (String key : mapElements.keySet()) {
			//Load된 모든 객체 들을 대상(root_context.xml에 있는 객체)으로
			Object bean = mapElements.get(key);
			for (Field field : bean.getClass().getDeclaredFields()) {
				//각 객체별 정의된 속성 모든 것들을 대상으로
				AutoWired anno = field.getAnnotation(AutoWired.class);
				if (anno != null) {
					//AutoWired라는 Annotation(주석, 부가적인 설명 정보)이 달려 있으면
					System.out.println(field.getName());
					//sysout으로 myTv가 출력이 될것
					
					Object val = getBean(anno.beanName());
					try {
						field.setAccessible(true); // 해당 field 내에서 FrameWork가 접근 권한을 열어 버린다.
						// 정보 할당. DI(Dependency Injection)
						field.set(bean, val);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
/*
 * public static void main(String[] args) { Container c = new Container();
 * c.prepare(); for (String key : c.mapElements.keySet()) {
 * System.out.println(key + " = " +
 * c.mapElements.get(key).getClass().getName()); } }
 */

// List<Field> listField = collectAutowiredFields(bean);