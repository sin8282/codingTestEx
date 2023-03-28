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



/* 벨만포드 : 다익스트라 처럼 가중치가 있는 최단거리 찾을때 사용하나 음수 가중치(-)가 가능하다.
 * 다익스트라처럼 풀이법이 완전 같으나 음수가중치를 비교하기위해 출발점을 Node Class에 추가하여 진행한다.
 * https://www.acmicpc.net/problem/11657
*/
public class Test28 {
	static int N, M;
	static ArrayList<Bus>[] arr;
	static long[] distance;
	static final long INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new ArrayList[N+1];
		distance = new long[N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = new ArrayList<Bus>();
			distance[i] = INF;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());	
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			arr[A].add(new Bus(A,B,C));
		}
		
		StringBuilder sb= new StringBuilder();
		if(belman()) {
			for (int i=2; i<=N; i++) { // 첫번째는 시작점이니 패스
				if(distance[i] == INF) sb.append("-1\n");
				else sb.append(distance[i]+"\n");
			}
		}else sb.append("-1"+"\n");
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	
	private static boolean belman() {
		distance[1] = 0;
		
		for (int i=1; i<=N; i++) {
			for(Bus bus :arr[i]) {
				if(distance[i] == INF) break;
				if(distance[bus.e]> distance[bus.s]+bus.w ) {
					distance[bus.e] =  distance[bus.s]+bus.w;
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			for(Bus bus :arr[i]) {
				if(distance[i] == INF) break;
				if(distance[bus.e]> distance[bus.s]+bus.w ) {
					return false;
				}
			}
		}
		
		return true;
	}

	public static class Bus{
		int s, e, w;
		public Bus(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
	}

}


