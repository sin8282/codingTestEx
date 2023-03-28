package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/12946
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성
 * 이거 존나 이해하기 어렵네  여기서 3하고 4로 하고 게임 한판 해보셈 https://vidkidz.tistory.com/649
 * 자그러면 마지막 바닥에 있는건 고정하고 나머지 위에있는거 예로 3이라하고 바닥이 1이면, 1번기둥에 1 2번 기중에 2 3 가 오게 할 수 있음 마찬가지로 예가 4면 1기둥:  1 ,2기둥:  234 ,3기둥:x 이게 가능함.
 * 이걸 세겨놓고 기둥 설명을 하면 기둥은 3개이니 1+2+3이라고 하고 총 6에서 from to 로 어디를 갈지 선택이가능함. 예 from :1 to :2   6-1-2 = 3 즉 마지막 기둥이 현재 안갔던 혹은 비어있는 기둥임
 * 그럼 위에 바닥과 기둥을 종합해보면 n이 4개일때, 234(3개)는 두번째기둥에, 1는 첫번째기둥에 놓일수있고 이걸 n-1, 1로 나타낼 수 있음
 * 즉 n-1을 가운데 로 옮김 > n(1)을 마지막 기둥으로 옮김 > 가운데 있는 걸 마지막에 옮김 > 끗임
 * 그럼 empty = 6 - from - to; 이렇게 정하고 empty에 234을 쌓게 하면됨
 * 그리고 1을 3번기둥으로 옮기고, empty에 있는n-1전체를 3번기둥으로 옮기면 끝
 */
public class programers_재귀_하노이탑 {
    public int[][] solution(int n) {
    	List<int[]> result = new ArrayList<int[]>();
    	hanoi(n,1,3,result);
        return result.toArray(new int[0][]);
    }
    
    public void hanoi(int n, int from, int to, List<int[]> result) {
    	if (n == 1) {
    		result.add(new int[] {from, to});
    		return;
    	}
    	
    	int empty = 6 - from - to;
    	
    	hanoi(n-1,from, empty, result); //바닥빼고 전체 n-1 중간에
    	hanoi(1,from, to, result); // 바닥 마지막기둥으로
    	hanoi(n-1,empty, to, result); // 뺀거전부 바닥위에 쌓기
   
    }
	    
}

