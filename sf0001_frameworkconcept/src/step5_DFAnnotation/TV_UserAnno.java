package step5_DFAnnotation;

import step5_DFAnnotation.FrameWork.AutoWired;
import step5_DFAnnotation.FrameWork.Container;

public class TV_UserAnno {
	// DI dependency Injection. 의존성 주입
	@AutoWired(beanName="STV") // 3. Anno에 만들었던 것을 선언해주고
	private TV myTv; // 2. Anno를 만들기위한 두번째 선언 
	
	public TV_UserAnno() { // 4. 일단 생성자 하나 더 만들고
		
	}
	
	private void watchTv() { // 7. watchTv 함수 선언
		myTv.powerOn();
	}
	public static void main(String[] args) {
		/*
		 * STV tv = new STV(); tv.powerOn(); //원래는 STV로 쓰다가 바꾸려고 한다.
		 */

		/*
		 * LTV tv = new LTV(); // 여기서 보면 총 3번을 고쳤다. STV -> LTV (2번) , powerOn -> turnOn
		 * tv.turnOn(); // 복잡한 프로그램일수록 고쳐야 할 것이 더 많아질것, 유지보수성이 떨어진다.
		 */
		/*
		 * TV tv = new STV(); // TV라고 만들었던 interfacce에서 가져온다. tv.powerOn();
		 */

		/*
		 * //TV를 바꿔서 LTV로 사용하려고 한다. TV tv = new LTVAdapter(); // 앞서 만들어둔 Adapter Class
		 * 사용 tv.powerOn();
		 */
		/*
		 * for (String arg : args) { // debug configuration 에서 Arg에 추가한 요소들을 하나씩 확인
		 * System.out.println(arg); } TV tv =TVFactory.getBean(args[0]); tv.powerOn();
		 */
		// 마지막 성능 업그레이드
		TV_UserAnno t = (TV_UserAnno) Container.getInstance().getBean("TV_UserAnno"); // 5.선언
		t.watchTv(); //6.함수하나 만들고
		/*for (String arg : args) { // debug configuration 에서 arg에 추가한 요소들을 하나씩 확인
			System.out.println(arg);
		}
		Container container = new Container();
		container.prepare();
		TV tv = (TV) container.getBean(args[0]);
		if (tv != null)
			tv.powerOn(); */ //이 부분은 step5에서는 필요없는 부분  

	}
}
	


