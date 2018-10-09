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
		int i,j;
		System.out.println();	System.out.println();	System.out.println();
		
		System.out.println("|--------------------|\t|--------------------|");
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
					if(a[i][j]>this.max) {
						this.max=a[i][j];
					}
					if(this.max==20)
					{
						this.max=0;	max1++;
					}
					System.out.print(a[i][j]+"|");
				}
			}
			System.out.print("\t|");
			for(j=0;j<7;j++)
			{			
				System.out.print(i);
				System.out.print(j+"|");
			}
			System.out.println();
			if(i!=a.length-1)
			System.out.println("|--|--|--|--|--|--|--|\t|--|--|--|--|--|--|--|");
		}
		System.out.println("|--------------------|\t|--------------------|");
		System.out.print("Score=");
		if(max1>0)
			System.out.println(max1);
		else
			System.out.println(this.max);
	}//method print
	
	
	public static boolean check(int [][]a)
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
			try
			{
				Thread.sleep(20000);
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
			
			
		}//run-while
	}//run
	
}
