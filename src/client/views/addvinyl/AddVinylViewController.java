package client.views.addvinyl;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddVinylViewController implements ViewController

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
  @FXML
  private ImageView imageView;

  private AddVinylViewModel viewModel;
  private ViewHandler viewHandler;

  public AddVinylViewController(){}

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {

    this.viewHandler = vh;
    this.viewModel = vmf.getViewAddVinylModel();
    title.textProperty().bindBidirectional(viewModel.titleProperty());
    condition.textProperty().bindBidirectional(viewModel.conditionProperty());
    email.textProperty().bindBidirectional(viewModel.emailProperty());
    username.textProperty().bindBidirectional(viewModel.usernameProperty());
    description.textProperty().bindBidirectional(viewModel.descriptionProperty());
    year.textProperty().bindBidirectional(viewModel.yearProperty());
    size.textProperty().bindBidirectional(viewModel.sizeProperty());
    ratePerMinute.textProperty().bindBidirectional(viewModel.ratePerMinuteProperty());
  }

  @FXML
  void backBtn() {
    viewHandler.openHome();
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
      viewModel.save();
      resetFields();
      JOptionPane.showMessageDialog(null, "Your vinyl was saved!", "Saving", JOptionPane.INFORMATION_MESSAGE);
      backBtn();
       }
  }
  @FXML
  void addImage() {
    //FileChooser fc = new FileChooser();
    //fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG Files",".jpg"));
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Text Files", "*.txt"),
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
        new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
        new FileChooser.ExtensionFilter("All Files", "*.*"));
    File selectedFile = fileChooser.showOpenDialog(null);
    if (selectedFile != null)
    {
      Image image = new Image(selectedFile.toURI().toString(), 100,150,true,true);

      imageView.setImage(image);
      imageView.setPreserveRatio(true);
      // retrieve image
      /*BufferedImage bi = getMyImage();
      try
      {
        ImageIO.write(bi, "jpeg", selectedFile);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }*/

    }
  }


}
