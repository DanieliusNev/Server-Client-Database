package server.domain;

import shared.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class VinylList implements Subject
{
  private List<Vinyl> vinyls;
  private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

  public VinylList() {
    vinyls = new ArrayList<>();
    pcs.addPropertyChangeListener(evt -> {
      System.out.printf("NEW EVENT: %s, %s\n", evt.getPropertyName(), evt.getNewValue());
    });
  }

  public void addVinyl(Vinyl vinyl)
  {
    vinyls.add(vinyl);
  }
  public int getSizeOfVinylList()
  {
    return vinyls.size();
  }
  public String getDescription(int i)
  {
    return vinyls.get(i).getDescription();
  }
  public String getUsername(int i)
  {
    return vinyls.get(i).getUsername();
  }
  public String getEmail(int i)
  {
    return vinyls.get(i).getEmail();
  }
  public String getYear(int i)
  {
    return vinyls.get(i).getYear();
  }
  public String getSize(int i)
  {
    return vinyls.get(i).getSize();
  }
  public String getCondition(int i)
  {
    return vinyls.get(i).getCondition();
  }
  public String getRatePerMinute(int i)
  {
    return vinyls.get(i).getRatePerMinute();
  }
  //lol do for title


  /*@Override
  public List<Vinyl> getAll() {
    return this.vinyls;
  }

  @Override
  public Vinyl removeVinyl(String name) {
    return null;
  }*/

  /*@Override
  public String getVinylTitle(int index) {
    return vinyls.get(index).getTitle();
  }

  @Override
  public VinylList getVinyls(String name) {
    return null;
  }

  @Override
  public int getNumberOfVinyls() {
    return vinyls.size();
  }*/

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    pcs.removePropertyChangeListener(listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    pcs.removePropertyChangeListener(listener);
  }
}
