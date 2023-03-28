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

/* 위상정렬 : 싸이클을 돌지않는 그래프 줄세우기에서 사용되며, 답이 여러가지가 존재할 수 있다.
3 2
1 3
2 3
>>>> 1 2 3 
4 2 
4 2
3 1
>>>> 결과 3 4 1 2 
책에는 4 2 3 1로 나와있음 위상정렬은 답이 여러가지일 수도 있다 
이문제 핵심은 이와 같다. 두 학생의 키를 비교하는 방법을 사용하기로 했다. 단 모든 학생을 비교해 본 것이 아니라 일부 학생들의 키만을 비교해 봤다.
학생 A 가 학생 B의 앞에 서야한다. 즉 4 2, 3 1 을 비교했을때 4>2라고하면 3>1이다 하지만 이 경우 4 3을 비교할 수 있는게 아니다. 때문에 답은 4 3 2 1 ,3 4 1 2 
풀이 방법에 따라, 혹은 순서에 따라 다양하게 나타날 수 있다. 
*/
public class Test26 {
	public static ArrayList<Integer>[] arr; 
	public static int[] inDegree; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		inDegree = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			inDegree[e]++; //진입차수를 관리하기 위한배열  시작값이 아닌 도착지점의 차수를 관리한다.
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			if(inDegree[i] == 0) {
				q.offer(i);
			}
		}
		 
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node+" ");
			for(int deg : arr[node]) {
				inDegree[deg]--;
				if(inDegree[deg] == 0) {
					q.offer(deg);
				}
				
			}
		}
		
	}


}
