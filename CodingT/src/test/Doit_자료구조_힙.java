package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/* 절대값구하기
 * 
 * https://www.acmicpc.net/problem/11286
https://crazykim2.tistory.com/575
https://www.youtube.com/watch?v=624DWEXSehw&t=1480s
Compares its two arguments for order. 
Returns a negative integer,zero, or a positive integer as the first argument is 
less than, equal to, or greater than the second.
*/
public class Doit_자료구조_힙 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> q = new PriorityQueue<Integer>((v1, v2 )-> {
			int abs1 = Math.abs(v1);
			int abs2 = Math.abs(v2);
			if(abs1 == abs2) {
				return (v1 < v2) ? -1 : 1;
			}
			return (abs1 < abs2) ? -1 : 1;
		});
		
		for (int i=0; i < N;i++) {
			int input= Integer.parseInt(br.readLine());
			if (input == 0) {
				if(q.isEmpty()) System.out.println("0");
				else System.out.println(q.poll());
			}else {
				q.add(input);
			}
		}
		

	}
}
