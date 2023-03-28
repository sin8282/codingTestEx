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

/* 삽입정렬
 * 배열의 한부분을 지정하고 이전 인덱스보다 작으면 한칸식 옆으로땡겨서 옮겨놓고 빈 부분에 지정한 값을 넣는 정렬방식
	최적의 경우에는 n의 시간복잡도를 갖지만 최악은 여전히 n제곱이다
*/
public class Test12 {
	
	public static void main(String[] args) throws IOException {
		//Scanner sc = new Scanner(System.in);
		//int size = sc.nextInt();
		int arr[] = {8,10,0,1,3,4,5,4,3,2,1};
		// 5 4 3 2 1
		for (int i=1; i<arr.length; i++) {
			int target = arr[i];
			int j = i-1;
			while(j>=0 && target < arr[j]) { // 일단 0보단 커야할테고 이전 원소들이 큰값이면
				arr[j+1] = arr[j]; //한칸씩 밀어버린다.
				j--; // 그걸 이전 원소를 전부 검색해야하니 j값을 하나씩 빼서 비교한다.
			}
			arr[j+1] = target; // 위에서 루프문을 빠져나올때 -를 해버리니 원자리를 찾을려면 +하는게 맞다
		}
		System.out.println(Arrays.toString(arr));
	}
}
