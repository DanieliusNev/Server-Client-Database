package client.network;

import shared.networking.ClientCallBack;
import shared.networking.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements Client, ClientCallBack
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
  }

  public void startClient() {
    try {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("UppercaseServer");
      //server.registerClient(this);
    } catch (RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }


  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);

  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }


  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    try
    {
      server.save(title, year, size,condition, email, username, ratePerMinute,description);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String getDescription(int i)
  {
    String result = "";
    try
    {
      result = server.getDescription(i);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }

  @Override public String getUsername(int i)
  {
    String result = "";
    try
    {
      result = server.getUsername(i);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }

  @Override public String getEmail(int i)
  {
    String result = "";
    try
    {
      result = server.getEmail(i);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }

  /*@Override public String getYear(int i)
  {
    return server.getYear(i);
  }*/

  /*@Override public String getSize(int i)
  {
    return server.getSize(i);
  }*/

  @Override public String getCondition(int i)
  {
    String result = "";
    try
    {
      result = server.getCondition(i);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }

  @Override public void createAccount(String username, String password,
      String email)
  {
    try
    {
      server.createAccount(username,password,email);
      System.out.println("RMICLIENT");
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  /*@Override public String getRatePerMinute(int i)
  {
    return server.getRatePerMinute(i);
  }*/

  /*@Override public int getSizeOfVinylList()
  {
    return server.getSizeOfVinylList();
  }*/

}
