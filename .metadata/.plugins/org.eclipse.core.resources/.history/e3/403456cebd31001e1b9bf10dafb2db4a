package day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Assignment_day15_5 {
	
	public static int[] asteroidCollision(int [] asteroids) {

		 
		        
		        Stack<Integer> stack = new Stack<>();
		        
		        for(int asteroid : asteroids){
		            if(stack.isEmpty() || asteroid > 0)
		                stack.push(asteroid);
		            else{
		                while(true){ //keep doing this until break out, and continue to next asteroid
		                    if(stack.peek()<0){
		                        stack.push(asteroid);
		                        break;
		                    }                        
		                   else if(stack.peek() == -asteroid){
		                        stack.pop();
		                        break;
		                    }
		                    else if(stack.peek() > -asteroid){
		                        break;
		                    }
		                    else{
		                        stack.pop();
		                        if(stack.isEmpty()){ // in case [1,2,3] -4 -->  [] -4
		                            stack.push(asteroid); // and then should be [-4]
		                            break;
		                        }
		                           
		                        
		                    }
		                }
		                
		            }
		        }
		        
		        int [] arr = new int [stack.size()];
		        int j = 0;
		        for (int item : stack){
		            arr[j] = item;
		            j++;
		        }
		        return arr;
		      
		    }
		
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method 
		int [] asteroids = {-2,-1,1,2};
		int [] ans = asteroidCollision(asteroids);
		System.out.println(Arrays.toString(ans));
		
		

	}

}
