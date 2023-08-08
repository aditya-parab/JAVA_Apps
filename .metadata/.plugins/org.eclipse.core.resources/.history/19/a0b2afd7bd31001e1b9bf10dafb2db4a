package com.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class stockSpan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Stack<Integer>stack  = new Stack<>();
        Stack<Integer> store = new Stack<>();
       ArrayList<Integer> arr = new ArrayList<>();
      int [] prices = {100, 80, 60, 70, 60,
    		   75, 85};
      int ans=1;
      ArrayList<Integer> anss = new ArrayList<Integer>();
      for(int price:prices) {
    	  ans= 1;
      
       if(stack.isEmpty() || stack.peek()>price){
           while(!store.isEmpty()){
               stack.push(store.pop());
           }
           stack.push(price);
       }
       else{

          
           while( stack.peek()<=price){
             
               store.push(stack.pop());
                if(stack.isEmpty()){break;}
               
               
           }
           ans+=store.size();
           
           
           while(!store.isEmpty()){
               stack.push(store.pop());
           }
           stack.push(price);
           
           // System.out.println(store.isEmpty());
       }
       anss.add(ans);
       }
     
  System.out.println(anss.toString());
	}

}
