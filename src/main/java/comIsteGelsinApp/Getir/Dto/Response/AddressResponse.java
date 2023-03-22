package comIsteGelsinApp.Getir.Dto.Response;

public class AddressResponse {
    private String userInfoName;
    private String userInfoEmail;
    private String city;
    private String district;
    private String buildingNumber;
    private String buildingName;
    private String postalCode;

    public AddressResponse(String userInfoName,String userInfoEmail, String city, String district, String buildingNumber, String buildingName, String postalCode) {
        this.userInfoName = userInfoName;
        this.city = city;
        this.district = district;
        this.buildingNumber = buildingNumber;
        this.buildingName = buildingName;
        this.postalCode = postalCode;
        this.userInfoEmail=userInfoEmail;
    }
   public AddressResponse(){}

    public String getUserInfoName() {
        return userInfoName;
    }

    public void setUserInfoName(String userInfoName) {
        this.userInfoName = userInfoName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getUserInfoEmail() {
        return userInfoEmail;
    }

    public void setUserInfoEmail(String userInfoEmail) {
        this.userInfoEmail = userInfoEmail;
    }
}
