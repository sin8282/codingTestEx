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

/* 버블정렬
 	일반적으로 우리가 알고있는 for i(){for j} for문에 for 문이 들어가는 형식 존나 기초
 	보통 범위가 작은 것들을 코딩할때 쓴다 . 시간복잡도가 n제곱이므로 존나 오래걸리니 범위가 작은 계산에 유용하다.
*/
public class Test10 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		int A[] = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0; i<N-1; i++) { // -1을 하는 이유는 어차피 맨마지막은 가장큰 수가 올테니 비교를 마친 대상이기 때문이다.
			for(int j=0; j<N-1-i; j++) {
				if(A[j]>A[j+1]) {
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
				}
			}		
		}
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<A.length;i++) {
			sb.append(A[i]+", ");
		}

		System.out.println(sb.toString());
	}
}
