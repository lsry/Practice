#include<iostream>
using std::cin;
using std::cout;
using std::endl;

#include<vector>
using std::vector;

/*
* vector<int>& nums : the arrays of Inputting
* int target: the sum of two numbers
*/
vector<int> twoSum(vector<int>& nums, int target) {
  vector<int> ive={0,0};
  int n=nums.size();
  for(int i = 0;i<n;i++)
  {
     for(int j=i+1;j<n;j++)
     {
        int temp = nums[i]+nums[j];
        if(temp==target)
        {
           ive[0]=i;
           ive[1]=j;
           return ive;
         }
      }
  }       
  return ive;
}

int main()
{
    
	return 0;
}