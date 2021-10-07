
public class BankingClass {
	
	
	public volatile Integer amoutAvailable=new Integer(0);
	
	public synchronized void Deposite() throws InterruptedException
	{
		
		while(true)
		{
			Thread.sleep(5000);
			System.out.println(amoutAvailable+"amoutAvailable in deposite");
			if(amoutAvailable>1000)
			{
				System.out.println("waiting theard for withdarw");
				wait();
			}
			amoutAvailable=amoutAvailable+8000;
			System.out.println("performed deposite by "+Thread.currentThread().getName());
			System.out.println("after depositing amount is "+amoutAvailable);
			notify();
			
		}
	}
	
	
	public synchronized void withdrwa() throws InterruptedException
	{
		
		while(true)
		{
			Thread.sleep(5000);
			if(amoutAvailable<=1000)
				
			{
				System.out.println("waiting theard for deposite thread to run");
				wait();
			}
			amoutAvailable=amoutAvailable-1000;
			
			System.out.println("performed withdrwa by "+Thread.currentThread().getName());
			System.out.println("after withdrwa amount is amount is "+amoutAvailable);
			notify();
			
		}
	}

}
