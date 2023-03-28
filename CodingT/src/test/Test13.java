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

/* 퀵정렬 악조건일때는 n제곱을 갖지만 평균적으로는 nlogn이며 병합보다도 빠른 정렬방식
 *  java.Sort 매서드가 이방식을 이용하고 있으며, 방식은 기준점(피벗)을 두고 왼쪽으로는 작은수 오른쪽으로는 큰수를 배열로 만들어 나눈다. 이때 기준숫자는 한쪽배열끝에 넣어둔다.
 *  이 배열들은 또 자신들만에 피벗을 갖고 이를 기준으로 좌작은수 우큰수로 나눠가며 배열이 2가 될때까지 loop를(재귀) 한다 그럼 sort된거다.
*/
public class Test13 {
	
	public static void main(String[] args) throws IOException {
	int arr[] = {7,6,3,2,9,1,8,5,4,10};
	quickSort(arr, 0, arr.length-1);
	
	System.out.println(Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int start, int end) {
		int part = partition(arr, start, end);
		if(start < part-1) quickSort(arr,start,part-1); // 왼쪽
		if(end > part) quickSort(arr,part,end); // 오른쪽
		
	}

	private static int partition(int[] arr, int start, int end) {
        int pivot=arr[(start+end)/2]; // 여기서 피벗은 그냥 중간 값으로 정했다 이기준을 중심으로 좌우 나뉘게 된다.
        while(start<=end) {
            while(arr[start]<pivot) start++;
            while(arr[end]>pivot) end--;
            if(start<=end) {
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
	}

	private static void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
		return;
		
	}
}
