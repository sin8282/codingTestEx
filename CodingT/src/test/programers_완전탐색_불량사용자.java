package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/42839
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성 중요

 */
public class programers_완전탐색_불량사용자 {
	int answer = 0;
    public int solution(String[] user_id, String[] banned_id) {
        
        String [][] bannedList = new String[banned_id.length][];
        HashSet<HashSet<String>> banSetList = new HashSet<HashSet<String>>();
        for(int i=0; i< banned_id.length;i++) {
        	ArrayList<String> temp = new ArrayList<String>();
        	for(int j=0; j< user_id.length; j++) {
        		if (user_id[j].matches(banned_id[i].replace("*", "."))) {
        			temp.add(user_id[j]);
        		}
        	}
        	bannedList[i] = temp.toArray(new String[temp.size()]);
        }

     
        count(0, new HashSet<String>(), banSetList, bannedList);
        System.out.println(banSetList);
        return banSetList.size();
    }

    public void count(int index, HashSet<String> banSet, HashSet<HashSet<String>> banSetList, String [][] bannedList) {
    	if (index == bannedList.length) {
    		banSetList.add(new HashSet<>(banSet));
    		return;
    	}
    	
    	for(String id :bannedList[index]) {
    		if(banSet.contains(id)) continue;
    		banSet.add(id);
    		count(index+1, banSet,banSetList, bannedList);
    		banSet.remove(id);
    	}
    }
}
