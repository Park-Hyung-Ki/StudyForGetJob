package step4_dreamFrameWork.FrameWork;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
	Map<String, Object> mapElements = new HashMap<>();

	public void prepare() {
		try {
			List<Pair<String, String>> list = ContextParser.parseContext();
			for (Pair<String, String> p : list) {
				//클래스 로더를 통해서 해당 클래스를 로드한다. 실행 준비 단계
				Class beanClass = Class.forName(p.getS());
				mapElements.put(p.getF(), beanClass.newInstance());
				//이렇게 담으면 이름과, 객체가 짝 지어져 있을것 같다.
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String beanName) {
		return mapElements.get(beanName);
	}
}
	/*public static void main(String[] args) {
		Container c = new Container();
		c.prepare();
		for (String key : c.mapElements.keySet()) {
			System.out.println(key + " = " + c.mapElements.get(key).getClass().getName());
		}
	}*/

