package study2String;

public class StringType_Build {
	public void StringBul() { 	//StringBul 이라는 함수를 만들려고 한다. 그 내용은 ↓
		StringBuilder sbubul = new StringBuilder("a");
		// StringBuilder에 대해서 sbubul이라는 변수의 이름으로 새로운 객체를 만들고 거기에 "a"라는 값을 담았다.
		
		sbubul.append("ge"); // sbubul 이름의 변수에 우리는 "ge"라는 문자열을 추가해 줄 것이다. append라는 문법을 통해서
		System.out.println(sbubul);  // 마지막으로 원래의 sbubul에다가 ge를 값을 +연산한 sbubul을 출력해주려고 한다.
	}
	
}
