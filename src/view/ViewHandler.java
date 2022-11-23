package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import viewModel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory viewModelFactory;
  private Stage primaryStage;
  private Scene currentScene;
  private ViewAddVinylController viewAddVinylController;
  private ViewHomeController viewHomeController;

  public ViewHandler(ViewModelFactory viewModelFactory){
    this.viewModelFactory = viewModelFactory;
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage)
  {
    this.primaryStage = primaryStage;
    openView("home");
  }

  public void openView(String id)
  {
    Region root = null;
    switch (id)
    {
      case "home":
        root = loadHomeView("home.fxml");
        break;
      case "addVinyl":
        root = loadAddVinylView("addVinyl.fxml");
        break;

    }
    currentScene.setRoot(root);
    String title = "";
    if(id.equals("home"))
    {
      title = "Home";
    } if(id.equals("addVinyl"))
  {
    title = "AddVinyl";
  }

    if (root.getUserData() !=  null)
    {
      title += root.getUserData();
    }

    primaryStage.setTitle(title);
    primaryStage.setScene(currentScene);
    primaryStage.setWidth(root.getPrefWidth());
    primaryStage.setHeight(root.getPrefHeight());
    primaryStage.show();
  }

  public void closeView()
  {
    primaryStage.close();
  }

  private Region loadHomeView(String fxmlFile)
  {
    Region root = null;
    if (viewHomeController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        viewHomeController = loader.getController();
        viewHomeController.init(root, viewModelFactory.getViewHomeModel(),this);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      viewHomeController.reset();
    }
    return viewHomeController.getRoot();
  }

  private Region loadAddVinylView(String fxmlFile)
  {
    Region root = null;
    if (viewAddVinylController == null)
    {
      try
      {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxmlFile));
        root = loader.load();
        viewAddVinylController = loader.getController();
        viewAddVinylController.init(root, viewModelFactory.getViewAddVinylModel(),this);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      viewAddVinylController.reset();
    }
    return viewAddVinylController.getRoot();
  }

}
