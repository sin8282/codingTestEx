package test;

import java.util.Scanner;
/*https://www.acmicpc.net/problem/11720
 * 숫자의 합구하기
*/
public class Doit_자료구조_숫자합구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int array[] = new int[N];
		for(int i=0; i<N; i++) {
			array[i] = sc.nextInt();
		}
		
		long sum = 0;
		long max = 0;
		for(int i=0; i<N; i++) {
			if(max < array[i]) max = array[i];
			sum += array[i];
		}
		
		System.out.println(sum/max*100.0 /N);
		
	}
}
