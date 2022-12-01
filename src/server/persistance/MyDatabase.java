package server.persistance;

import java.sql.*;
import java.util.ArrayList;

public class MyDatabase extends Object{

  private Connection connection;
  private String driver;
  private String url;
  private String user;
  private String password;

  public MyDatabase(String driver, String url, String user, String pw)
      throws ClassNotFoundException
  {
    this.driver = driver;
    this.url = url;
    this.user = user;
    this.password = pw;
    try
    {
      this.connection = DriverManager.getConnection(url, user, pw);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public void update(String sql, String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description)
  {
    try
    {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, title);
      statement.setInt(2, year);
      statement.setInt(3, size);
      statement.setString(4, condition);
      statement.setString(5, email);
      statement.setString(6, username);
      statement.setInt(7, ratePerMinute);
      statement.setString(8, description);
      // execute update
      int updates = statement.executeUpdate();
      System.out.println("Number of updates: " + updates);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public void createAccount(String username, String password,
      String email, String sql)
  {
    try
    {
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, username);
      statement.setString(2, password);
      statement.setString(3, email);

      // execute update
      int updates = statement.executeUpdate();
      System.out.println("Number of updates: " + updates);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  public ArrayList<Object> showVinylList(String sql)
  {
    ArrayList<Object> list = new ArrayList<>();
    try
    {
      PreparedStatement statement = connection.prepareStatement(sql);

      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        int columns = resultSet.getMetaData().getColumnCount();
        for (int i = 0; i < columns; i++)
        {
          list.add(resultSet.getObject(i + 1));
          if (i < columns - 1)
          {

          }
        }
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
      return list;
  }



}
