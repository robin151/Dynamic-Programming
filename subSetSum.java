/* Subset Sum Problem Dynamic Programming*/

import java.io.*;
import java.util.*;

class subSetSum {

  public static void main(String[] args) 
  {
    Scanner inp = new Scanner(System.in);
   
    int n = inp.nextInt(); //length of array
    int[] a = new int[n];
    for(int i=0;i<n;i++)
    {
        a[i] = inp.nextInt();
    }
    int sum = inp.nextInt();    //sum to be checked
    subSetSum object1 = new subSetSum();
    
    int result = object1.findSubSetSum(a,sum,n);
    if(result == 1)
      System.out.println("True");
    else
      System.out.println("False");
  }
  
  /* function to find whether a subset result in the given sum or not*/
  public int findSubSetSum(int a[],int sum, int n)
  {
    int arr[][] = new int[n][sum+1];
    
    //fill the 0th column with 1. Since a sum of 0 can be formed with empty subset
    for(int i=0;i<n-1;i++)
    {
      arr[i][0] = 1;
    }
    //fill the 1st row. 
    for(int j=1;j<=sum;j++)
    {
		if(a[0]==j)
			arr[0][j] = 1;
		else
			arr[0][j] = 0;
    }
	
	for(int i=1;i<n;i++)
    {
      for(int j=1;j<=sum;j++)
      {
        if(a[i] > j)
          arr[i][j] = arr[i-1][j];
        else
        {
          if(arr[i-1][j] == 1)
            arr[i][j] = 1;
          else
            arr[i][j] = arr[i-1][j-a[i]];
        }
      }
    }
    return arr[n-1][sum];
    
  }

}