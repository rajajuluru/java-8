import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSampleCodes {
	  static String s;
public static void main(String [] args) throws InterruptedException, ExecutionException {
	// TODO Auto-generated method stub
	

	CompletableFuture<Void> completable=CompletableFuture.supplyAsync(()->{
		
		try {
			Thread.sleep(1);
			modifyString();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}).thenAcceptAsync((a)->{
		
		s=a.toUpperCase();
	});

     while(!completable.isDone())
     {
    	 System.out.println("not done");
     }
	System.out.println(s+"string");
}
public static void modifyString()
{
	s="String modifies";
}
}
