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

/* 중간에 노드를 정하고 왼쪽이나 오른쪽에 한쪽을 선택해서 계속 절반을 비교해서 찾아가는 방식  찾을려는 값이 작거나 크면 왼쪽이나 오른쪽을 그냥 배제한다.
 * 왼쪽이 작은거 오른쪽이 큰수 이런식으로 정하고 진행하는거기 때문에 꼭 정렬 되어있어야 사용가능하다.
 * nlogn의 시간 복잡도를 갖고있다.

*/
public class Test18 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int[] find = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			find[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int start = 0; // +
			int end = m-1; // -
			boolean isCheck = false;
			while (start <= end) {
				int mid = (start + end) / 2;
				if (arr[mid] < find[i]) {
					start = mid + 1;
				} else if (arr[mid] > find[i]) {
					end = mid - 1;
				} else {
					isCheck = true;
					break;
				} 	
			}
			
			if(isCheck)System.out.println("1");
			else System.out.println("0");
		}

	}

}
