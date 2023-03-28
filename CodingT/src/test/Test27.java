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

import test.Test27.Node;

/* 다익스트라 알고리즘 가중치가 존재(양수+)하는 최단거리를 계산할때 사용한다. https://www.acmicpc.net/problem/1753
 * 길찾기에서 최단거리 계산할때 사용한다 1 --(3)--> 2 : 1에서 2까지가는데 거리가 3이라고하면 1 2 3 으로 나타낸다.
 * 이때 2 3은 배열에 넣기 곤란하므로 객체로 만들어서 넣는다 node(2,3)
 * 거리 배열(distance)을 하나 만들어서 초기화(99999)시켜주고 최단거리일때 업데이트를 해준다.
 * 2까지 도착했으면 다음 행선지가 있는지 확인해본다. 2 --(5)--> 3, 2 --(2)--> 4, 2 3 5 , 2 4 2
 * 2도착지점에서는 두가지 경로로 나눠지므로 arr[2].add(node(3,5)) , arr[2].add(node(4,2)) 두가지를 add해줬을테고 이를 한번 방문한곳이 아니면 (visited[v]) 출발지를 2로 셋팅해서 다시 돌려본다.
 * 이전에 1 --(3)--> 2 거리 3과 2 --(5)--> 3 거리 5를 더해 8이되고 이를 업데이트 해야한다. 
 * 이때, 다른 경로에서 이미 구해진 distance[2]가 8보다 작으면 이 길은 최단이 아니라 판단하고 업데이트 하지 않는다.
 * 계속 진행하다보면 결국 최단거리에 도달하고 그때의 distance를 불러오면 된다.
*/
public class Test27 {
	
	public static ArrayList<Node>[] arr;
	public static boolean[] visited;
	public static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[V+1]; 
		visited = new boolean[V+1];
		distance = new int[V+1];
		Arrays.fill(distance, 99999); // 간선 배열에 초기에는 무한인것 처럼 셋팅해줘야 처음 값을 비교가능하다 4 < 99999(처음)
		for(int i=1; i<=V; i++) {
			arr[i] = new ArrayList<Node>();
		}
		int start = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			arr[u].add(new Node(v,w));
		}
		
		dijkstra(start);
		
        for(int i=1;i<=V;i++){
            System.out.println(distance[i]==99999?"INF":distance[i]);
        }
		
	}

	private static void dijkstra(int start) {
		distance[start] = 0;
		Node s = new Node(start, 0);
		Queue<Node> q = new LinkedList<Node>();
		q.offer(s);
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int v = cur.v;
			int w = cur.w;
			
			if(visited[v]) continue;
			else {
				visited[v] = true;
				for(Node ch : arr[v]) {
					if(distance[ch.v]> distance[v]+ch.w) { // 도착지점의 거리(여지껏 계산된 최단거리) > 현재지점 거리 + 도착까지 가는 간선(일반 적으로 문제에서 주어진 거리)
						distance[ch.v] = distance[v]+ch.w; // 최단거리를 정하는 것이므로 도착지점 = 현재지점 거리 + 도착까지 가는 간선
						q.offer(new Node(ch.v,distance[ch.v]));
					}
				}
			}
		}
		
		
		
		
	}

	static class Node implements Comparable<Node>{
		int v,w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return 0;
		}
		
	}
}
