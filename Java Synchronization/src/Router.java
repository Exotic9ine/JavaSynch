import java.util.Vector;
public class Router {
    private int MaxNum ;
    Vector <Device> ConnectedDevice = new Vector<Device>(MaxNum);
    Semaphore checkSemaphore = new Semaphore();
    public Router ()
    {
        MaxNum = 0;
        checkSemaphore.setValue(MaxNum);
    }
    public Router (int num)
    {
        MaxNum = num;
        checkSemaphore.setValue(MaxNum);

    }

    public void Connect (Device d1)
    {

    	checkSemaphore.Connect(d1);
        ConnectedDevice.add(d1);
        System.out.println(d1.name+" Occupied");

    }
    public void PerformOnline(Device d1)
    {
            System.out.println(d1.name+" performing online activity");
    }
    public void LogOut(Device d1)
    {

    	checkSemaphore.Disconnect(d1);
        for(int i=0 ; i<ConnectedDevice.size() ; i++)
        {
            if(d1.name.equals(ConnectedDevice.get(i).name) )
            {
                ConnectedDevice.remove(i);
            }
        }
    }

}