package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/12946
/* 
 */
public class programers_재귀_사전찾기 {
	char[] words = "AEIOU".toCharArray();
	
    public int solution(String word) {
    	List<String> result = new ArrayList<String>();
        dic("",result);
        return result.indexOf(word);
    }
   
    public List<String> dic(String preWord, List<String> result) {
    	
    	result.add(preWord);
    	
    	if(preWord.length() == 5) return result;
    	
    	for(int i=0; i<words.length; i++) {
    		dic(preWord+words[i],result);
    	}
		return result;
    }
	    
}

