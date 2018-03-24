import java.util.*;

public class knapsack{

	public static int knapSack1(int wt[], int val[], int n, int W)
	{
		// Base Case
		if (n == 0 || W == 0)
			return 0;
		
		int arr[][] = new int[n][W+1];
		//fill the first column with 0
		for(int i=0;i<n;i++)
		{
			arr[i][0] = 0;
		}
		//fill the 1st row respective value
		for(int j=1;j<=W;j++)
		{
			if(wt[0] > j)
			{
				arr[0][j] = 0;
			}
			else
				arr[0][j] = val[0];
		}
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=W;j++)
			{
				if(wt[i] > j)
					arr[i][j] = arr[i-1][j];
				else
				{
					arr[i][j] = max(arr[i-1][j],val[i]+arr[i-1][j-wt[i]]);
				}
			}
		}
		System.out.println(arr[n-1][W]);
		return arr[n-1][W];
    }
		
	public static int max(int a, int b)
	{
	    if(a > b)
	        return a;
	    return b;
	}
	
	public static void main(String[] args)
	{
		int wt[] = {10,20,30};
		int val[] = {60, 100, 120};
		int totalWeight = 50;
		int n = wt.length;
		int result = knapSack1(wt,val,n,totalWeight);
		return ;	
	}
}