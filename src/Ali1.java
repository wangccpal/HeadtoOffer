import java.util.Arrays;
import java.util.Scanner;

/*�������Ϣ�м���������Ա���è֧�����ȸ���ϵͳ����Ϣ��ת��������ȼ��ܹ��Ľ����ÿ���˫11�г����������ڵ���Ϣ����Ϣ�м������Pub/Sub������ɫ��Pub��������Ϣ����Ϣ�м������Ϣ�м���ٸ��ݶ��Ĺ�ϵͶ�ݸ����ķ��������û��ɹ�������һ����Ʒ������ƽ̨��Pub���ᷢ��һ��������ɣ�trade-done������Ϣ�����ﳵƽ̨��Sub�����ĵ������Ϣ�󣬻Ὣ�û��Ĺ��ﳵ��Ʒɾ�����������漰һ�����⣬����ƽ̨�ᷢ�͸������͵���Ϣ����Ϣ�м�������׼ȷ�Ľ���Ӧ����ϢͶ�ݸ����ﳵƽ̨�ģ���ʹ�õľ�����Ϣ�м���Ĺ��˹��ܣ����˵ķ�ʽ�кܶ��֣����ʽ�жϣ�����ƥ��ȡ�����������ʵ��һ�����˹��ܣ���ƥ�䶩�Ĺ�ϵ�Ƿ���ϣ���������������
��?�� ƥ��һ���ַ�
��*�� ƥ�������������ַ�
������������У����ﳵƽ̨���ķ�ʽ��pattern=*trade-done����ô
filter(100-trade-done, pattern) = 1,
filter(200-trade-done, pattern) = 1,
filter(200-paid-done, pattern) = 0
 
���pattern=200-?*-done :
filter(100-trade-done, pattern) = 0, 
filter(200-trade-done, pattern) = 1,
filter(200-paid-done, pattern) = 1
 
���pattern=1*trade*done :
filter(100-trade-done, pattern) = 1,
filter(200-trade-done, pattern) = 0,
filter(200-paid-done, pattern) = 0
*/
public class Ali1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = null , pattern = null ;
//		int i =2;
//		while(i-->0){
			 s = sc.nextLine();
			 pattern = sc.nextLine();
//		}
//		String pattern = "1*trade*done";
//		String s = "000-trade-done";
		System.out.println(filter(s,pattern));


		
	}
	public static int filter(String s, String pattern){
		String [] patternS= pattern.split("\\*");
		for(String ps :patternS) {
			String [] patternSS =  ps.split("\\?");
			for(String pps : patternSS){
				if(!s.contains(pps)) return 0;
			}
		}
		return 1;
	}

}
