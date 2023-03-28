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

/* 유클리드 호제법 최소공약수 구하는 식 두수를 나눴을때 큰%작 = 나머지를 다시 작은수와 나눈다 계속 반복해서 0이 되면 그때 작은수가 최소공약수 
 * 예 30 100 >> 10(나머지) 30 >> 30 % 10 = 0 , 10이 최소공약수 
 * 최소공배수 두수의 곱을 최소공약수로 나눈값, 최소공약수 두수의 공통 약수중 가장작은 값
*/
public class Test23 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());

		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 작
			int b = Integer.parseInt(st.nextToken()); // 큰
			
			System.out.println(a*b/GCD(a,b));
		}
		

		
		}

	private static int GCD(int a, int b) {
		if(b % a == 0) return a;
		else return GCD(b % a,a);
	}
		



	

}
