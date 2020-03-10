package com.ccf.test;


public class test2 {
	
	public static void main(String[] args) {
		System.out.println(getMin(new int[][]{{1,2,3},{1,1,1}},2,3));
	}
	
	public static int getMin(int[][] map, int n, int m) { 
   	 
       int[][] dp = new int[n][m];  
        for(int i=0;i<n;i++){  
            for(int j=0;j<=i;j++){  
             dp[i][0]+=map[j][0];      
            }  
        }  
        for(int i=0;i<m;i++){  
            for(int j=0;j<=i;j++){  
             dp[0][i]+=map[0][j];      
            }  
        }  
        for(int i=1;i<n;i++){  
            for(int j=1;j<m;j++){  
             dp[i][j] = min(dp[i][j-1]+map[i][j],dp[i-1][j]+map[i][j]);     
            }  
        }  
        return dp[n-1][m-1];  
    }  
    public static int min(int a,int b){  
    	String s ="";
        if(a>b){  
         return b;     
        }else{  
         return a;     
        }  
	} 
	
}
