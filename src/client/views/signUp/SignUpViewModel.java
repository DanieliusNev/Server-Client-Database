package client.views.signUp;

import client.model.Model;

public class SignUpViewModel
{
  private Model model;

  public SignUpViewModel(Model model)
  {
    this.model = model;
  }

  public void createAccount(String username, String password, String email)
  {
    model.createAccount(username, password,email);
  }
}
