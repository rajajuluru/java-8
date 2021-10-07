import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesMainClass {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<CompletableFuture<String>> thenApply =
				getUserName().thenApply(s->getUserNameUppercase(s));
	
	System.out.println(	thenApply.get().get());
	
		CompletableFuture<String> thenCompose = getUserName().thenCompose(s1->getUserNameUppercase(s1));
	
		thenCompose.get();
	
	genericmethod("");
	String [] username = new String[]{"sa","as","saf","sdf"};
	genericmethod1(username);
	}
	
	
	public static <T> void genericmethod(T username)
	{
		System.out.println(username.getClass().getSimpleName());
	}
	
	
	public static  void genericmethod1(String ... username )
	{
		System.out.println(username.getClass().getSimpleName());
	}
	
	
	public static CompletableFuture<String> getUserName()
	{
		 CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()->{
			return "juluru";
		});
		 
		 return supplyAsync;
	}
	
	
	public static CompletableFuture<String> getUserNameUppercase(String uname)
	{
		 CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(()->{
			return uname.toUpperCase();
		});
		 
		 return supplyAsync;
	}
}
