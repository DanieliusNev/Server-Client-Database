package client.views.home;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;

public class ViewHomeController implements ViewController
{
  private ViewHomeModel viewModel;
  private ViewHandler viewHandler;

  public ViewHomeController(){}

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewModel = vmf.getViewHomeModel();
    this.viewHandler = vh;
  }


  @FXML
  void addBtn() {
    viewHandler.openAddVinyl();
  }
}
