package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성

 */
public class programers_완전탐색_소수찾기2풀이 {

    public int solution(String params) {
    	int answer = 0;
    	Set<Integer> primes = new HashSet<>();
    	int[] numbers = params.chars().map(c -> c-'0').toArray();
        getPrimes(0, numbers, new boolean[numbers.length], primes);
    	
        return primes.size();
    }

	private void getPrimes(int n, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
		if(isPrime(n)) primes.add(n);
		
		for(int i=0; i<numbers.length; i++) {
			if(isUsed[i]) continue;
			int next = n*10+numbers[i];
			isUsed[i] = true;
			getPrimes(next, numbers, isUsed, primes);
			isUsed[i] = false;
		}
		
		
	}

	private boolean isPrime(int n) {
		if (n<=1) return false;
		for(int i = 2; i< Math.sqrt(n); i++) {
			if (n%i == 0) return false;
		}
		return true;
	}
    
   

}
