package view;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import viewModel.ViewHomeModel;

import java.awt.*;

public class ViewHomeController
{
  @FXML
  private Button addBtn;

  private Region root;
  private ViewHomeModel viewHomeModel;
  private ViewHandler viewHandler;

  public ViewHomeController(){}

  public void init(Region root, ViewHomeModel viewHomeModel, ViewHandler viewHandler)
  {
    this.root = root;
    this.viewHomeModel = viewHomeModel;
    this.viewHandler = viewHandler;
  }
  public void reset()
  {

  }

  public Region getRoot()
  {
    return root;
  }

  @FXML
  void addBtn() {
    viewHandler.openView("addVinyl");
  }
}
