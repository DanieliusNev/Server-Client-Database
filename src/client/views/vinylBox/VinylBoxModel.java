package client.views.vinylBox;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VinylBoxModel
{
  private Model model;
  private StringProperty titleProperty, nr1,nr2,nr3;

  public VinylBoxModel(Model model)
  {
    this.model = model;
    this.titleProperty = new SimpleStringProperty();
    this.nr1 = new SimpleStringProperty();
    this.nr2 = new SimpleStringProperty();
    this.nr3 = new SimpleStringProperty();
    System.out.println(model.getUsername(0));
  }
  public StringProperty titleProperty()
  {
    return titleProperty;
  }
  public void setTitleProperty(int i)
  {
    //titleProperty.setValue(model.getUsername(i));
    System.out.println(model.getUsername(i));
    titleProperty.set(model.getUsername(i));
    System.out.println(model.getUsername(i));
  }

  public void setNr1(int i)
  {
    this.nr1.setValue(model.getCondition(i));
  }

  public void setNr2(int i)
  {
    this.nr2.setValue(model.getDescription(i));
    nr2.set(model.getDescription(i));
  }

  public void setNr3(int i)
  {
    this.nr3.setValue(model.getEmail(i));
  }

  public StringProperty getNr1()
  {
    return nr1;
  }


  public StringProperty nr2Property()
  {
    return nr2;
  }

  public StringProperty nr3Property()
  {
    return nr3;
  }
}
