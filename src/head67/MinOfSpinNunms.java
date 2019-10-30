package head67;

public class MinOfSpinNunms {
    public static int minNumberInRotateArray(int [] array) {
    	
    	int lo = 0;
        int hi = array.length-1;
        int mid = 0;
        if(array[0]<array[hi]) return array[0];
        while(lo<=hi){
             mid = lo+(hi-lo)/2;
             //�������ѵ�����Ҫ������β���Ƚ϶����Ǻ�ͷ���Ƚϡ�����{2��1}�����ͷ���Ƚϣ�mid��lo����2�����˱Ƚϣ�
             //�����β���Ƚϣ�mid=2��hi=1����ȷ��
             //���ⲻҪ����mid<β��ʱ �����ų�mid����С�����
            if(array[mid]>array[hi]) lo = mid + 1;
            else if(array[mid]<array[hi]) hi = mid;
            else hi--;
        }
        return array[mid];//return lo Ҳ��
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {3,4,5,1,2};
		int[] array1 = {1,0,1,1,1};
		System.out.println(minNumberInRotateArray(array));
		System.out.println(minNumberInRotateArray(array1));
		
	}

}
