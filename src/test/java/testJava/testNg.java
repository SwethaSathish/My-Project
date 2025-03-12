package testJava;



import org.testng.annotations.Test;

public class testNg {
	
	 public static void main( String[] args )
	    {
	        System.out.println( "Hello World!" );
	        testNg Obj = new testNg();
	        Obj.test2();
	        Obj.test3();
	        Obj.test1();
	    }

	@Test(description = "Test method1", priority = 1)
	public void test2() {
		System.out.println("This is test2");
	}
	
	@Test(priority = 2, alwaysRun = true)
	public void test1() {
		System.out.println("This is test1");
    }
	
	@Test(dependsOnMethods = {"test2", "test1"})
	public void test3() {
		System.out.println("This is test3");
	}
	
}