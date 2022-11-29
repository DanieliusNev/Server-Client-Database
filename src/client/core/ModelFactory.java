package client.core;

import client.model.Model;
import client.model.ModelImpl;

public class ModelFactory
{
  private final ClientFactory cf;
  private Model model;


  public ModelFactory(ClientFactory cf) {
    this.cf = cf;
  }

  public Model getModel() {
    if(model == null)
      model = new ModelImpl(cf.getClient());
    return model;
  }
}
