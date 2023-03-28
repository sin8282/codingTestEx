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

/* 선택정렬
 선택정렬은 버블때문에 잘 안나오기는 하는데 어차피 비슷한원리임 다만 버블처럼 앞뒤 두개를 비교하는게 아닌 
 선택한 인덱스에 전체중에 최솟값이랑 스왑하고 다음 인덱스로 넘어가는 원리 
*/
public class Test11 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int index = 0;
		for (int i=0; i<n; i++ ) {
			a[i] = sc.nextInt();
		}
		
		for (int i=0; i<n-1; i++) {
			index  = i;
			for (int j=i+1; j<n; j++) {
				if(a[j] < a[index]) {
					index = j;
				}
			}
			int temp = a[index];
			a[index] = a[i];
			a[i] = temp;
		}
		


		System.out.println(Arrays.toString(a));
	}
}
