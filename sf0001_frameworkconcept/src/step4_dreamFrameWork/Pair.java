package step4_dreamFrameWork;

public class Pair<S, F> {
	private S s;
	private F f;

	public Pair(F f, S s) {
		this.f = f;
		this.s = s;

	}

	public F getF() {
		return f;
	}

	public S getS() {
		return s;
	}

}
