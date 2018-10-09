////////////////////////////////////////
import java.util.*;
public class LineIncreasing extends Thread{

	Random r=new Random();
	int [][]a;
	int [][]guide;
	int max;
	int max1;
	Winner w=new Winner();
	
	
	LineIncreasing(int [][]a,int [][]guide,int max1,int max)
	{
		this.a=a;
		this.guide=guide;
		this.max1=max1;
		this.max=max;
	}
	
	public void print(int[][]a,int[][]guide,int max1,int max)
	{
		int i,j,k=0;
		int[] t=max(max,max1,a);
		w.setMax(t[0]);
		w.setMax1(t[1]);
		System.out.println();	System.out.println();	System.out.println();
		
		System.out.println(" 0  1  2  3  4  5  6");
		System.out.println("|--------------------|");
		for(i=0;i<8;i++)
		{
			System.out.print("|");
			for(j=0;j<7;j++)
			{
				if(a[i][j]==32)
					System.out.print("  |");
				else
				{
					if(a[i][j]<10)
					{
						System.out.print("0");
					}
					System.out.print(a[i][j]+"|");
				}
			}
			System.out.print(i);
			
			System.out.println();
			if(i!=a.length-1)
			System.out.println("|--|--|--|--|--|--|--|");
		}
		System.out.println("|--------------------|");
		
		
		System.out.print("Score=");
		if(w.getMax1()>0)
			System.out.println(w.getMax1());
		else
			System.out.println(w.getMax());
	}//method print
	
	
	public int[] max(int max,int max1, int[][]a)
	{
		int i,j;
		int[]t=new int[2];
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a[i].length;j++)
			{
				if(a[i][j]!=32 && max<a[i][j])
				{
					if(a[i][j]==7)
					{
						max1++;
						a[i][j]=' ';
					}
					else
						max=a[i][j];
				}
			}
		}
		t[0]=max;
		t[1]=max1;
		return t;
	}
	
	
	public  boolean check(int [][]a)
	{
		int k=0;
		for(int j=0;j<7;j++)
		{
			
			if(a[0][j]==' ')
			{
				k++;
			}
		}
		
		if(k==7)
			return true;
		else
			return false;
	}//check
	
	public int max(int[][]a)
	{
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
			{
				if(a[i][j]>max && a[i][j]!=' ')
				{
					max=a[i][j];
				}
			}
		}
		return max;
	}
	
	
	
	public void run()
	{
		while(w.getWinner()==0)
		{
			System.out.println("w="+w.getWinner());
			try
			{
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				
			}
			
			if(check(a))
			{
				for(int i=0;i<a.length-1;i++)
				{
					for(int j=0;j<a[i].length;j++)
					{
						a[i][j]=a[i+1][j];
					}
				}
				max=max(a);
				for(int i=0;i<7;i++)
				{
					a[7][i]=r.nextInt(max)+1;
				}
				print(a,guide,max1,max);
			}
			else
			{
				System.out.println("you loss the game!!");
				w.setWinner(1);
				break;
			}
			if(max1==1)
				w.setWinner(1);
			
			
		}//run-while
		System.out.println("w="+w.getWinner());
	}//run
	
}
