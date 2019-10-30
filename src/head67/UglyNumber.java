package head67;

public class UglyNumber {
    public static int GetUglyNumber_Solution(int index) {
    	if(index<=1) return 1;
    	int r2=0,r3=0,r5=0;
    	int [] res = new int[index];
    	res[0]=1;
    	for(int i=1;i<index;i++){
//    		r2 = 2;
//    		r3 = 3;
//    		r5 = 5;
    		res[i] = Math.min(res[r2]*2, Math.min(res[r3]*3, res[r5]*5));
    		if(res[i]==res[r2]*2) r2++ ;//ע�����ﲻ����else if���������ֶ����ͬ�ĳ���
    		 if(res[i]==res[r3]*3) r3++;
    		 if(res[i]==res[r5]*5) r5 ++;
    	}
    	return res[index-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GetUglyNumber_Solution(7));
	}

}
