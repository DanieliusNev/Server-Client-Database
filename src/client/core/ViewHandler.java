package client.core;

import client.views.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewHandler
{

  private Scene homeScene;
  private Stage stage;
  private ViewModelFactory vmf;
  private Scene AddVinylScene;
  private Scene login;
  private Scene signUp;

  public ViewHandler(ViewModelFactory vmf) {
    this.vmf = vmf;
  }

  public void start() {
    stage = new Stage();
    openHome();
  }

  public void openHome() {
    if (homeScene == null) {
      try {
        Parent root = loadFXML("../views/home/home.fxml");

        stage.setTitle("Home");
        homeScene = new Scene(root);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(homeScene);
    stage.show();
  }

  public void openAddVinyl() {
    // no reusing a logScene, because I want the log to reload the latest every time.
    if (AddVinylScene == null) {
      try {
        Parent root = loadFXML("../views/addvinyl/addVinyl.fxml");

        AddVinylScene = new Scene(root);
        stage.setTitle("Add Vinyl");

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(AddVinylScene);
    stage.show();
  }
  public Parent openVinylBox() throws IOException{

    URL cardURL = getClass().getResource("../views/vinylBox/vinylBox.fxml");


    Parent cardAnchor = FXMLLoader.load(cardURL);

      return cardAnchor;
  }
  public void openLogin() {
    // no reusing a logScene, because I want the log to reload the latest every time.
    if (login == null) {
      try {
        Parent root = loadFXML("../views/login/login.fxml");

        login = new Scene(root);
        stage.setTitle("Login");

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(login);
    stage.show();
  }

  public void openSignUp() {
    // no reusing a logScene, because I want the log to reload the latest every time.
    if (signUp == null) {
      try {
        Parent root = loadFXML("../views/signUp/signUp.fxml");

        signUp = new Scene(root);
        stage.setTitle("SignUp");

      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    stage.setScene(signUp);
    stage.show();
  }


  private Parent loadFXML(String path) throws IOException {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }

}
