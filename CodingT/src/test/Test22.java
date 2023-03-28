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

/* 소수구하기 : 에라토스테네스 의 소수구하기를 이용한다. 간단하다.해당수를 계속 더해가며(배수) 존재하는수를 지우면 된다. 
 * 예 : 범위 1 ~ 10 일때 2의 배수 다지워주기 1 2 3 5 7 9 , 이번에는 3의 배수 지워주기 1 2 3 5 7 끝
 * 일반적으로 소수찾을때는 2 부터 시작해서 자기 자신보다 작은수로 나눴을때 나머지가 0인지를 찾는다 4 / 2 = ...0 >> 4는 소수아님 하지만 너무 비효율적( 1~10 까지 전부실행하므로 )
 * 
*/
public class Test22 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int size = m+1;
		int[] arr = new int[size];
		for(int i=1; i<size; i++ ) {
			arr[i]= i;
		}
		
		
		
		for(int i=1; i<Math.sqrt(m); i++) {
			if(arr[i] == 0 || arr[i] == 1) continue;
			for (int j=i+i ; j<m; j+=i) {
				arr[j] = 0;
			}
		}
		
		for(int i=n; i<arr.length-1; i++) {
			if(arr[i] == 0 || arr[i] == 1) continue;
			System.out.println(arr[i]);
		}

	}


	

}
