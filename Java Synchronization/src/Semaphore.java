public class Semaphore {
	protected int numberOfArived = 0;

	public Semaphore()
	{
		numberOfArived = 0;
	}
	public Semaphore(int intial)
	{
		numberOfArived = intial;
	}
	public void setValue(int n)
	{
		numberOfArived = n;
	}

	public synchronized void Connect (Device d1)
	{
		numberOfArived-- ;
		if (numberOfArived < 0)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(d1.name+ " " +"("+d1.type+")" +" " + "arrived and wait");
		}
		
        System.out.println("("+d1.name+")" + " " +"("+d1.type+")"+" " + "arrived");

	}
	public synchronized void Disconnect(Device d1) {
		numberOfArived++ ; 
		System.out.println(d1.name+ " " +"("+d1.type+")" +" " + "Logout");
		if (numberOfArived <= 0) notify() ;
	}

}