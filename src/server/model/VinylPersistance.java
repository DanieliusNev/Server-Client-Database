package server.model;

import server.domain.Vinyl;
import server.domain.VinylList;

import java.sql.SQLException;

public interface VinylPersistance
{
  VinylList load() throws SQLException;
  void save(String title, int year, int size, String condition, String email,
      String username, int ratePerMinute, String description);
  //void remove(Vinyl vinyl);
  void createAccount(String username, String password,
      String email);
}
