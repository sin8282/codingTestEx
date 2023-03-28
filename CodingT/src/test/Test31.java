package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;



/*  트리의 부모 찾기
 *  각노드의 부모가 누구냐를 '전체' 출력하는 것이므로 쭉검사하면서 result 배열에 집어넣고 1~N까지 마지막에 출력하면 된다.
 *  검사하면서 넣을때는 DFS를 이용하면 간단하게 해결가능하다.
 *  https://www.acmicpc.net/problem/11725
*/
public class Test31 {
	public static ArrayList<Integer> arr[];
	public static boolean visited[];
	public static int result[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];
		visited = new boolean[N+1];
		result = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		
		for(int i=1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[s].add(t);
			arr[t].add(s);
		}
		
		DFS(1);
		StringBuilder sb = new StringBuilder(); 
		for(int i=2; i<=N; i++) {
			sb.append(result[i]+"\n");
		}
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}
	private static void DFS(int s) {
		visited[s] = true;
		for(int t :arr[s]) {
			if(!visited[t]) {
				result[t] = s;
				DFS(t);
			}
		}
		
	}
	


}


