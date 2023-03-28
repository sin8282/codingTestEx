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

/* 오일러 피 구하기 : 서로수  자기자신 제외하고 나눠지지않는 수의 갯수 13은 1말고는 아무것도 안나눠지므로 12개의 서로수를 갖는다
 * 자연수 n이 주어졌을 때, GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 구하는 프로그램을 작성하시오. 요런문제 이건 그냥 외워야할 듯?
*/
public class Test21 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long pi = n;
		for(long i=2; i*i<=n; i++) { // 제곱근까지 돌리는 규칙 1은 제외한다.
			if(n%i==0) {
				pi = pi/i*(i-1); //2,6,12,24
			}
			while(n%i==0) { //전부나눠서 남는게 없게한다.
				n/=i;
			}
			
		}
		if(n!=1) { //만약 1이 아니면 나줘진게 없다는걸로 판단하고 전체가 서로수인걸로... (자기 제외)
			pi = pi/n*(n-1);
		}
		System.out.println(pi);
	}
	


	

}
