package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
//https://school.programmers.co.kr/learn/courses/30/lessons/12949
/* 
[[1, 4]    [[3, 3]
 [3, 2]     [3, 3]]
 [4, 1]]
배열곱은 첫항의 행이 두번째항의 열이 곱에 계산값이 된다. 그래서 3x 2 배열이 되는거임
한번 곱해서 그값을 더하기위해서는 A배열 1행 을 B배열 한열씩 곱한걸 더하는거다.
따라서 재귀문 에 k는 이과정을 위한것이고 그때 A배열에 행의 갯수만큼 곱하고 더해지므로 arr1[i]가 되는거다.
*/
public class programers_배열_합계산 {

	
	public static void main(String[] args) throws IOException {
		int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}}, arr2 = {{3, 3}, {3, 3}};
		//int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		int[][] result = new int[arr1.length][arr2[0].length]; 
		
		for(int i=0; i< result.length; i++) {
			for (int j=0; j<result[i].length; j++) {
				for(int k=0; k< arr1[i].length; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		
		System.out.println(Arrays.toString(result));
		
	}

	
}
