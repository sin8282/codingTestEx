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

/* 병합 정렬 : 문제를 분할하고 분할한 문제를 정복하여 합치는 과정
	반반 씩 계속 잘라내다보면 해당 배열이 두개만 남게 된다 5,3,4,2 >>>  5,3   4,2
	이때 순서를 정리한다.  >> 3,5    2,4
	앞에껄 비교해서 작은쪽을 왼쪽(오름차순으로 정리 시작한다.) 숫자가 빠지게 되면 인덱스를++하여 다음껄 계산한다.
	 2    <<< 3,5 | ,4
	 2,3  <<<   5  | 4
	 2,3,4,  <<< 5
*/
public class Test14 {
	
	private static int[] sorted = null;
	
	public static void main(String[] args) throws IOException {
	
		int arr[] = {8,2,6,4,7,3,9,5};
		merge_sort(arr);
		
		System.out.println(Arrays.toString(sorted));
		
	}

	private static void merge_sort(int arr[]) {
		sorted = new int[arr.length];
		merge_sort(arr, 0,arr.length-1);
		
	}
	
	private static void merge_sort(int arr[],int start,int end) {
		
		if(start == end) return;
		int mid = (start+end)/2;
		
		merge_sort(arr, start, mid);
		merge_sort(arr, mid+1, end);
		
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int l = start;
		int r = mid + 1;
		int idx = start; // 맨왼쪽부터 넣어줄꺼라서 index를 start로 잡는다.
		
		while(l <= mid && r <= end) { // 이 부분은 서로 주고 받아가며 배열을 정리한다.
			if(arr[l] <= arr[r]) {
				sorted[idx] = arr[l];
				l++; idx++;
			}else {
				sorted[idx] = arr[r];
				r++; idx++;
			}
		};
		
		if(l>mid) {
			while(r<=end) {
				sorted[idx] = arr[r];
				r++; idx++;
			}
		}else {
			while(l<=mid) {
				sorted[idx] = arr[l];
				l++; idx++;
			}
		}
		
		for(int i = start; i <= end; i++) {
			arr[i] = sorted[i];
		}
	}
}
