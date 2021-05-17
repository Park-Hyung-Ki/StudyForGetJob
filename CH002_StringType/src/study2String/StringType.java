package study2String;

/**
 * String을 사용하여 만들 수있는 세가지의 문법을 동시에 실험해보려고 이곳 Main에서 해보려고 한다.
 *
 * @author Park
 */
public class StringType {

	public static void main(String[] args) {
		JustString stb0 = new JustString(); // String을 사용한 함수
		stb0.JustStr();
		
		StringType_Build stb1 = new StringType_Build(); // String Builder를 사용한 함수
		stb1.StringBul();
		
		StringType_Buff stb2 = new StringType_Buff(); // String Buffer를 사용한 함수
		stb2.StringBuf();
		
	}

}
