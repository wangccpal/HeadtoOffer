package javapuzzle;
/**
 * 注意静态变量的初始化在静态块的前面
 * 即一个类的加载+创建对象的顺序是  静态变量-》静态块-》构造函数-》构造快
 * @author CC
 *
 */
public class BlockAndStaticBlock {
	public static BlockAndStaticBlock test = new BlockAndStaticBlock();
	{
		System.out.println("BLOCK_A");
	}
	static
	{
		System.out.println("BLOCK_B");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BlockAndStaticBlock();
		
	}

}
