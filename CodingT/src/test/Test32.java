package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;



/*  트리 순회하기
 *  트리를 순회할때는 상하 관계를 따져가며 하나씩 넣으며 작업을한다. 
 *  결국에 누구가 누구의 부모노드이냐 하는건 Node에 left right parent로 구성이 되니 마지막에 출력할때 순회하면서 출력만 해주면 된다.
 *  https://www.acmicpc.net/problem/1991
*/
public class Test32 {
	public static Node root;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		root = new Node('A');
		int N = Integer.parseInt(st.nextToken());
		Tree tree = new Tree();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree.searchNode(parent,left,right);
		
		}
		
		tree.preOrder(root);
		System.out.println();
		tree.inOrder(root);
		System.out.println();
		tree.postOrder(root);
	}
	
	
	public static class Tree{
		public void preOrder(Node node) {
			System.out.print(node.parent);
			if(node.left != null ) preOrder(node.left);
			if(node.right != null) preOrder(node.right);
			
		}

		public void inOrder(Node node) {
			if(node.left != null ) inOrder(node.left);
			System.out.print(node.parent);
			if(node.right != null) inOrder(node.right);
			
		}

		public void postOrder(Node node) {
			if(node.left != null ) postOrder(node.left);
			if(node.right != null) postOrder(node.right);
			System.out.print(node.parent);
			
		}
		
		public void searchNode(char parent, char left, char right){
			if(root.parent == parent) {
				if(left != '.')	 root.left = new Node(left);
				if(right != '.') root.right = new Node(right);				
			}else {
				searchNode(root,  parent, left, right);
			}
		}

		public static void searchNode(Node root, char parent, char left, char right){
			if(root == null) {
				return;
			}else if(root.parent == parent) {
				if(left != '.')	 root.left = new Node(left);
				if(right != '.') root.right = new Node(right);				
			}else {
				searchNode(root.left,  parent, left, right);
				searchNode(root.right,  parent, left, right);
			}
		}
	}

	
	public static class Node {
		char parent;
		Node left;
		Node right;
		Node(char parent){
			this.parent = parent;
		}
		
		@Override
		public String toString() {
			return "Node [parent=" + parent + ", left=" + left + ", right=" + right + "]";
		}
		
	}

}


