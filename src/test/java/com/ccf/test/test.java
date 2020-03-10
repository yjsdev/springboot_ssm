package com.ccf.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
//		int[] nums = {2, 7,11,9}; 
//		int[] res = twoSum(nums, 9);
//		System.out.println(Arrays.toString(res)
		
		System.out.println(robot("URR",new int[][]{},3,2));
	}
	 public static int[] twoSum(int[] nums, int target) {
	        int[] result =new int[0];
	        
	        for(int i=0; i<nums.length; i++){
	                    
	            int flag = nums[i];
	            if(i>=nums.length-1){
	                return result;
	            }
	            
	            for(int j=i+1; j<nums.length;j++){
	                flag+= nums[j];
	                if(flag==target){
	                    result = new int[2];
	                    result[0]=i;
	                    result[1]=j;
	                    return result;
	                }
	            }
	            
	        }
	        return result;
	 }
	 

    public void reverseString(char[] s) {
        char[] t = new char[s.length];
        int i = 0;
        for(char e:s){
            i++;
            t[t.length-i]=e;
        }
        s = t;
    }
    
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
    	
    	if(command.length()<2||command.length()>1000){
            return false;
        }
        Map<String, int[]> obstacleMap = new HashMap<String, int[]>();
        for(int i = 0; i < obstacles.length; i++){
            obstacleMap.put(i+"",obstacles[i]);
        }

        char[] commands = command.toCharArray();
        int xN = 0, yN = 0;
        for(int i = 0; i < commands.length; i++){
            if("U".equals(String.valueOf(commands[i]))){
            	xN+=1;
            }
            if("R".equals(String.valueOf(commands[i]))){
            	yN+=1;
            }
            if(isRule(xN,yN,obstacleMap)){
                return false;
            }
            if(x == xN && y == yN){
                return true;
            }
            if(x < xN || y < yN){
                return false;
            }
        }
        return robot(new int[]{xN,yN}, command, obstacles, x, y);
    }

    public static boolean robot(int[] target, String command, int[][] obstacles, int x, int y) {
    	
    	if(command.length()<2||command.length()>1000){
            return false;
        }
        Map<String, int[]> obstacleMap = new HashMap<String, int[]>();
        for(int i = 0; i < obstacles.length; i++){
            obstacleMap.put(i+"",obstacles[i]);
        }

        char[] commands = command.toCharArray();
        int xN = target[0], yN = target[1];
        for(int i = 0; i < commands.length; i++){
            if("U".equals(String.valueOf(commands[i]))){
            	xN+=1;
            }
            if("R".equals(String.valueOf(commands[i]))){
            	yN+=1;
            }
            if(isRule(xN,yN,obstacleMap)){
                return false;
            }
            if(x == xN && y == yN){
                return true;
            }
            if(x < xN || y < yN){
                return false;
            }
        }
        return robot(new int[]{xN,yN}, command, obstacles, x, y);
    }
    private static boolean isRule(int x, int y, Map<String, int[]> obstacleMap){
        for(Map.Entry<String, int[]> entry : obstacleMap.entrySet()){
            if(x==entry.getValue()[0]&&y==entry.getValue()[1]){
                return true;
            };
        }
        return false;
    }
	
}
