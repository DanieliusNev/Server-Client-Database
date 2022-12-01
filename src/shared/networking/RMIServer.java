package shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void save(String title, int year, int size, String condition,
    String email, String username, int ratePerMinute, String description) throws RemoteException;

  String getDescription(int i) throws RemoteException;

  String getUsername(int i) throws RemoteException;

  String getEmail(int i) throws RemoteException;

  //String getYear(int i);

  //String getSize(int i);

  String getCondition(int i) throws RemoteException;

  //String getRatePerMinute(int i);

  //int getSizeOfVinylList();

  void createAccount(String username, String password,
      String email) throws RemoteException;
}
