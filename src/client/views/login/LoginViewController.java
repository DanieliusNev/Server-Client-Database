package client.views.login;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.views.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import javax.swing.text.View;

public class LoginViewController implements ViewController
{
  @FXML
  private Button Signup;

  @FXML
  private PasswordField password;

  @FXML
  private TextField username;
  private ViewHandler vh;
  private LoginViewModel loginViewModel;

  public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.vh = vh;
    loginViewModel = vmf.getLoginViewModel();
  }
  @FXML
  void onReset() {

  }

  @FXML
  void onSignupButton() {
    vh.openSignUp();
  }

}
