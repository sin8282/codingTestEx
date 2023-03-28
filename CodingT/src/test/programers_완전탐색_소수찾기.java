package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성

 */
public class programers_완전탐색_소수찾기 {
	String[] words;
	List<String> wordsToArray;
    public int solution(String numbers) {
    	words = numbers.split("");
    	wordsToArray = new ArrayList(Arrays.asList(words));
        int answer = 0;
        
    	ArrayList<Integer> result = new ArrayList<Integer>();

    	
    	Permutation("",result);      
        System.out.println(result);
        for(int n : result) {
        	if(isPrime(n)) answer++;
        }

		
        
        return answer;
    }
    
    private boolean isPrime(int n) {
    	if(n ==0 || n == 1) return false;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i == 0) {
				System.out.println(n);
				return false;
			}
		}
		return true;
	}

	public void Permutation(String preWord, ArrayList<Integer> result) {
    	if(preWord.length()>0) {
    		int s = Integer.parseInt(preWord);
    		if(isUsed(preWord,words)) {
    			if(!result.contains(s))
    				result.add(s);
    		}
    	}
    
    	if(preWord.length() != wordsToArray.size()){
    		for(int i=0; i<wordsToArray.size(); i++) {
    			String s = wordsToArray.get(i).toString();
    			//wordsToArray.remove(i);
    			Permutation(preWord+s, result);
    		}
    	}

    }

	private boolean isUsed(String preWord, String[] words) {
		for (String s :words) {
			preWord = preWord.replaceFirst(s,"");
		}
		if(preWord.length()!=0) return false;
		return true;
	}

}
