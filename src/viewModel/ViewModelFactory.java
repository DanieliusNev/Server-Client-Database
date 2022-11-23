package viewModel;

import model.mediator.Model;

public class ViewModelFactory
{
  //IDk if it should contain model
  private ViewHomeModel viewHomeModel;
  private ViewAddVinylModel viewAddVinylModel;

  public ViewModelFactory(Model model)
  {
    viewHomeModel = new ViewHomeModel(model);
    viewAddVinylModel = new ViewAddVinylModel(model);
  }

  public ViewHomeModel getViewHomeModel()
  {
    return viewHomeModel;
  }
  public ViewAddVinylModel getViewAddVinylModel()
  {
    return viewAddVinylModel;
  }
}
