package client.views.home;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.net.URL;

public class HomeViewController implements ViewController
{
  private HomeViewModel viewModel;
  private ViewHandler viewHandler;
  @FXML
  private VBox vinylList;
  @FXML
  private Text tryInput;
  @FXML
  private TextField text;

private String title;
  public HomeViewController(){}

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewModel = vmf.getViewHomeModel();
    this.viewHandler = vh;

    /*viewModel.onNewVinyl(vm -> {
      Platform.runLater(() -> {
        Parent bubble = null;
        try
        {
          bubble = viewHandler.openVinylBox();
        }
        catch (IOException e)
        {
          e.printStackTrace();
        }
        this.vinylList.getChildren().add(bubble);
      });
    });*/
    try
    {
      this.vinylList.getChildren().add(viewHandler.openVinylBox());
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }


  @FXML
  void addBtn() {
    viewHandler.openAddVinyl();
  }

  @FXML
  void login() {
    viewHandler.openLogin();
  }
}
