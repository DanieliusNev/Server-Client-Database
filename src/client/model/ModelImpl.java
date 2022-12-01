package client.model;

import client.network.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelImpl implements Model
{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Client client;
  public ModelImpl(Client client)
  {
    this.client = client;
    client.startClient();
    client.addListener("NewLogEntry", this::onNewLogEntry);
  }
  private void onNewLogEntry(PropertyChangeEvent evt) {
    support.firePropertyChange(evt);
  }

  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    client.save(title,year,size,condition,email,username,ratePerMinute,description);
  }

  @Override public String getDescription(int i)
  {
    return client.getDescription(i);
  }

  @Override public String getUsername(int i)
  {
    return client.getUsername(i);
  }

  @Override public String getEmail(int i)
  {
    return client.getEmail(i);
  }

  /*@Override public String getYear(int i)
  {
    return client.getYear(i);
  }*/

  /*@Override public String getSize(int i)
  {
    return client.getSize(i);
  }*/

  @Override public String getCondition(int i)
  {
    return client.getCondition(i);
  }

  /*@Override public String getRatePerMinute(int i)
  {
    return client.getUsername(i);
  }*/

  /*@Override public int getSizeOfVinylList()
  {
    return client.getSizeOfVinylList();
  }*/


  @Override
  public void addListener(String eventName, PropertyChangeListener listener) {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override
  public void removeListener(String eventName, PropertyChangeListener listener) {
    support.removePropertyChangeListener(eventName, listener);
  }
}
