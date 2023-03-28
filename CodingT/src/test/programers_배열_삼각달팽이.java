package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/68645
/*
 1  x  x  x
 2  9  x  x
 3 10  8  x
 4  5  6  7
 문제에서는 삼각형으로 표현했지만 그냥 배열에 직사각형으로만들어서 사용해도 된다. (위에처럼)
 그럼이때 스타트는 0,0에서 아래로 내려가는 것이므로 이것을 표현한게 dy[0]임 ,마찬가지로 오른쪽은 dx[1] 왼쪽위로올라가는건 둘다 마이나스인 dx[2] dy[2]
 그럼 이걸이용해서 만들면 그만임 단, 값이 배열판을 벗어나는 경우 nx == n nx== -1 또는 해당 위치에 값이 존재하는경우 -> 이미 답이 계산된곳 즉, 막다른길이거나 방향을 바꿔줘야하는 부분 
 그때마다 dx dy 를 1++해주고 진행하면 된다.
 */
public class programers_배열_삼각달팽이 {
	public static int[] dx = {0,1,-1};
	public static int[] dy = {1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = 0 , y = 0;
		int v = 1;
		int [][] triangle = new int[n][n];
		int[] result;
		int d = 0;
		
		while(true) {
			triangle[y][x] = v++;
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
				d = (d+1) % 3;
				nx = x + dx[d];
				ny = y + dy[d];
				if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
			};

			x = nx;
			y = ny;
		}
		
		
/*		while(true) {
			while(true) {
				triangle[y][x] = v++;
				if(y+1 == n || triangle[y+1][x] != 0) break;
				y++;
			}
			if(x+1 == n || triangle[y][x+1] != 0) break;
			x++;
			
			while(true) {
				triangle[y][x] = v++;
				if(x+1 == n || triangle[y][x+1] != 0) break;
				x++;
			}
			if(triangle[y-1][x-1] != 0) break;
			x--; y--;
			
			while(true) {
				triangle[y][x] = v++;
				if(triangle[y-1][x-1] != 0) break;
				x--; y--;
			}
			if(y+1 == n || triangle[y+1][x] != 0) break;
			y++;
		}
		*/
		result = new int[v-1];
		int index = 0;
		for(int i=0; i<n;i++) {
			for(int j=0; j<=i;j++) {
				result[index++] = triangle[i][j];
			}
		}
		
		System.out.println(Arrays.toString(result));
	}
}
