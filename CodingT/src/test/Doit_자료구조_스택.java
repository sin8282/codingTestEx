package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/* 스택과 큐 : 
 * 스택 : FILO LIFO Last in First out. 마지막에 들어간게 먼저 나간다. 배열과 같은 구조 같지만 후입선출로 이루어지는 알고리즘 형식.
 * top 삽입과 삭제가 일어나는 위치 
 * push 넣고 , pop 빼고 , peak 확인만 하는 방식으로 구성됨
 * 큐 : FIFO 먼저들어온게 먼저 나감 선입선출 형식
 * add poll peak
 * rear add 되는 위치 front poll되서 나가는 위치
 * https://www.youtube.com/watch?v=vf-i7Q_fN6w&t=772s
 * https://www.acmicpc.net/problem/1874
*/
public class Doit_자료구조_스택 {
	
	public static void main(String[] args) throws IOException {
		boolean isok = true;
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 최초 입력할 갯수
		int A[] = new int[N];
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt(); // 숫자 push하는 값
		}
		Stack<Integer> stack = new Stack<Integer>();
		int num = 1;
		StringBuffer bf = new StringBuffer();
		for(int i=0; i<A.length; i++) {
			int su = A[i]; // 입력받은값 push하는 값
			if(su>=num) {
				while(su>=num) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			}else {
				int n = stack.pop();
				if (su!=n) {
					System.out.println("NO");
					isok = false;
					break;
				}else {
					bf.append("-\n");
				}
			}
		}
		if(isok) {
			System.out.println(bf.toString());
		}
		
	}
}
