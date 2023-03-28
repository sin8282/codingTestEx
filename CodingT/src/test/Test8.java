package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/* 큐문제 카드게임
카드맨앞에 있는거는 버리고, 그다음꺼는 맨뒤로 보내라.. 라는 문제

*/
public class Test8 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<Integer>();
		int N = sc.nextInt();
		for (int i=1; i <= N; i++) {
			q.add(i);
		}
		
		while(q.size()> 1) {
			q.poll(); // 버리고 
			q.add(q.poll()); // 또버리는게 아닌 버리면서 앞으로 이동해줌 
		}
		System.out.println(q.poll());
		
	}
}
