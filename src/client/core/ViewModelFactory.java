package client.core;

import client.views.addvinyl.AddVinylViewModel;
import client.views.home.HomeViewModel;
import client.views.login.LoginViewModel;
import client.views.signUp.SignUpViewModel;
import client.views.vinylBox.VinylBoxModel;

public class ViewModelFactory
{
  private final ModelFactory mf;
  private HomeViewModel homeViewModel;
  private AddVinylViewModel addVinylViewModel;
  private VinylBoxModel vinylBoxModel;
  private LoginViewModel loginViewModel;
  private SignUpViewModel signUpViewModel;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
  }

  public AddVinylViewModel getViewAddVinylModel()
  {
    if (addVinylViewModel == null)
      addVinylViewModel = new AddVinylViewModel(mf.getModel());
    return addVinylViewModel;
  }
  public HomeViewModel getViewHomeModel()
  {
    if (homeViewModel == null)
      homeViewModel = new HomeViewModel(mf.getModel());
    return homeViewModel;
  }
  public VinylBoxModel getVinylBoxModel()
  {
    if (vinylBoxModel == null)
      vinylBoxModel = new VinylBoxModel(mf.getModel());
    return vinylBoxModel;
  }
  public LoginViewModel getLoginViewModel()
  {
    if (loginViewModel == null)
      loginViewModel = new LoginViewModel(mf.getModel());
    return loginViewModel;
  }
  public SignUpViewModel getSignUpViewModel()
  {
    if (signUpViewModel == null)
      signUpViewModel = new SignUpViewModel(mf.getModel());
    return signUpViewModel;
  }
}
