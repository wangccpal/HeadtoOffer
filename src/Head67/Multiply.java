package Head67;

public class Multiply {
	    public int[] multiply(int[] A) {
	        int n = A.length;
	        
			int temp1 = 1;
	        int temp2 = A[A.length-1];
	        int[] B = new int[n] ;
	        if(n==1) return B;
	        for(int i=1;i<n;n++){
	            temp1*=A[i-1];
	            B[i] = temp1;
	        }
	        for(int j=n-2;j>=0;j--){
	            B[j]*=temp2;
	            temp2*=A[j];
	        }
	        return B;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3};
		System.out.println(new Multiply().multiply(A));
		
	}

}
