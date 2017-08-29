package newCoder;

public class Threadt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		waitForSignal();
	}
	static void waitForSignal()
	{
	    Object obj = new Object();
	    synchronized(obj)
	    {
	        try {
	        	System.out.println("begin wait");
				obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("begin notify");

	        obj.notify();
	    }
	}
}
