package server.model;

import server.domain.Vinyl;
import server.domain.VinylList;
import server.persistance.MyDatabase;

import java.sql.SQLException;
import java.util.ArrayList;

public class VinylDatabase implements VinylPersistance
{
  private MyDatabase db;
  private static final String DRIVER = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
  private static final String USER = "postgres";
  private static final String PASSWORD = "danisnever7";

  public VinylDatabase() throws ClassNotFoundException
  {
    this.db= new MyDatabase(DRIVER, URL, USER, PASSWORD);
  }

  @Override
  public VinylList load() throws SQLException
  {
    String sql = "SELECT title, year, size, condition, email, username, rateperminute, description\n"
        + "FROM VinylListings.vinyl;";
    ArrayList<Object> results = db.showVinylList(sql);
    VinylList list = new VinylList();
    //should I put result.size - 1???
    int i = 0;
    while( i < results.size())
    {
      Vinyl vinyl = new Vinyl(String.valueOf(results.get(i)), String.valueOf(results.get(i+1)),String.valueOf(results.get(i+2)),String.valueOf(results.get(i+3)),String.valueOf(results.get(i+4)),
          String.valueOf(results.get(i+5)),String.valueOf(results.get(i+6)),String.valueOf(results.get(i+7)));
      System.out.println(vinyl.getTitle());
      list.addVinyl(vinyl);
          i = i + 8;
    }
    return list;
    // TODO: Should I just do it here with VinylList, or just continue to transfer Object list until it reaches vinyllist or at least model
  //Also connect with model
  }



  @Override public void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    String sql = "INSERT INTO VinylListings.vinyl (title, year, size, condition, email, username, rateperminute, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    db.update(sql,title,year,size,condition,email,username,ratePerMinute,description);
  }

  /*@Override public void remove(Vinyl vinyl)
  {

  }*/

  /*@Override public VinylList load() throws SQLException
  {
    String sql = "SELECT ...." + "WHERE ... to see results of list";
    ArrayList<Object[]> results;
    VinylList list = new VinylList();
    // ... TODO: to be implemented
    return list;
  }

  /*@Override public void save(VinylList vinylList) throwsSQLException
  {
    for (int i = 0; i < vinylList.getNumberOfVinyls(); i++)
    {
      save (vinylList.getVinyl(i));
    }
  }

  @Override public void save(Vinyl vinyl) throws SQLException
  {
    // ... TODO: to be implemented
  }

  @Override public void remove(Vinyl vinyl)
  {

  }

  @Override public void clear() throws SQLException
  {
    try
    {
      //example
      String sql = "TRUNCATE TABLE CdList.track CASCADE;"; db.update(sql);
      sql = "TRUNCATE TABLE CdList.cd CASCADE;";
      db.update(sql);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

  }*/
}
