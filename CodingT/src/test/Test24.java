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

/* 이분그래프 판별하기 : 서로 인접하지 않는 두집합으로 만들수있는 노드인지 아닌지 판별하는 프로그램
*/
public class Test24 {
	//테스트 케이스 개수
	//노드 개수 엣지갯수
	
	public static ArrayList<Integer>[] arr;
	public static int[] checked;
	public static boolean[] visited;
	public static boolean isEven;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

	
		for (int i=0; i<testCase; i++) {
			String[] s = br.readLine().split(" ");
			int nodeCnt = Integer.parseInt(s[0]);
			int edgeCnt = Integer.parseInt(s[1]);
			
			arr = new ArrayList[nodeCnt+1];
			checked = new int[nodeCnt+1]; // 0 1
			visited = new boolean[nodeCnt+1];
			isEven = true;
			for(int j=1; j<=nodeCnt; j++) {
				arr[j] = new ArrayList<Integer>();
			}

			
			for(int j=1; j<=edgeCnt; j++) {
				String[] node = br.readLine().split(" ");
				int start = Integer.parseInt(node[0]);
				int end = Integer.parseInt(node[1]);
				arr[start].add(end);
				arr[end].add(start);
			}
			
			for(int j=1; j<=nodeCnt; j++) {
				if(isEven){
					DSF(j);
				}else {
					break;
				}
			}
			if(isEven) System.out.println("참");
			else System.out.println("거짓");
		}
		

	}
	private static void DSF(int parent) {
			visited[parent] = true;
			for(int child : arr[parent]) {
				if(!visited[child]) {
					checked[child] = (1+checked[parent]) % 2;
					//visited[child] = true;
					DSF(child);
				}else if(checked[child] == checked[parent]) {
					isEven = false;
					break;
				}
			}

	}

}
