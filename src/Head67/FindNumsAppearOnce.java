package Head67;

public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int temp=0;
    	for(int x :array){
        	temp^=x;
        }
    	if(temp==0) return;
    	//根据异或结果第一位非0位把数组分为两部分异或
    	int index=0;
    	while((temp&1)==0){
    		temp = temp>>1;
    		index++;
    	}
    	
    	for(int x :array){
        	if((x>>index&1)==1) num1[0]^=x;
        	else num2[0]^= x;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = {2,-4,3,-6,3,2,5,5};
		int [] num1 = new int[1];
		int [] num2 = new int[1];
		new FindNumsAppearOnce().FindNumsAppearOnce(array, num1, num2);
		
		System.out.println(num1[0]+","+num2[0]);
		
		
	}

}
