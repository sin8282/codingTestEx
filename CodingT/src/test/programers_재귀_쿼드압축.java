package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
// https://school.programmers.co.kr/learn/courses/30/lessons/68936
/* 여기서부터는 프로그래머스 제출방식에 맞춰서 작성
 * 일반 아래의 배열을 생각해보면 0 4개가 붙어있는 곳만 0으로 압축이됨 이걸생각하고 풀어보자
 * 결국엔 2n배열이므로 정사각형이고 마찬가지로 압축도 정사각형만 된다는걸알 수 있음 그럼 전체가 1 이나 0이면 한번에 끝나고 아니면 반으로 쪼개서 거기에서 전체 검사를 하면됨
 * 이게 int h = size/2; 됨 그리고 2차원배열이므로 현재시점 기준 4개로 쪼개졌다는걸 알 수 있음, 이걸 또 전체 검사를 해야하므로, 추가 로직을 만들생각을 해야함
 * 이게 .add() 이되는 거임 이렇게해서 4면을 검색을하고 그 안에서 또 4면으로 쪼개고 계속 이어져 나가겠금 처리를 했음
 * 그럼이제 압축조건이 어떻게되냐? 아래 배열로하면 4x4가 전부 0,0하고 값이 같으면 1이라고 하는거임
 * 그래서 종료조건은 시작점값 != 반목문으로 돌고있는 값이랑 하나라도 달라지면... 4분할해서 쪼개서 다시작업을하는거임
 * 그래서 0으로 압축되는 부분은 arr[0][2]가 offset이고 이때 값이 주변에 4랑 같음 그래서 따라서 이걸 쭉하고  add매서드에 있는게 계속 처리가 되다보니
 * 부모 호출에 쌓인 값을 불러와서 출력만 하면 되는거임
 */
public class programers_재귀_쿼드압축 {
	
	  public int[] solution(int[][] arr2) {
	    	int[][] arr = {
	    			{1,1,0,0}
	    			,{1,0,0,0}
	    			,{1,0,0,1}
	    			,{1,1,1,1}};
		  	int[] result = new int[2]; 
	        Count cnt = MetrixCal(0, 0, arr.length, arr);
	        result[0] = cnt.zero;
	        result[1] = cnt.one;
	        return result;
	    }
	    
	    public Count MetrixCal(int x, int y, int SquaSize, int[][] arr){

	        for(int i=x; i<x+SquaSize; i++){
	            for(int j=y; j<y+SquaSize; j++){
	                if(arr[y][x] != arr[j][i]){
	                    // 다를때 ㄱ
	                    return MetrixCal(x,y,SquaSize/2, arr)
	                        .add (MetrixCal(x+SquaSize/2,y,SquaSize/2, arr))
	                        .add (MetrixCal(x,y+SquaSize/2,SquaSize/2, arr))
	                        .add (MetrixCal(x+SquaSize/2,y+SquaSize/2,SquaSize/2, arr));
	                }
	            }   
	        }
	        // 맞으면 ㄱ
	        if(arr[y][x] == 0) return new Count(1,0);
	        else return new Count(0,1);
	    }
	    
	    class Count{
	        public int zero;
	        public int one;
	        
	        Count(int zero, int one){
	            this.zero = zero;
	            this.one = one;
	        }
	        
	        private Count add(Count extra){
	            this.zero += extra.zero;
	            this.one  += extra.one;
				return new Count(this.zero,this.one);
	        }
	    }
	
	/*
    public int[] solution(int[][] arr2) {
    	int[][] arr = {
    			{1,1,0,0}
    			,{1,0,0,0}
    			,{1,0,0,1}
    			,{1,1,1,1}};
    	Count count = count(0,0,arr.length,arr);
    	return new int[] {count.zero, count.one};
    }
    
    public Count count(int offsetX, int offsetY, int size, int[][] arr) {
    	int h = size/2;
    	for(int x = offsetX; x<offsetX+size; x++) {
    		for(int y = offsetY; y<offsetY+size; y++) {
	    		if(arr[y][x] != arr[offsetY][offsetX]) {
	    			return count(offsetX, offsetY, h, arr)
	    					.add(count(offsetX+h, offsetY, h, arr))
	    					.add(count(offsetX, offsetY+h, h, arr))
	    					.add(count(offsetX+h, offsetY+h, h, arr));
	    		}
    		}
    	}
    	
		if(arr[offsetY][offsetX] == 1) {
			return new Count(0,1);
		}
		return new Count(1,0);
}
    class Count {
    	public final int zero;
    	public final int one;
    	
    	Count(int zero, int one){
    		this.zero = zero;
    		this.one = one;
    	}
    	public Count add(Count other) {
    		return new Count(zero + other.zero,one+other.one);
    	}
    }
    
    */
}

