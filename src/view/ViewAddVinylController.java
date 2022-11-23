package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import model.mediator.VinylDatabase;
import viewModel.ViewAddVinylModel;


public class ViewAddVinylController
{

  @FXML
  private TextField condition;

  @FXML
  private TextField description;

  @FXML
  private TextField email;

  @FXML
  private TextField ratePerMinute;

  @FXML
  private TextField size;

  @FXML
  private TextField title;

  @FXML
  private TextField username;

  @FXML
  private TextField year;

  private Region root;
  private ViewAddVinylModel viewAddVinylModel;
  private ViewHandler viewHandler;
  private VinylDatabase vinylDatabase;

  public ViewAddVinylController(){}

  public void init(Region root, ViewAddVinylModel viewAddVinylModel, ViewHandler viewHandler)
  {
    this.root = root;
    this.viewAddVinylModel = viewAddVinylModel;
    this.viewHandler = viewHandler;
    try
    {
      this.vinylDatabase = new VinylDatabase();
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
  public void reset()
  {

  }

  public Region getRoot()
  {
    return root;
  }

  @FXML
  void backBtn() {
    viewHandler.openView("home");
  }
  @FXML
  void resetFields() {
    title.clear();
    year.clear();
    size.clear();
    condition.clear();
    email.clear();
    username.clear();
    ratePerMinute.clear();
    description.clear();
  }
  @FXML
  void addVinyl() {
    if(title.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Title has more than 50 characters");
      alert.showAndWait();
    } else if(condition.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Condition has more than 50 characters");
      alert.showAndWait();
    }else if(email.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Email has more than 50 characters");
      alert.showAndWait();
    }else if(username.getLength()>50)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Username has more than 50 characters");
      alert.showAndWait();
    }else if(description.getLength()>100)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Description has more than 100 characters");
      alert.showAndWait();
    }
    else if(title.getLength()==0 || year.getLength()==0 || size.getLength()==0 || condition.getLength()==0 || email.getLength()==0 || username.getLength()==0
        || ratePerMinute.getLength()==0 || description.getLength()==0)
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText("Fill out all the blank fields");
      alert.showAndWait();
    }
    else
    {
      vinylDatabase.save(title.getText(), Integer.parseInt(year.getText()),
          Integer.parseInt(size.getText()), condition.getText(), email.getText(),
          username.getText(), Integer.parseInt(ratePerMinute.getText()),
          description.getText());
      resetFields();
      backBtn();
    }
  }

}
