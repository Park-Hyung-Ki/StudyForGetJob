package step5_DFAnnotation;

public class ATV implements TV {

	@Override
	public void powerOn() {
		System.out.println("ATV도 시청 잘해요");
	}

}
