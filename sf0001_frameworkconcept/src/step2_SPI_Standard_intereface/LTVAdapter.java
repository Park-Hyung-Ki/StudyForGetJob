package step2_SPI_Standard_intereface;
/*
 * LTV는 이미 기능이 개발되어 있어서 쉽게 고치기가 어렵다(물론 복잡한 프로그램일수록)
 * 그렇기때문에 이런경우 Adapter 혹은 Bridge Pattern을 사용
 */
public class LTVAdapter implements TV {
	private LTV tv = new LTV();
	
	public void powerOn() {
		tv.turnOn();
	}

}
