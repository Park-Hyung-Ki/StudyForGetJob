package model; //선 그리기 향상 성능 부분이라서 코드 작성 순번이 다름

import view.DisplayBoard;

public class Line {
	private Point startPt, endPt; //3. 점에 관하여 2개의 변수 선언(배열로도 상관은 없다.)

	public Line(Point startPt, Point endPt) { // 4. (2)와 동일하게 생성자 선언
		this.startPt = startPt;
		this.endPt = endPt;
		// 22. Line에서 Point로 가는길은 선언했으니 Point에서 Line으로 가는 길을 선언 addLine
		startPt.addLine(this);
		endPt.addLine(this);
		
	}
	
	public void printToView(char[][] view) {// 39. 정보를 갖고있는 객체가 line이기에 printView를 만들어주는데, char[]][를 값으로 가지면
		double distance = calcDistance();  //46. calcDistance 값이 있으니 선언 해주고
		int xDelta = (endPt.getX() - startPt.getX()) / DisplayBoard.getMaxSteps() ; //47. xDelta값 ,  x쪽으로 걸어갈때의 하나의 값
		int yDelta = (endPt.getY() - startPt.getY()) / DisplayBoard.getMaxSteps(); //48. yDelta값 선언해주고 , y쪽으로 걸어갈때의 하나의 값 방향이 뒤집어질수도 있으니 주의
		int x = startPt.getX() , y = startPt.getY(); // 49. 이 부분은 현재 위치.
		for ( int step = 0 ; step <= DisplayBoard.getMaxSteps(); step++) { // 45. For문을 이용해서 step의 함수를 구할거다. step은 0부터 시작한다.
			view[l2pY(y)][l2pX(x)] = '*'; // 55. l2pY와 X를 호출해서 각각 x,y값으로 선언하고 문자 *로 선언해줄거다. 왜냐 *찍기 거든
			x += xDelta; // 56. x에 대한 걸음걸이 정의
			y += yDelta; // 57. y에 대한 걸음걸이 정의
		}
	}
	
	/**
	 * 논리계에서 2000은 물리계 80으로 맞춰 줄 것이다.
	 * 1300 : 80 = x : r(result)
	 * result = 80 * x / 2000
	 * @param x
	 * @return
	 */
	
	private int l2pX(int x) { // 51. l에서 p가 X로 가는 값을 계산하는 함수를 만들어낼건데
		return DisplayBoard.COLS * x / Shape2.WIDTH; // 52. Shape2.WIDTH에서 1300이 정의 되어있으니 불러온다.
		
	}
	
	/**
	 * 논리게에서 2000은 물리계 30으로 맞춰 줄 것이다. 근데 2000 > 1(첫 번째 칸), 이어야 하고  0 > 30(30번째 칸) 의 조건이 있어야한다.
	 * 2000 : 30 = y : r(result)
	 * result = 30 * y / 2000 
	 * result = 30 - 30 * y / 2000 이렇게 정의 해줘야 한다.
	 * @param y
	 * @return
	 */
	
	private int l2pY(int y) { //53. l에서 p가 Y로 가는 값을 함수로 만들어 봅시다.
		return DisplayBoard.ROWS - (DisplayBoard.ROWS * y / Shape2.HEIGHT + 1); // 54. Shape2.HEIGHT 에서 1200이 정의 되어있으니 불러온다.
		
	}
	
	private double calcDistance() { // 40. 이제 최종 길이를 알아보려고 한다.
		return Math.sqrt((startPt.getX() - endPt.getX())
				* (startPt.getX() - endPt.getX())
				+ (startPt.getY() - endPt.getY())
				* (startPt.getY() - endPt.getY())); // 42. 거리구하는 공식
	}
	
	
	@Override //32. hashCode를 재정의 해줄것이다. 왜? HashSet을 쓰니까
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endPt == null) ? 0 : endPt.hashCode());
		result = prime * result + ((startPt == null) ? 0 : startPt.hashCode());
		return result;
	}


	
}
