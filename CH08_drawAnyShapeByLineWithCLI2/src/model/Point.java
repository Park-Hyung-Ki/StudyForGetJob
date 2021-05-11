package model; //선 그리기 향상 성능 부분이라서 코드 작성 순번이 다름

import java.util.ArrayList;
import java.util.List;

public class Point {
	private int x, y; // 1.점을 만들 두 개의 정보
	private List<Line> listLine = new ArrayList<>(); // 24. Point에서 필요한 Line에 관한 변수를 선언
	// 29. ↑이 부분도 getter로만들거다.

	public Point(int x, int y) { // 2. 2개의 생성자 선언
		this.x = x;
		this.y = y;
	}

	public List<Line> getListLine() { // 30. getter로 만든 부분
		return listLine; // 31. return값도 동일하게
	}

	public void addLine(Line line) { // 23. Line에서 만든 addLine을 Point객체에 만들어준다.
		listLine.add(line); // 24 그래서 여기에 2개의 라인이 담겨있다.
	}

	public int getX() { // 41. getter를 만들고 다시 Line으로
		return x;
	}

	public int getY() { // 41-1. 41과 동일
		return y;
	}

	@Override // 33. 여기에 hashCode를 만들면 무한Loop에 빠져버리게 된다. Point에서 line 참조,
	// Line에서 point 참조하는 양방향이 있기때문에, 무한 Loop에 빠지게 되는것
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + ((ListLine == null) ? 0 : ListLine.hashCode());
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
}

/**
 * 배열에서 뭔가를 꺼내라 하는건 프로그램 전체의 성능에는 문제가 없다. 근데 이거를 혹시 ArrayList가 아닌 LinkedList로
 * 바꿔버린다면? 성능 손해를 볼 가능성이 있을 수도 있다.
 */