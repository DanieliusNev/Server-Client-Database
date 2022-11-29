package client.core;

import client.views.addvinyl.AddVinylViewModel;
import client.views.home.HomeViewModel;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private HomeViewModel homeViewModel;
  private AddVinylViewModel addVinylViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public AddVinylViewModel getViewAddVinylModel()
  {
    if (addVinylViewModel == null)
      addVinylViewModel = new AddVinylViewModel(mf.getModel());
    return addVinylViewModel;
  }
  public HomeViewModel getViewHomeModel()
  {
    if (homeViewModel == null)
      homeViewModel = new HomeViewModel(mf.getModel());
    return homeViewModel;
  }
}
