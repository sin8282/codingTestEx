package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*구간합 배열에 합계산한걸 집어넣어서 일반배열에서 합을 바로 바로 빼서 쓸수 있게 만든 배열
S[i] = S[i-1] + A[i] // S의 합배열에 현재 A[i]배열을 더하면 그게 곧 현재 index의 합이되는 개념
S[j] - S[i-1] // 이게 구간 합이라는 개념이 됨
*/
public class Test3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 받는데이터가 많을때는 buffered 를 사용하는게 낫다.
		StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());//10만개 이상들어오면 인트로 받기 힘듬 StringTokenizer를 사용
		int suNo = Integer.parseInt(stringTokenizer.nextToken());
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
		long[] S = new long[suNo+1]; // 0부터 시작하는게 귀찮으니 +1로 처리
		stringTokenizer = new StringTokenizer(br.readLine());
		for(int i=1; i<=suNo; i++) {
			S[i] = S[i-1] +Integer.parseInt(stringTokenizer.nextToken()); 
		}
		
		for (int q=0; q<quizNo; q++) {
			stringTokenizer = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(S[j]-S[i-1]);
		}
	}
}
