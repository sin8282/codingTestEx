package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
//P 사람 , O 빈테이블, X 파티션
//https://school.programmers.co.kr/learn/courses/30/lessons/81302
/*
 조르디 씹새, 일단 문제에서 거리두기를 물어보고있으니 바로 옆에 사람(P)이 있고, 빈테이블(O)이 있으면 그 주변에 또사람이 있는지 한번 더 검사해야함
 보면 주어지는 영문에 값이 String이고 이문제는 배열로 자리를 정하고 풀어야 되므로 char타입에 배열을 만들어 현재가지고 있는 정보를 하나씩 정리해서 담아야함.
 toCharArray를 통해 값을 정리하고, isDistanced로 주변 관계를 파악하면됨, P이면 그냥 거리두기 꽝이니 바로 return false하고, O일때는 그주변을 한번 더검색, X는 잘하는거니 그냥 패스
 이때 O는 내가 갔던 정보는 제외해줘야함. 즉 내가 왼쪽에서 오른쪽으로 온거라면 현재시점에서 왼쪽은 들어왔던 입구임. 여기를 계산할 필요가 없음.그게 아래의 dx,dy를 고정으로 외워놔야하는 이유이고 
 3-d 되는 이유임 (상+하 = 3 좌+우 = 3) 현재 내가 오른쪽이다? 그럼 2인거고  3-2 = 1 즉 1번째(왼쪽)는 계산하지말고 넘겨라.이런뜻
 */
public class programers_배열_조르디거리두기 {
	public static int[] dx = {0,-1,1,0}; // 이건 거진 이렇게 고정으로 외워야할거같음.. 그래야 인덱스가 상+하 = 3 좌+우 = 3이됨.
	public static int[] dy = {-1,0,0,1};
	
	public static void main(String[] args) throws IOException {
		String [][] places = {
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
				, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
				, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
				, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
				, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		};
		
		int answer[] = new int[places.length];
		for(int i=0; i<places.length; i++) {
			String[] place = places[i];
			char[][] room = new char[places.length][];
			for(int j=0; j<room.length; j++	) {
				room[j] = place[j].toCharArray();
			}
			
			
			if(isDistanced(room)) 
				answer[i] = 1;
			else 
				answer[i] = 0;
			
		}
		
		
		
		System.out.println(Arrays.toString(answer));
	}

	private static boolean isDistanced(char[][] room) {

		for(int y=0; y<room.length; y++) {
			for(int x=0; x<room[y].length; x++) {
				if(room[y][x] != 'P') continue;
				if(!isDistanced(room,x,y)) return false;
			}
		}
		return true;
		
	}
	
	private static boolean isDistanced(char[][] room, int x, int y) {
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(ny < 0 || ny >= room.length|| nx < 0 || nx >= room[ny].length) continue;
			switch(room[ny][nx]) {
				case 'P': return false;
				case 'O': if(isNextPerson(room,nx,ny,3-d)) return false; break;
			}
		}
		
		return true;
	}

	private static boolean isNextPerson(char[][] room, int x, int y, int except) {
		for(int d=0; d<4; d++) {
			if (d == except) continue;
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if(ny < 0 || ny >= room.length|| nx < 0 || nx >= room[ny].length) continue;
			if(room[ny][nx] == 'P')  return true;
				//isNextPerson(room,nx,ny,3-d); 재귀안해도된다 어차피 위에서 for문으로 전체 검사할것이므로 'O'가 왔을때 'P'만아닌지 확인

		}
		return false;
		
	}
}
