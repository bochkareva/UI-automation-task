package objects;

import org.apache.commons.lang.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

public class User {
  Boolean gender; //1 - Mr, 0 - Mrs
  String  firstName;
  String  lastName;
  String  email;
  String  password;
  //TODO birthday -> Date
  String  birthday;
  String  company;
  Address address;
  String  homePhone;
  String  mobilePhone;

  public User() {
    this.gender = ThreadLocalRandom.current().nextBoolean();
    this.firstName = RandomStringUtils.randomAlphabetic(7);
    this.lastName = RandomStringUtils.randomAlphabetic(7);
    this.email = RandomStringUtils.randomAlphabetic(10) + "@automation.com";
    this.password = RandomStringUtils.randomAlphanumeric(8);
    this.address = new Address();
    this.homePhone = RandomStringUtils.randomNumeric(10);
    this.mobilePhone = RandomStringUtils.randomNumeric(11);
    this.company = RandomStringUtils.randomAlphabetic(6);
  }

  public Boolean getGender() {
    return gender;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getBirthday() {
    return birthday;
  }

  public Address getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getCompany() {
    return company;
  }
}
