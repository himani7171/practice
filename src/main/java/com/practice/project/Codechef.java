package com.practice.project;

/* package codechef; // don't place package name! */



/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		java.io.BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		String s;int count=0;
		int no = 0;
		String string = s=r.readLine();
		if(!(s.isEmpty() )){
			no =  Integer.parseInt(s);
		}
		s=r.readLine();
		int[][] ar = new int[no][9];
		while (count <no){
			
			for(int i =0; i< 3; i++){
				s=r.readLine();
				String[] split = s.split("( )+");
				ar[count][i*3+0]= Integer.parseInt(split[0]);
				ar[count][i*3+1]= Integer.parseInt(split[1]);
				ar[count][i*3+2]= Integer.parseInt(split[2]);
				
				
			}
			count +=1;
			s=r.readLine();
			System.out.println(s);
		}
		
	}
}
