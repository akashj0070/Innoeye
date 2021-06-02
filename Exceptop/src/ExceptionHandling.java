public class ExceptionHandling {
	public static void main(String[] args) {
		try {
			throw new MyException();
		}
		catch(Exception e)
		{
			System.out.println("Cant divide be zero");
		}
	}
}

class MyException extends Exception
{
	int a=5;
	int b=0;
	int c;
	public MyException() {
		c=a/b;
	}
	
}