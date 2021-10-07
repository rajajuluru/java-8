import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadingClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankingClass class1=new BankingClass();
		Runnable deposite=()->{
			try {
				
				class1.Deposite();
				System.out.println(class1.amoutAvailable+"in deposite thread");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Runnable withdrewn=()->{
			try {
				
				class1.withdrwa();
				System.out.println(class1.amoutAvailable+"in withdrwan thread");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		newFixedThreadPool.execute(withdrewn);
		newFixedThreadPool.execute(deposite);
		//newFixedThreadPool.submit(task)
		
		

	}

}
