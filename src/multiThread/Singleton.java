package multiThread;

public class Singleton {
	
	public static Singleton getInstance(){
		return Holder.instance;
	}
	
	static class Holder{
	
		private static Singleton instance =new Singleton();
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
