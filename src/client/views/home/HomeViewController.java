package client.views.home;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;

public class HomeViewController implements ViewController
{
  private HomeViewModel viewModel;
  private ViewHandler viewHandler;

  public HomeViewController(){}

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
