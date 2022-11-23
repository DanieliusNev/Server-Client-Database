import javafx.application.Application;
import javafx.stage.Stage;
import model.mediator.Model;
import model.mediator.ModelImplementation;
import view.ViewHandler;
import viewModel.ViewModelFactory;

public class MyApplication extends Application
{
  @Override public void start(Stage primaryStage) throws Exception
  {
    Model model = new ModelImplementation();
    ViewModelFactory viewModelFactory = new ViewModelFactory(model);
    ViewHandler view = new ViewHandler(viewModelFactory);

    view.start(primaryStage);
  }
}
