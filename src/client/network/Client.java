package client.network;

import shared.util.Subject;

public interface Client extends Subject
{
  void startClient();
  void save(String title, int year, int size, String condition,
      String email, String username, int ratePerMinute, String description);
}
