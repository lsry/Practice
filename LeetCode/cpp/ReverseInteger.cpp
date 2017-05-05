#include<iostream>
using std::cin;
using std::cout;
using std::endl;

/*
* int x the number of inputing
* using '/' get the number divided by 10
* using '%' get the number divided by 10 of remaining
* overflow: if a number (such as n*10/10 != n) , the number is overflow
*/
int reverse(int x) 
{
  int j=0;
  int x2=0;
  while(x!=0)
  {
    j=x%10;
    if((x2*10/10)!=x2)
	  return 0;
    x2 = x2*10+j;
    x /= 10;
  }
  return x2;
}

int main() 
{
	int i=0;
	cin>>i;
    cout<<reverse(i)<<endl;
	return 0;
}