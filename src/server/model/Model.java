package server.model;

import server.domain.VinylList;
import shared.util.Subject;

import java.sql.SQLException;

public interface Model extends Subject
{
  void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description);
  int getSizeOfVinylList();

  String getDescription(int i);

  String getUsername(int i);

  String getEmail(int i);

  //String getYear(int i);

  //String getSize(int i);

  String getCondition(int i);

  //String getRatePerMinute(int i);
  void createAccount(String username, String password,
      String email);

}
