
public class Recursion {
		public Recursion()
		{
			recur(5);
		}
		
		public void recur(int y)
		{
			if(y>0)
			{
				System.out.println(y);
				recur(y-1);
				System.out.println(y);
			}
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			System.out.println("Call the constructor");
			new Recursion();

		}

	}

