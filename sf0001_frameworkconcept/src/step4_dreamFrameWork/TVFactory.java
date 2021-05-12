package step4_dreamFrameWork; // 밑에 Container 만들어서 이거는 지워버렸음

public class TVFactory {
	public static TV getBean(String beanName) {// getBean 이라는 객체의 이름을 받는 함수를 만들어 내겠다.
		if ("STV".equals(beanName)) {
			return new STV();
		} else if(beanName != null && beanName.equals("LTV")) { //beanName.equals("LTV")[원래코드] -> (beanName != null && beanName.equals("LTV")[변경 코드]
			return new LTVAdapter();
		} else if("HTV".equals(beanName)) { // HTV가 새로 만들어졌기에, 새롭게 추가해준 코드 
			return new HTV();
		} else if("ATV".equals(beanName) ) {
			return new ATV();
		} else {
			return null;
		}
	}
}

/* (beanName.equals("LTV")) style의 단점??
 *  NullPointerException 발생을 막아야 합니다. -> 해결방법 (beanName != null && beanName.equals("LTV") 으로 코드 교체
 */

/* HTV라는 새로운 beanName을 생성. 그것을 추가해주기 위해서
 * 여튼 근데 Factory Pattern이 모든걸 또 해결해주지는 않는다. 새로 생겨도 계속 추가해줘야 하기때문에
 */ 