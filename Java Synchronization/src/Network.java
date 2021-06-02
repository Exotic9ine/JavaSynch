import java.util.ArrayList;
import java.util.Scanner;
public class Network {
    public static void main(String[] args) {
        // TODO code application logic here
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("What is number of WI-FI Connections?");
    	int conn = scanner.nextInt();
        Router r1 = new Router(conn);
        System.out.println("What is number of devices Clients want to connect?");
        int connDev = scanner.nextInt();
        
//        C1 mobile 
//        C2 tablet
//        C3 pc
//        C4 pc

        ArrayList<Device> AllDevice = new ArrayList<Device>(conn);
        String DeviceName,DeviceType;
        
        for (int i = 0; i < connDev; i++) {
			DeviceName=scanner.next();
			DeviceType=scanner.next();
			AllDevice.add(new Device(DeviceName,DeviceType));
		}
        for (int i = 0; i < connDev; i++) {
        	AllDevice.get(i).copy(r1);
			AllDevice.get(i).start();
		}
    }

}