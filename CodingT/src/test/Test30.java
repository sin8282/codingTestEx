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



/*  최소 신장 트리 구하기 
 *  https://www.acmicpc.net/problem/1197
*/
public class Test30 {
	public static PriorityQueue<Node> pq;
	public static int result;
	public static int[] parent;
	public static void main(String[] args) throws IOException {
		int V, E ;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue();
		parent = new int[V+1];
		for(int i=1; i<=V; i++) {
			parent[i] = i;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(a,b,c));
		}
		
		for(int i=0; i<E; i++) {
			union();
		}
		bw.write(result+"");
		bw.close();
		br.close();
		
	}
	

	private static void union() {
		Node node = pq.poll();
		int a = find(node.a);
		int b = find(node.b);
		if(a == b) return;
		if(a != b) {
			parent[b] = a;
			result += node.c;
		}
		
	}


	private static int find(int a) {
		if (parent[a] == a) {
			return parent[a];
		}else {
			return parent[a] = find(parent[a]);
		}
		
	}


	static class Node implements Comparable<Node>{
		int a,b,c;
		
		public Node(int a,int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c < o.c ? -1 : 1;
		}
		
	}
}


