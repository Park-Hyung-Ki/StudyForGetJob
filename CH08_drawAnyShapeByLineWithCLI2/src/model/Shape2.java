package model; //선 그리기 향상 성능 부분이라서 코드 작성 순번이 다름

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import view.DisplayBoard;

public class Shape2 {
	public static int WIDTH = 2000, HEIGHT = 2000; // 50. 좌표계의 limited 부분을 상수로 정의하자
	
	private List<Point> listStarPoint = new LinkedList<>(); // 5.Shape과 Point의 관계성을 이용하여 배열 선언
	private List<Line> listLine = new ArrayList<>(); // 66. UML에서 drived 라고 정의된거 만들거다.
	
	public Shape2() { // 6. Shape를 다룰 Point를 생성시켜보자(좌표 점은 사전에 정해둔 값)
		listStarPoint.add(new Point(5, 1000)); // 7. Point를 list에 담아야 하기에 listPoint.add 선언
		listStarPoint.add(new Point(1200, 700)); // 7-1
		listStarPoint.add(new Point(10, 15)); // 7-2
		listStarPoint.add(new Point(1050, 1300)); //7-3
		listStarPoint.add(new Point(1000, 10)); // 7-4

		// 8. Point 개념을 이용하여 Line을 만들어 내야한다. Lamda 식 or 반복문을 통해서 만들 수 있다.
		// Lamda 식은 어려울 것 같으니 반복문을 구사하여 Line 객체 5개 만들기.

		/**
		 * 9. listStarPoint를 이용하여서 Line을 만들것 for each 문법을 사용하는게 맞는걸까?
		 * My_A. 처음에는 그렇게 만들려고 생각은했다. 다만 도저히 구현을 못하겠더라 for each 선언부터 해가지고 
		 * 이것을 만들기 위한 질문 : ↓
		 * 변수가 무엇인가요? , 그리고 그것을 어떻게 활용하나요? 값 = 객체 , 
		 * 그것에 대한 이름을 기억할 것인데 다시 돌아가서 그것들을 어떻게 활용할건지
		 */
		makeLinesEffectiveWay(); // 10. 교수님의 방법 성능을 고려한 방법, 함수명 선언하고
		
		DisplayBoard displayBoard = new DisplayBoard(); // 68. displayBoard만들고
		for (Line l : listLine) { // 69. 그리고 Line 정보를 갖고와서 for문을 돌릴것이다.
			l.printToView(displayBoard.getView()); // 70. Line에서 정의한 printToView를 갖고 올것.
		}
		displayBoard.display(); // 71.shape build과정에서 display 출력까지 끝냈다.
	}
	
	public List<Point> getListStarPoint() { // 26.get 함수를 하나 만들어준다. public으로 만든이유는 test하기 위해서
		return listStarPoint; // 27.내용은 listStarPoint를 반환하는 함수
	}

	/**
	 * index를 활용한 구사 방안은 DifficultWay: ListStarPoint의 실제 구현 객체가 무엇인가에 따라 성능적인 손실이
	 * 발생할 수도 있다.
	 */

	private void makeLinesEffectiveWay() { // 11. 선언된 함수를 정의
		boolean isFirst = true; // 20. (prev == null) 성능 향상을 위해서 boolean 구문을 만들어주었다.
		Point prev = null, startPt = null;// 13. 변수 하나를 잡아서 만들어보자 , 17. startPt값도 하나 선언해주자.(마지막 line을 만들기 위해서)

		for (Point point : listStarPoint) { // 12. foreach 구문을 사용해서 성능을 높혀보자
			if (isFirst) { //19. (prev == null) 여기 비교하는 부분도 성능 향상이 가능하다. (prev == null) -> isFirst Change 
				isFirst = false; // 21. 성능을 높히기 위해서 20 boolean 변수를 선언하여서 성능을 높힐 수 있다. , isFirst는 첫 계산때 이후로 사용하지않음
				prev = point; // 14. 반복될때마다 point 값이 prev 값으로 저장
				startPt = point; // 17-1 마지막 Line을 만들기 위한 변수 선언
				continue; // 14-1 그리고 진행
			}
			listLine.add(new Line(prev, point)); // 15. 기억하고 있는 값이 있으면 (1~4 번째)Line을 만들어야한다,(아까전의 값, 현재 값)
			prev = point; // 16. 그래서 현재 값은 아까전의 값으로 저장이 된다. 다음 값으로 넘어가기 위해서
		}
		listLine.add(new Line(prev, startPt)); // 18. 순차적으로 마지막(5번째) Line을 만들기 위해서 선언
	}
}
