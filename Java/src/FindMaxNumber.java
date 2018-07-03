import org.testng.annotations.Test;

public class FindMaxNumber extends FindSolution {

	
	public   void test()
	{
		System.out.println("Testing override");
	}
	
	@Test
	public  void test2()
	{
		test();
		int[] vals = { -50, 50, 5, 10, 7, 9, 100 };
		int max = 0;
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] > max) {
				max = vals[i];
			}
		}
		System.out.println(max);
	}

	@Test
	public  void test4() {
System.out.println("Testing abstarct override");		
	}


	int test3() {
		System.out.println("TESTING");
		// TODO Auto-generated method stub
		return 0;
		
	}
	
}
