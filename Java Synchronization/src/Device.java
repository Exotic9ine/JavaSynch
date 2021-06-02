
public class Device extends Thread {

	String name , type ;
	Router r1;
	public void copy (Router r1)
	{
		this.r1 = r1;
	}
	public Device (String n , String t)
	{
		name = n;
		type = t;
	}
	@Override
	public void run()
	{
		r1.Connect(this);
	
//		try {
//			//Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		r1.PerformOnline(this);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r1.LogOut(this);
	}
}