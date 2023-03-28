package test;

import java.util.Scanner;

public class Test1 {
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
