package shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void save(String title, int year, int size, String condition,
    String email, String username, int ratePerMinute, String description) throws RemoteException;
}
