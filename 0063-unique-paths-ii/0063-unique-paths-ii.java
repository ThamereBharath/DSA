
class Solution {
    
    public int f(int[][] nums,int[][] dp,int i,int j){ 
        int m=nums.length;
        int n=nums[0].length;
        if(i==m-1&&j==n-1){ 
            if(nums[i][j]==0) return 1;
            return 0;
        }
        if(i==m||j==n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(nums[i][j]==1){dp[i][j]=0; return 0;}
        int x=f(nums,dp,i+1,j)+f(nums,dp,i,j+1);
        dp[i][j]=x;
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] nums) {
        int[][] dp=new int[nums.length][nums[0].length];
        for(int[] e:dp) Arrays.fill(e,-1);
        return f(nums,dp,0,0);
    }
}