package client.views.signUp;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import client.views.login.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpViewController implements ViewController
{
  @FXML
  private TextField email;

  @FXML
  private Label error;

  @FXML
  private PasswordField password;

  @FXML
  private PasswordField repeatPassword;

  @FXML
  private Button signup;

  @FXML
  private TextField username;

  private ViewHandler vh;
  private SignUpViewModel signUpViewModel;


  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    this.signUpViewModel = vmf.getSignUpViewModel();
  }

  @FXML
  void onCancelButton() {

  }

  @FXML
  void onReset() {

  }

  @FXML
  void onSignUp() {

  }
}
