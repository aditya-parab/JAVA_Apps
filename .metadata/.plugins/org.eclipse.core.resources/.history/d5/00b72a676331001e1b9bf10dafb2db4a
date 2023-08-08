package com.day17;

import java.util.ArrayList;

public class convertAdjMatrixToAdjList {

	
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] adjMatrix = 
			{   {0,1,0,1,0,0,0},
				{1,0,1,0,0,0,1},
				{0,1,0,0,0,1,1},
				{0,1,0,0,0,1,1},
				{1,0,0,0,1,0,1},
				{0,0,0,1,0,1,0},
				{0,0,1,0,1,0,1},
				{0,1,1,1,0,1,0}  };
		
		System.out.println(convertToAdjList(adjMatrix));
		
		

	}

}
