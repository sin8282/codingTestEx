package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*투 포인터 : 두개의 포인터를 움직이면서 수식을 처리하는 개념 거의 정렬을 해야 할 수 있는 문제가 90%가 넘으므로 솔트를 하고 진행해라.
https://www.youtube.com/watch?v=BA8zkffKc88&t=980s
https://www.acmicpc.net/problem/1940
*/
public class Doit_자료구조_투포인터_주몽의명령 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 갯수
		int M = Integer.parseInt(br.readLine()); // 조합 합
		int[] array = new int[N]; // 재료 숫자들
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		int count = 0;
		int i = 0;
		int j = N-1;
		while (i<j) { // 두 포인터가 곂처지는 순간 다 훓어 본거라서 더이상 필요가 없다.
			if(array[i]+ array[j] > M) {
				j--;
			}else if(array[i]+ array[j] == M) {
				j--; i++; count++;
			}else {
				i++;
			}
		}
		System.out.println(count);
	}
}
