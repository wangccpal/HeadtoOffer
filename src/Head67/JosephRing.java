package Head67;

import java.util.LinkedList;
/**
 * 链接：https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
来源：牛客网

约瑟夫问题是一个非常著名的趣题，即由n个人坐成一圈，按顺时针由1开始给他们编号。然后由第一个人开始报数，数到m的人出局。现在需要求的是最后一个出局的人的编号。
给定两个int n和m，代表游戏的人数。请返回最后一个出局的人的编号。保证n和m小于等于1000。
 * @author CC
 *
 */
public class JosephRing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
	}
			    public int getResult(int n, int m) {
			        // write code here
			        LinkedList<Integer> list = new LinkedList<Integer>();
			        for (int i = 1; i <= n; i ++) {
			            list.add(i);
			        }
			        int bt = 0;
			        while (list.size() > 1) {
			            int delPos = (bt + m - 1) % list.size();
			            list.remove(delPos);
			            bt = delPos % list.size();
			        }
			        return list.get(0);
			    }
			    
			    //数学优化
/**
 * 把n个人的编号改为0~n-1，然后对删除的过程进行分析。
第一个删除的数字是(m-1)%n，几位k，则剩余的编号为(0,1,...,k-1,k+1,...,n-1)，下次开始删除时，顺序为(k+1,...,n-1,0,1,...k-1)。
用f(n,m)表示从(0~n-1)开始删除后的最终结果。
用q(n-1,m)表示从(k+1,...,n-1,0,1,...k-1)开始删除后的最终结果。
则f(n,m)=q(n-1,m)。

下面把(k+1,...,n-1,0,1,...k-1)转换为(0~n-2)的形式，即
k+1对应0
k+2对于1
...
k-1对应n-2
转化函数设为p(x)=(x-k-1)%n, p(x)的你函数为p^(x)=(x+k+1)%n。
则f(n,m)=q(n-1,m)=p^(f(n-1,m))=(f(n-1,m)+k+1)%n，又因为k=(m-1)%n。
f(n,m)=(f(n-1,m)+m)%n;

最终的递推关系式为
f(1,m) = 0;                        (n=1)
f(n,m)=(f(n-1,m)+m)%n; （n>1）

代码如下
 * @param n
 * @param m
 * @return
 */
			    	    public int getResult1(int n, int m) {
			    	        if (n < 0 || m < 0) {
			    	            return -1;
			    	        }
			    	        int last = 0;
			    	        for(int i=2;i<=n;++i){
			    	            last = (last+m)%i;
			    	        }
			    	        // 因为实际编号为(1~n)
			    	        return (last+1);
			    	    }
}
