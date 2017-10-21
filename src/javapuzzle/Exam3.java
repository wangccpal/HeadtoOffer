package javapuzzle;

public class Exam3 {
	int x  = 5;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Exam3 f1= new Exam3();
		Exam3 f2 = new Exam3();
		Exam3 f3 = ExamSw(f1,f2);
		System.out.println((f1==f3) +""+ (f1.x==f3.x));
	}
	private static Exam3 ExamSw(Exam3 f1, Exam3 f2) {
		final Exam3 z = f1;
		z.x=6;
		return z;
	}

}
