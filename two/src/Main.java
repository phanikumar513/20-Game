//20 game
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		Random r=new Random();
		int i,j,winner=0,max1=0,ti,tj,tii,tjj,tt=0,max=0;
		
		Winner w=new Winner();
		
		int [][]guide=new int[8][7];
		int [][]a={{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '},{' ',' ',' ',' ',' ',' ',' '}};
		System.out.println("Game Start");
		for(i=0;i<7;i++)
		{
			a[7][i]=r.nextInt(5)+1;
			System.out.print(a[7][i]);
		}
		
		LineIncreasing t=new LineIncreasing(a,guide,max1,max);
		t.w=w;
		t.start();
		
		while(w.getWinner()==0)
		{
			System.out.println("wm="+w.getWinner());
			print(a,guide,max1);
/**/			if(max1==1)
				w.setWinner(1);
	
				
			tt=0;
			while(tt==0 && w.getWinner()==0)
			{
				System.out.print("Enter 1st location:");
				ti=obj.nextInt();							//70
				tj=ti%10;									//0
				ti=ti/10;									//7
				//System.out.println("ti="+ti+"\t tj="+tj);
				
				System.out.print("Enter 2nd location:");
				tii=obj.nextInt();							//71
				tjj=tii%10;									//1
				tii=tii/10;									//7
				//System.out.println("tii="+tii+"\t tjj="+tjj);

				
				if(ti<8 && tj<7 && tii<8 && tjj<7)
				{
					if(a[ti][tj]==a[tii][tjj])
					{
						//System.out.println("phani1");
						if(a[ti][tj]<20 && a[tii][tjj]<20)
						{
							//System.out.println("phani2");
							if(isdirection(ti,tj,a) && isdirection(tii,tjj,a))
							{
								//System.out.println("phani3");
								tt=1;
								a[tii][tjj]=a[tii][tjj]+1;
								a[ti][tj]=' ';
							}
							else
							{
								tt=0;
								System.out.println("You have to enter correct location");
							}
						}
						else
						{
							tt=0;
							System.out.println("You have to enter correct location");
						}
					}
					else
					{
						tt=0;
						System.out.println("You have to enter correct location");
					}
				}
				else
				{
					tt=0;
					System.out.println("You have to enter correct location");
				}
				System.out.println("wm="+w.getWinner());
			}//while dir(tt=0)
			
			
				
		}//while is winner
	}//main
	
	
	public static void print(int[][]a,int[][]guide,int max1)
	{
		int i,j,k=0,max=0;
		int[] t=max(max,max1,a);
		max=t[0];
		max1=t[1];
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
		if(max1>0)
			System.out.println(max1);
		else
			System.out.println(max);
	}//method print
	
	
	public static int[] max(int max,int max1, int[][]a)
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
	
	
	public static boolean isdirection(int ti, int tj, int[][]a)
	{
		int s=0;
		//non,down,top,right,left
		//non
		if(ti!=0 && tj!=0 && ti!=7 && tj!=6)
		{
			s=0;
		}
		else if(ti==7 && tj<6 && tj>0)//71,72,73,74,75
		{
			s=1;
		}
		else if(ti==0 && tj<6 && tj>0)//01,02,03,04,05
		{
			s=2;
		}
		else if(tj==6 && ti<7 && ti>0)//16,26,36,46,56,66
		{
			s=3;
		}
		else if(tj==0 && ti<7 && ti>0)//10,20,30,40,50,60
		{
			s=4;
		}
		else if(ti==0 && tj==0)//00
		{
			s=5;
		}
		else if(ti==0 && tj==6)//06
		{
			s=6;
		}
		else if(ti==7 && tj==0)//70
		{
			s=7;
		}
		else if(ti==7 && tj==6)//76
		{
			s=8;
		}
			
		
		switch(s)											
		{
			case 0:
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
				
			case 1:
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
			case 2:
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
			case 3:
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
			case 4:
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
			case 5://00
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
			case 6://06
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
			case 7://70
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
			case 8://76
				if(switchi(ti,tj,a,s))
				{
					return true;
				}
				else
					return false;
				
				
				
				
		}//switch
		return false;	
		
	}//method isdirection
	
	
	public static boolean switchi(int ti, int tj,int [][]a,int s)//61
	{
		int k=0;
		if(s!=1 && s!=7 && s!=8 && k==0)//down i-71
		{
			if(emptyPlus(ti,tj,a))
				k++;
		}
		if(s!=2&& s!=5 && s!=6 && k==0)//top i-51
		{
			if(emptyMinus(ti,tj,a))
				k++;
		}
		if(s!=3 && s!=6 && s!=8 && k==0)//right i-62
		{
			if(emptyPlus(tj,ti,a))
				k++;
		}
		if(s!=4 && s!=5 && s!=7 && k==0)//left i-60
		{
			if(emptyMinus(tj,ti,a))
				k++;
		}
			
		
		
		if(k==1)
			return true;
		else
			return false;
	}//method switchi
	
	public static boolean emptyPlus(int ti, int tj,int [][]a)
	{
		ti++;
		if(a[ti][tj]==' ')
		{
			ti--;
			return true;
		}
		else
			return false;
	}//method emptyPlus
	
	public static boolean emptyMinus(int ti, int tj,int [][]a)
	{
		ti--;
		if(a[ti][tj]==' ')
		{
			ti++;
			return true;
		}
		else
			return false;
	}//method emptyMinus

}
