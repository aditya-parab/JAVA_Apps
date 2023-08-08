package com.day16;

import java.util.Stack;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] adj = 
			{   {0,1,0,1,0,0,0},
				{1,0,1,0,0,0,1},
				{0,1,0,0,0,1,1},
				{0,1,0,0,0,1,1},
				{1,0,0,0,1,0,1},
				{0,0,0,1,0,1,0},
				{0,0,1,0,1,0,1},
				{0,1,1,1,0,1,0}  };
		
		Stack<int[]> stack = new Stack<int[]>();
		stack.push(adj[0]);
		
		System.out.print('A');
			
		while(!stack.isEmpty()) {
			int [] curr = stack.pop();
			for(int i=0;i<curr.length;i++) {
				if(curr[i]==1 || set.contains(adj[i])) {
				stack.push(adj[i]);
				System.out.print(i+95);
				}
			}
		}
			
		
	}

}
