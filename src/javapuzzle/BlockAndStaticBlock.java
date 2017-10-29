package javapuzzle;
/**
 * 注意，这个例子说明了，静态变量和静态方法，谁写在前面谁先执行
 * @author CC
 *
 */
public class BlockAndStaticBlock {
	static
	{
		System.out.println("BLOCK_B");
	}
	
	{
		System.out.println("BLOCK_A");
	}
	public static BlockAndStaticBlock test = new BlockAndStaticBlock();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BlockAndStaticBlock();
	}

}
