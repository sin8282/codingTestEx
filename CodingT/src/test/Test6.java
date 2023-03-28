package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*슬라이딩 윈도우 알고리즘 : 투 포인트랑 비슷 한데 범위를 지정한 다음 범위를 유지한체로 이동하며  문제를 해결하는 알고리즘
9 8
CCTGGATTG
2 0 1 1
return >> 0
4 2
GATA
1 0 0 1
return >> 2
*/
public class Test6 {
	static int myArr[];
	static int checkArr[];
	static int check;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken()); // 총길이 10
		int P = Integer.parseInt(st.nextToken()); // 맞아야하는 길이 8
		int Result = 0;
		checkArr = new int[4];
		myArr = new int[4];
		char A[] = new char[S];
		check = 0 ;
		
		A = br.readLine().toCharArray(); // 문자열 전체
		st = new StringTokenizer(br.readLine()); // 체크해야하는 ACGT갯수
		for (int i=0; i<4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if(checkArr[i] == 0)	check++;
		}
		
		for(int i=0; i<P; i++) {
			Add(A[i]);
		}
		
		if(check == 4) Result++;
		
		for(int i=P; i<S; i++) {
			int j = i-P;
			Add(A[i]);
			Remove(A[j]);
			if(check == 4) Result++;
		}
		
		
		
		System.out.println(Result);
		
	}

	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if(myArr[0] == checkArr[0]) check--;
			myArr[0]--;
			break;
		case 'C':
			if(myArr[1] == checkArr[1]) check--;
			myArr[1]--;
			break;
		case 'G':
			if(myArr[2] == checkArr[2]) check--;
			myArr[2]--;
			break;
		case 'T':
			if(myArr[3] == checkArr[3]) check--;
			myArr[3]--;
			break;
		}
		
		
	}

	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if(myArr[0] == checkArr[0]) check++;
			break;
		case 'C':
			myArr[1]++;
			if(myArr[1] == checkArr[1]) check++;
			break;
		case 'G':
			myArr[2]++;
			if(myArr[2] == checkArr[2]) check++;
			break;
		case 'T':
			myArr[3]++;
			if(myArr[3] == checkArr[3]) check++;
			break;
		}
		
	}
}
