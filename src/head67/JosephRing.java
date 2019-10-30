package head67;

import java.util.LinkedList;
/**
 * ���ӣ�https://www.nowcoder.com/questionTerminal/11b018d042444d4d9ca4914c7b84a968
��Դ��ţ����

Լɪ��������һ���ǳ�������Ȥ�⣬����n��������һȦ����˳ʱ����1��ʼ�����Ǳ�š�Ȼ���ɵ�һ���˿�ʼ����������m���˳��֡�������Ҫ��������һ�����ֵ��˵ı�š�
��������int n��m��������Ϸ���������뷵�����һ�����ֵ��˵ı�š���֤n��mС�ڵ���1000��
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
			    
			    //��ѧ�Ż�
/**
 * ��n���˵ı�Ÿ�Ϊ0~n-1��Ȼ���ɾ���Ĺ��̽��з�����
��һ��ɾ����������(m-1)%n����λk����ʣ��ı��Ϊ(0,1,...,k-1,k+1,...,n-1)���´ο�ʼɾ��ʱ��˳��Ϊ(k+1,...,n-1,0,1,...k-1)��
��f(n,m)��ʾ��(0~n-1)��ʼɾ��������ս����
��q(n-1,m)��ʾ��(k+1,...,n-1,0,1,...k-1)��ʼɾ��������ս����
��f(n,m)=q(n-1,m)��

�����(k+1,...,n-1,0,1,...k-1)ת��Ϊ(0~n-2)����ʽ����
k+1��Ӧ0
k+2����1
...
k-1��Ӧn-2
ת��������Ϊp(x)=(x-k-1)%n, p(x)���㺯��Ϊp^(x)=(x+k+1)%n��
��f(n,m)=q(n-1,m)=p^(f(n-1,m))=(f(n-1,m)+k+1)%n������Ϊk=(m-1)%n��
f(n,m)=(f(n-1,m)+m)%n;

���յĵ��ƹ�ϵʽΪ
f(1,m) = 0;                        (n=1)
f(n,m)=(f(n-1,m)+m)%n; ��n>1��

��������
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
			    	        // ��Ϊʵ�ʱ��Ϊ(1~n)
			    	        return (last+1);
			    	    }
}
