package study2String;

public class StringType_Buff {
	public void StringBuf() { // StringBuf 이라는 함수를 만들려고 한다. 그 내용은 ↓
		StringBuffer sbuffer = new StringBuffer("a");
		// StringBuffer에 대해서 sbuffer이라는 변수의 이름으로 새로운 객체를 만들고 거기에 "a"라는 값을 담았다.
		
		sbuffer.append("lone"); // sbuffer 이름의 변수에 우리는 append라는 문법을 통해서 "lone"라는 문자열을 추가해 줄 것이다. 
		System.out.println(sbuffer); //  마지막으로 원래의 sbuffer에다가 lone를 값을 +연산한 sbuffer을 출력해주려고 한다.
	}
	
}
