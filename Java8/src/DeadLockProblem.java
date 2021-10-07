
public class DeadLockProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 final String s1="firstString";
         final String s2="second string";
		 Thread t1=new Thread(()->{
			System.out.println("t1 threadt startinh");
			synchronized(s1){
				System.out.println("s1 locked");
			 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			 
			 
			 synchronized(s2)
			 {
					System.out.println("s2 locked");
					 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
			 }
			}
		 });
		
	
		 Thread t2=new Thread(()->{
			System.out.println("t2 threadt startinh");
			synchronized(s2){
				System.out.println("s2 locked");
			 try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			 
			 
			 synchronized(s1)
			 {
					System.out.println("s1 locked");
					 try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
			 }
			}
		 });
	t1.start();
	t2.start();
	}

}
