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
https://crazykim2.tistory.com/575
https://www.youtube.com/watch?v=624DWEXSehw&t=1480s
Compares its two arguments for order. 
Returns a negative integer,zero, or a positive integer as the first argument is 
less than, equal to, or greater than the second.
*/
public class PriorityQueueTest {
	
	public static void main(String[] args) throws IOException {

		PriorityQueue<Integer> q = new PriorityQueue<Integer>((v1, v2 )-> {
			if(v1 == v2) return 0;
			return (v1 < v2) ? -1: 1; // 이게 기본값이다 그냥 외운답시고보면 12345 순으로 오름차순이 기본값이고 v1-v2 = -음수 일때 이런식으로 솔팅된다.
		});
		

		q.add(1);
		q.add(2);
		q.add(10);
		q.add(4);
		q.add(5);
		
		
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}

	}
}
