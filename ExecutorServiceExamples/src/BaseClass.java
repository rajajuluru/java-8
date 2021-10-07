import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BaseClass {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		// TODO Auto-generated method stub
		
		
		Runnable runnable=()->{
			
			System.out.println(Runtime.getRuntime().availableProcessors());
			System.out.println("threade running  thread name is"+Thread.currentThread().getName());
		};

		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);
		newFixedThreadPool.execute(runnable);
		
		
		Callable<String> cal=()->{
			
			Thread.sleep(3000);
		
			return "callable";
		};
		Future<String> submit = newFixedThreadPool.submit(cal);
		 long starting = System.currentTimeMillis();
		 long end=System.currentTimeMillis();
	try
	{
		 while(!submit.isCancelled() && submit.isDone())
		 {
			 end=System.currentTimeMillis();
			 Integer diff=(int) (end-starting);
			 System.out.println("diff"+diff);
			 if(diff>4){
			
				 submit.cancel(true);
				 System.out.println("cancelled by true");
				 
			 }
		 }
	}catch(Exception e){
		
		e.printStackTrace();
	
	}
		
	System.out.println(submit.isCancelled()+"is cancelled");
  System.out.println(submit.get()+"result frm callable is");
	
	
	System.out.println("after feching result");
		
//		while(submit.isDone())
//		{
//			
//		}
		
		//newFixedThreadPool.shutdown();
	   
		
		
	}

}
