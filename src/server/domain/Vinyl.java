package server.domain;


public class Vinyl
{
  private String title, year, size, description, username, email, condition, ratePerMinute;

  public Vinyl(String title, String year, String size, String condition, String email, String username, String ratePerMinute, String description){
    this.condition = condition;
    this.description = description;
    this.email = email;
    this.ratePerMinute = ratePerMinute;
    this.size = size;
    this.title = title;
    this.username = username;
    this.year = year;
  }

  public Vinyl(String title)
  {
    this.title = title;
  }

  public String getContent(){
    return title + " " + year + " "
        + size + " " + condition + " "
        + ratePerMinute + " " + email + " "
        + username + " " + description + " ";
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public String getRatePerMinute() {
    return ratePerMinute;
  }

  public void setRatePerMinute(String ratePerMinute) {
    this.ratePerMinute = ratePerMinute;
  }
}

