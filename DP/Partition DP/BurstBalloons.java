class BurstBalloons
{
    public static void main(String[] args)
    {

    }
    //Function signature in portal leetcode/codingNinja
    public static int maxProfit(int[] a)
    {
        // Write your code here..
        int n = a.length;
        //DP Solution
        int[] padArray = new int[n+2];
        for(int i=0; i<n; i++)
        {
            padArray[i+1] = a[i];
        }
        padArray[0] = 1;
        padArray[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        for(int i=n; i>=1; i--)
        {
            for(int j=1; j<=n; j++)
            {
                if(i>j)
                {
                    continue;
                }
                int ans = 0;
                for(int k=i; k<=j; k++)
                {
                    int coins = dp[i][k-1] + (padArray[i-1]*padArray[k]*padArray[j+1]) + dp[k+1][j];
                    ans = Math.max(ans, coins);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n];
        //Recursive Solution
        // int[] padArray = new int[n+2];
        // for(int i=0; i<n; i++)
        // {
        //     padArray[i+1] = a[i];
        // }
        // padArray[0] = 1;
        // padArray[n+1] = 1;
        // Integer[][] dp = new Integer[n+1][n+1];
        // return solve(padArray, 1, n, dp);
    }
    

    //Recursive DP
    public static int solve(int[] a, int i, int j, Integer[][] dp)
    {
        if(i > j)
        {
            return 0;
        }
        if(dp[i][j] != null)
        {
            return dp[i][j];
        }
        int ans = 0;
        for(int k=i; k<=j; k++)
        {
            int coins = solve(a, i, k-1, dp) + (a[i-1]*a[k]*a[j+1]) + solve(a, k+1, j, dp);
            ans = Math.max(ans, coins);
        }
        return dp[i][j] = ans;
    }
}