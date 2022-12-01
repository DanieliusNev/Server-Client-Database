package client.views.vinylBox;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class VinylBoxViewController implements ViewController
{
  @FXML
  private Text title;
  @FXML
  private Label nr1;

  @FXML
  private Label nr2;

  @FXML
  private Label nr3;
  private VinylBoxModel vinylBoxModel;
  private ViewHandler viewHandler;


  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vinylBoxModel = vmf.getVinylBoxModel();
    this.viewHandler = vh;
    title.textProperty().bind(vinylBoxModel.titleProperty());
    nr1.textProperty().bind(vinylBoxModel.getNr1());
    nr2.textProperty().bind(vinylBoxModel.nr2Property());
    nr3.textProperty().bind(vinylBoxModel.nr3Property());
    vinylBoxModel.setTitleProperty(0);
    vinylBoxModel.setNr1(0);
    vinylBoxModel.setNr2(0);
    vinylBoxModel.setNr3(0);
    title.setText("ow");
    nr1.setText("wow");
  }
}
