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
이건왜 그리드 문제인지 모르겠네..
https://www.acmicpc.net/problem/1541
*/
public class Doit_그리드_수식최적화 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] arr = s.split("-");
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			int temp = mySum(arr[i]);
			if(i == 0)sum += temp;
			else sum -= temp;
		}
		System.out.println(sum);
	}

	private static int mySum(String s) {
		String[] plus = s.split("[+]");
		int plusSum = 0;
		for(int i=0; i<plus.length; i++) {				
			int temp = Integer.parseInt(plus[i]);
			plusSum += temp;
		}
		return plusSum;
	}
	

}
