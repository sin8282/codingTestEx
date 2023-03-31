package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/* 너비 우선 탐색 BFS : 가까운 노드부터 검색하는 알고리즘 
 * DFS와 동일하게 완전 탐색을 하나, FIFO
 * 가까운 노드부터 검색한다.. 최단거리를 의미함. 미로찾기에서 사용됨.
 * https://www.acmicpc.net/problem/2178
4 6
101111
101010
101011
111011
*/
public class Doit_탐색_BFS너비우선 {
	public static int [] dx = {0,1,0,-1};
	public static int [] dy = {1,0,-1,0};
	public static int [][] arr;
	public static boolean[][] visited;
	public static int row;
	public static int col;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		visited = new boolean[row][col];
		arr = new int[row][col];
		
		for(int i=0; i<row; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<col; j++) {
				arr[i][j] = Integer.parseInt(line.substring(j,j+1)); 
			}
		}
		
		BFS(0,0);
		System.out.println(arr[row-1][col-1]);
	}

	private static void BFS(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		visited[i][j] = true;
		q.offer(new int[] {i,j});
		while(!q.isEmpty()) {
			int[] now = q.poll();
			//visited[now[0]][now[1]] = true; 여기다 넣으면 메모리 에러남 , 이러면 현재 방향만 방문한걸로 체크함 
			for(int z=0; z<4; z++) {  //상하좌우 옮겨가며 확인한다.
				int x = now[0] + dx[z];
				int y = now[1] + dy[z];
				if((x>=0 && y>=0)&&(x<row && y<col)) {
					if(!visited[x][y] && arr[x][y] !=0) {
						visited[x][y] = true; // 결국 여기다 넣어야 4방향을 전부 방문한거로 기록함.
						arr[x][y] = arr[now[0]][now[1]]+1;
						q.offer(new int[] {x,y});
					}
				}
			}
		}
		
	}

	
	


}
