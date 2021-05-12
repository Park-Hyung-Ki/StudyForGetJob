package step3_factoryPattern;

public class TV_user {

	public static void main(String[] args) {
		/*STV tv = new STV();
		tv.powerOn(); //원래는 STV로 쓰다가 바꾸려고 한다.
		*/
		
		/*
		LTV tv = new LTV(); // 여기서 보면 총 3번을 고쳤다. STV -> LTV (2번) , powerOn -> turnOn
		tv.turnOn(); // 복잡한 프로그램일수록 고쳐야 할 것이 더 많아질것, 유지보수성이 떨어진다.
		*/
		/*
		TV tv = new STV(); // TV라고 만들었던 interfacce에서 가져온다.
		tv.powerOn(); 
		*/
		
		/*
		//TV를 바꿔서 LTV로 사용하려고 한다.
		TV tv = new LTVAdapter(); // 앞서 만들어둔 Adapter Class 사용
		tv.powerOn();
		*/
		for (String arg : args) { // debug configuration 에서 Arg에 추가한 요소들을 하나씩 확인 
			System.out.println(arg);
		}
		TV tv =TVFactory.getBean(args[0]);
				tv.powerOn();
		
	}

}
