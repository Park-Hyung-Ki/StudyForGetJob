package view;

public class DisplayBoard { // 36. 별들을 그릴 Board를 만들어 봅시다.
	public static int ROWS = 30, COLS = 80; // 37. 상수로 해상도를 설정

	private char[][] view = new char[ROWS][COLS]; // 38. char에다가 2차원 배열을 사용할것

	public static int getMaxSteps() { // 43. 최대 걸음걸이의 함수를 만들 것이다.
		return ROWS > COLS ? ROWS : COLS; // 44. ROWS가 큰지 COLS가 큰지 확인하는것 어느순간, ROWS가 커지는 순간이 올것이다. 그렇기 때문에 이렇게 서술
	}

	public char[][] getView() { // 67. getView 생성해준다
		return view;
	}

	public void display() { // 60. 바깥쪽에서 부르니까 public
		for (int r = 0; r < ROWS; r++) { // 61. r에 대한 for문 정의
			for (int c = 0; c < COLS; c++) { // 62. c에 대한 for문 정의
				if (view[r][c] != '*') {
					System.out.print(' '); // 65. *이 아니면 공백을 찍어줄거고
				}else {
					System.out.print(view[r][c]); // 64. 찍어낼 배열
			}
		}
		System.out.println(); // 63. 줄바꾸기 해주고
		}
	}
}