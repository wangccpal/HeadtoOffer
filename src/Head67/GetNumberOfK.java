package Head67;

public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int firstk = getFirstk(array,0,array.length-1,k);
        System.out.println(firstk);
        int lastk = getLastk(array,0,array.length-1,k);
        System.out.println(lastk);

          if(firstk==-1) return 0;
         else return lastk-firstk+1;
         
     }
     public int getFirstk(int[] array ,int lo ,int hi,int k){
         if(lo>hi) return -1;
         int mid = lo+(hi-lo)/2;
         if(k>array[mid]) return getFirstk(array,mid+1,hi, k);
         else if(k<array[mid]) return getFirstk(array,lo,mid-1,k);
         else {
             if(mid-1>=0&&array[mid-1]==k) return getFirstk(array,lo,mid-1,k);
             else return mid;
         }
     }
         public int getLastk(int[] array ,int lo ,int hi,int k){
         if(lo>hi) return -1;
             while(lo<=hi){
                 int mid = lo+(hi-lo)/2;
                 if(k>array[mid]) lo=mid+1;
                 else if(k<array[mid]) hi=mid-1;
                 else {
                     if(mid+1<array.length&&array[mid+1]==k)  lo=mid+1;
                     else return mid;
                 }
             }
         return -1;
     }
         public static void main(String[] args){
        	 int [] nums = {1,2,3,3,3,3,4,5};
        	 System.out.println(new GetNumberOfK().GetNumberOfK(nums,3));
         }
}
