package client.network;

import shared.util.Subject;

public interface Client extends Subject
{
  void startClient();
  void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description);

  String getDescription(int i);

  String getUsername(int i);

  String getEmail(int i);

  //String getYear(int i);

  //String getSize(int i);

  String getCondition(int i);

  //String getRatePerMinute(int i);

  //int getSizeOfVinylList();
}
