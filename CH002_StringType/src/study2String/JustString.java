package study2String;

/*
 *  String을 연습해보기위한 예제.
 *  String을 단순 표현하는 방법은 2가지가 있다.
 *  아래 예제에 쓰인 것 처럼 + 연산.
 *  그리고 .concat() 이라는 method가 있지만, 이건 되도록 사용하지 않는게 좋다.
 */
public class JustString {

	public void JustStr() {
		String str = new String("a");
		str = str + "llow";
		System.out.println(str);
	}

}
