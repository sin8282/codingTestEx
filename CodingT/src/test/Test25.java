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

/* 파인드 유니온 연산: 유니온을 통해 서로의 연관관계를 지정해주고 , 파인드를 통해 연관관계가 있는지 참 거짓 혹은 그값을 알 수있게 하는 알고리즘
 * 원소 개수, 질의 개수
 * 0일때 유니온
 * 1일때 파인드
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 2 4
*/
public class Test25 {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			arr[i] = i;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int type = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(type == 0) {
				union(a,b);

			}else {
				boolean isUnion= compare(a,b);
				if(isUnion) System.out.println("YES");
				else  System.out.println("NO");
			}
		}
		
	}

	private static boolean compare(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) return false;
		else return true;
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			arr[b] = a;
		}
		
	}

	private static int find(int node) {
		if(node == arr[node]) return node;
		else return arr[node] = find(arr[node]);
	}

}
