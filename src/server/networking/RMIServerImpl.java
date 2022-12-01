package server.networking;

import server.model.Model;
import shared.networking.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements RMIServer
{
  private Model model;

  public RMIServerImpl(Model model) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.model = model;
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("UppercaseServer", this);
  }


  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
      throws RemoteException
  {
      model.save(title, year, size, condition, email, username, ratePerMinute, description);
  }

  @Override public String getDescription(int i) throws RemoteException
  {
    return model.getDescription(i);
  }

  @Override public String getUsername(int i) throws RemoteException
  {
    return model.getUsername(i);
  }

  @Override public String getEmail(int i) throws RemoteException
  {
    return model.getEmail(i);
  }

  /*@Override public String getYear(int i)
  {
    return model.getYear(i);
  }

 *//* @Override public String getSize(int i)
  {
    return model.getSize(i);
  }*/

  @Override public String getCondition(int i) throws RemoteException
  {
    return model.getCondition(i);
  }

  @Override public void createAccount(String username, String password,
      String email) throws RemoteException
  {
    model.createAccount(username,password,email);
    System.out.println("SERVER");
  }

  /*@Override public String getRatePerMinute(int i)
  {
    return model.getRatePerMinute(i);
  }
*/
  /*@Override public int getSizeOfVinylList()
  {
    return model.getSizeOfVinylList();
  }*/

}
