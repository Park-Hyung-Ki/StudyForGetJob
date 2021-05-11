package test;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.Line;
import model.Point;
import model.Shape2;

class TestBuilding2 { // 람다식 만들어보려고 한거

	@Test
	// 이거 만드는 이유는 별모양 그림에 들어있는 모든 점(5개)들을 대상으로 각 점에 달린 라인을 모아서 유일한 것만 추려내면 이 또한 모두
	// 5개이다.
	void test() {
		try {
			Shape2 star = new Shape2(); // 25.새로운 package를 만들고 j_unit test를 만들어본다.
			// star.getlistStarPoint().stream().map(p->{return p.getlistLine();}); //28->32.
			// 아까 만든 함수에 람다 식을 사용할것 ,32.point 객체를 p라고 하고
			// 32-1.우리는 각각의 것들을 적용할거다. {p.getlistLine();} 이러한 부분을 forEach가 void라서 반환값이 없다.
			// 33. map을 쓰면 반환을 받을 수 있다. for each -> map으로 바꾸고 return p.getlistLine();으로 선언
			// 33-1. mapping하고 어떠한 객체를 다른 객체로 변환 여기는 신경X

			// *28 람다를 선언하지않을때 어떻게 만들것인지 (28~35) 까지
			Set<Line> distinctLineSet = new HashSet<>(); // 31. Set(집합) 선언이 가능한데, 여기서도 선택지가 많아진다. HashSet을 쓸것
			for (Point p : star.getListStarPoint()) { // 29. p선언 해주고
				for (Line l : p.getListLine()) { // 30. 이중 반복문으로 만들어주고
					distinctLineSet.add(l); // 34. l 객체를추가한다.
				}
			}
			assert (distinctLineSet.size() == 5); // 35.distinctLineSet에 들어있는 객체의 개수는 5개 이어야한다.
			/*
			 * distinctLineSet = star.getListStarPoint().stream().map(p->{return
			 * p.getListLine();}).iterator().next().stream().collect(Collectors.toSet());//
			 * 36. 람다식을 다시금 만들어 볼건데 // 36. star모양이 몇개의 목록을 갖고 있니? -> 5개, 빨대 꽂고 변환함수 구한걸 p라고
			 * 하고, 그 p에서 line2개 들어있는 객체들을 받는다. // 그리고 그 list 객체들을 반복구문을 돌리면 line이 나오고 다시 빨대
			 * 꽂으면 집합이 나온다. assert(distinctLineSet.size() == 5); // 37. 36의 작업을 통해서 37의 값이
			 * 5개가 나올 수 있는지.
			 */ // 시간상의 문제로 도저히 할 수가없다. List를 반환하는 map 람다 식에서 값을 꺼낸후 개별 객체로 환원하기.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
