package client.views.home;

import client.model.Model;
import client.views.vinylBox.VinylBoxModel;
import server.domain.Vinyl;

import java.util.function.Consumer;

public class HomeViewModel
{
  private Model model;
  //private Consumer<String> onNewVinyl;
  private VinylBoxModel vinymodel;

  public HomeViewModel(Model model)
  {
    this.model = model;
    this.vinymodel = new VinylBoxModel(model);
  }

  /*public void onNewVinyl(Consumer<String> onNewVinyl)
  {
    this.onNewVinyl = onNewVinyl;
    vinymodel.setTitleProperty(String.valueOf(onNewVinyl));
  }*/

  public String getDescription(int i)
  {
    return model.getDescription(i);
  }

  public String getUsername(int i)
  {
    return model.getUsername(i);
  }

  public String getEmail(int i)
  {
    return model.getEmail(i);
  }

  /*public String getYear(int i)
  {
    return model.getYear(i);
  }*/

  /*public String getSize(int i)
  {
    return model.getSize(i);
  }*/

  public String getCondition(int i)
  {
    return model.getCondition(i);
  }

  /*public String getRatePerMinute(int i)
  {
    return model.getUsername(i);
  }*/

  /*public int getSizeOfVinylList()
  {
    return model.getSizeOfVinylList();
  }*/
}
