package objects;

import org.apache.commons.lang.RandomStringUtils;

public class Address {
  String address;
  String addressLine2;
  String city;
  String state;
  String postalCode;
  String country;
  String additionalInfo;
  String alias;

  public Address() {
    this.address = RandomStringUtils.randomAlphanumeric(10);
    this.addressLine2 = RandomStringUtils.randomAlphanumeric(10);
    this.city = RandomStringUtils.randomAlphanumeric(7);
    this.postalCode = RandomStringUtils.randomNumeric(5);
    this.additionalInfo = RandomStringUtils.randomAlphanumeric(7);
    this.alias = RandomStringUtils.randomAlphanumeric(5);
  }

  public String getAddress() {
    return address;
  }

  public String getAddressLine2() {
    return addressLine2;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public String getCountry() {
    return country;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public String getAlias() {
    return alias;
  }
}
