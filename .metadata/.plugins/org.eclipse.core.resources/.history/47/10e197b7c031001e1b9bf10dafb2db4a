package com.day17;

import java.util.ArrayList;
import java.util.Stack;

public class Prims {
	
public static ArrayList<ArrayList<Integer>> convertToAdjList(int[][] matrix) {
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<matrix.length;i++) {
			ArrayList<Integer> row = new ArrayList<Integer>();
			
			for(int j=0;j<matrix[i].length;j++) {
				if(matrix[i][j]==1) {
					row.add(j);
				}
			}
			adjList.add(row);
		}
		
		return adjList;
		
		
	}
	
	
	
	public static int dfs(ArrayList<ArrayList<Integer>> adjList) {
	    ArrayList<Integer> dfs = new ArrayList<>();
	    
	    Stack<Integer> stack = new Stack<>();
	    boolean[] visited = new boolean[adjList.size()];
	    
	    stack.push(0); // Start from node 0
	    visited[0] = true;
	    int total=0;
	    while (!stack.isEmpty()) {
	        int node = stack.pop();
	        dfs.add(node);
	        
	        for (int neighbor : adjList.get(node)) {
	        	int min = Integer.MAX_VALUE;
	            if (!visited[neighbor] && neighbor<min) {
	            	min=neighbor;
	            	total+=neighbor;
	                visited[neighbor] = true;
	                stack.push(neighbor);
	                break;
	            }
	        }
	    }
	    
	    return total;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int adj[][]= {{0,4,0,8,0,0,0,0},
				{4,0,3,0,0,0,0,0},
				{0,3,0,0,0,0,2,1},
				{8,0,0,0,3,0,0,0},
				{0,0,0,3,0,7,0,0},
				{0,0,0,4,7,0,6,0},
				{0,0,2,5,0,6,0,7},
				{0,0,1,0,0,2,7,0}};

		
		ArrayList<ArrayList<Integer>> adjList = convertToAdjList(adj);
		
//		System.out.println(dfs(adjList));
		int ans = dfs(adjList);
		
//		for(int i: ans) {
//			System.out.print((char)(i+65)+" ");
//		}
		System.out.println(ans);
		
	}

}
