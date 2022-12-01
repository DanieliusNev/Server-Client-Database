package server.model;

import server.domain.VinylList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

public class ModelImpl implements Model
{
  private PropertyChangeSupport support;
  private VinylPersistance vinylPersistance;
  private VinylList list;

  public ModelImpl()
  {
    support = new PropertyChangeSupport(this);
    try
    {
      this.vinylPersistance = new VinylDatabase();
      this.list = vinylPersistance.load();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }

  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    vinylPersistance.save(title, year, size, condition, email, username, ratePerMinute,description);
  }

  @Override public int getSizeOfVinylList()
  {
    return list.getSizeOfVinylList();
  }

  @Override public String getDescription(int i)
  {
    return list.getDescription(i);
  }

  @Override public String getUsername(int i)
  {
    return list.getUsername(i);
  }

  @Override public String getEmail(int i)
  {
    return list.getEmail(i);
  }

  /*@Override public String getYear(int i)
  {
    return list.getYear(i);
  }*/

  /*@Override public String getSize(int i)
  {
    return list.getSize(i);
  }*/

  @Override public String getCondition(int i)
  {
    return list.getCondition(i);
  }

  @Override public void createAccount(String username, String password,
      String email)
  {
    vinylPersistance.createAccount(username,password,email);
  }

  /*@Override public String getRatePerMinute(int i)
  {
    return list.getRatePerMinute(i);
  }*/

}
