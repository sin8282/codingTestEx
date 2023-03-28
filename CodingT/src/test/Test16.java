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

/* 깊이 우선탐색 DFS : 노드로 이루어진 리스트에서 가장뿌리가 깊은 쪽 우선으로 검색을해서 데이터를 처리해주고
 * 나머지를 처리하는 개념  FILO
 * 
 * 6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3

6 5
1 2
2 5
5 1
3 4
5 6
 * https://www.youtube.com/watch?v=Y2kHlj7xqfU&t=2011s
*/
public class Test16 {
	public static ArrayList<Integer>[] arr;
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 노드의 범위
		int m = Integer.parseInt(st.nextToken()); // 노드의 갯수
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		int count=0;
		
		for (int i=1; i<n+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		for (int i=1; i<m+1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}

		for (int i=1; i<n+1; i++) {
			if(!visited[i]) {
				DFS(i);
				count += 1;
			}
			
		}
		
		System.out.println(count);
	}

	private static void DFS(int v) {
		if(visited[v]) return;
			
		visited[v] = true;
		
		for(int i : arr[v]) {
			if(!visited[i]) DFS(i) ;
		}
		
	}

	
	


}
