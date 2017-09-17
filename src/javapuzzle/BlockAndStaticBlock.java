package javapuzzle;

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
		new BlockAndStaticBlock();
		
	}

}
