import persistance.MyDatabase;

import java.sql.*;

public class RunDatabase
{
  public static void main(String[] args)
  {
    /*// load driver

    try
    {
      Class.forName("org.postgresql.Driver"); // external jar

      String url = "jdbc:postgresql://localhost:5432/postgres";
      String user = "postgres";
      String pw = "danisnever7";
      // create connection
      Connection connection = DriverManager.getConnection(url, user, pw);

      // Define sql statement
      String sql = "INSERT INTO VinylListings.vinyl (title, year, size, condition, email, username, rateperminute, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
      // create statement
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, "Daniel");
      statement.setInt(2, 2022);
      statement.setInt(3, 6);
      statement.setString(4, "perfect");
      statement.setString(5, "wow@gmail.com");
      statement.setString(6, "dannn");
      statement.setInt(7, 78);
      statement.setString(8, "woooow");
      // execute update
      int updates = statement.executeUpdate();
      System.out.println("Number of updates: " + updates);
*/
      /*// Define sql statement
      String sql = "SELECT * from CdList.cd WHERE Title LIKE ?;";
      // create statement
      PreparedStatement statement = connection.prepareStatement(sql); statement.setString(1, "Best%");
      // execute query
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        int columns = resultSet.getMetaData().getColumnCount(); for (int i = 0; i < columns; i++)
      {
        System.out.print(resultSet.getObject(i + 1)); if (i < columns - 1)
      {
        System.out.print(", ");
      }
      }
        System.out.println();
      }*/


   /* }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }*/



  }
}
