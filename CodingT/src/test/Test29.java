package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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



/* 플로이드 워셔 : 마찬가지로 최단거리를 구하는 알고리즘이나 정해진 출발점이 없고 전체의 최단거리를 다구하는 방식이다. 삼중 FOR문을 이용
 * 때문에 매우느리며 범위또한 1000<아래에서 가능하다 주로 100으로 나옴
 *  https://www.acmicpc.net/problem/11404
*/
public class Test29 {
	public static int arr[][];
	public static int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;//= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] = INF;
				if(i==j) {
					arr[i][j] = 0;
				}
			}
		}
		
		for(int i=0; i<M ;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			arr[a][b] = Math.min(arr[a][b], c);
		}
		
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(arr[i][j] > arr[i][k]+arr[k][j]) 
						arr[i][j] = arr[i][k]+arr[k][j];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(arr[i][j] == INF) { 
					arr[i][j] = 0;
				}
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
}


