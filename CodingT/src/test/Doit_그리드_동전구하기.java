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

/* 그리드 알고리즘 : 최고의 값을 선별할 수 있는 알고리즘 찾는값의 최선이 아닌 최고 값을 배출하므로 문제에서 오류가 생길 수 있다.
 * 때문에 문제에 ai은 ai-1의 배수 요런말이 있을때만 사용해서 풀이가 가능하다.
https://www.acmicpc.net/problem/11047
*/
public class Doit_그리드_동전구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[] arr = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int amt = Integer.parseInt(st.nextToken());
		arr = new int[n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		
		for(int i = n-1; i>=0; i--) {
			count += amt/arr[i];
			amt = amt%arr[i];
			if(amt == 0) break;
		}
		System.out.println(count);
	}

}
