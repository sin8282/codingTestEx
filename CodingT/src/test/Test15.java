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

/* 기수정렬 : n의 시간 복잡도를 갖고 있는 정렬 dn
 * 유일하게 수의 크리를 비교하지 않고 정렬이 된다.
 * 10개의 바구니에 주어진 수의 첫째자리 순번대로 정리해서 넣는다. 0 ~ 9  예 >> 19 54 35  이렇게 주어져있으면 54가 4이므로 더작은수로 생각하고 정리함 54, 35, 19
 * 재배열된 배열에서 다시 그다음 수의자리를 높은 순대로 나열한다. 54, 35, 19 >> 19가 1이므로 맨앞에넣어주고 순서대로하면 19 35 54
 * 10의자리수까지 다했으면 정렬이 끝나거라 판단하고, 그 배열이 곧 정리된 배열  19 35 54
https://velog.io/@justifinition/Algorithm-%EA%B8%B0%EC%88%98-%EC%A0%95%EB%A0%ACRadix-Sort
*/
public class Test15 {
	
	public static Queue<Integer>[] q = new LinkedList[10];
	
	public static void main(String[] args) throws IOException {
		int[] arr = {481, 932, 987, 983, 502, 655, 797, 401, 92, 653};
		radixSort(arr);
		
		System.out.println(Arrays.toString(arr));
	
	}

	private static void radixSort(int[] arr) {
		int div = 1;
		while(div <= 100) {
			for(int i=0; i<q.length;i++) {
				q[i] = new LinkedList<Integer>();
			}
			for(int i=0; i< arr.length; i++) 
				q[(arr[i]/div)%10].offer(arr[i]);
				
				int qi=0;
				for(int i=0; i<10;i++) {
					while(q[qi].isEmpty()) qi++;
					arr[i] = q[qi].poll();
				}
			div *= 10;
		}
	}
	
	


}
