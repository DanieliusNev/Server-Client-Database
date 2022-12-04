package client.core;

import client.views.addvinyl.ViewAddVinylModel;
import client.views.home.ViewHomeModel;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private ViewHomeModel viewHomeModel;
  private ViewAddVinylModel viewAddVinylModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public ViewAddVinylModel getViewAddVinylModel()
  {
    if (viewAddVinylModel == null)
      viewAddVinylModel = new ViewAddVinylModel(mf.getModel());
    return viewAddVinylModel;
  }
  public ViewHomeModel getViewHomeModel()
  {
    if (viewHomeModel == null)
      viewHomeModel = new ViewHomeModel(mf.getModel());
    return viewHomeModel;
  }
}
