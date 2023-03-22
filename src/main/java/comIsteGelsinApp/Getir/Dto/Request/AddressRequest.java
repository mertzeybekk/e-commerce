package comIsteGelsinApp.Getir.Dto.Request;

public class AddressRequest {
    private String city;
    private String district;
    private String buildingNumber;
    private String buildingName;
    private String postalCode;
    private int userInfoId;
    private String createdDate;

    public AddressRequest(String city, String district, String buildingNumber, String buildingName, String postalCode, int userInfoId,String createdDate) {
        this.city = city;
        this.district = district;
        this.buildingNumber = buildingNumber;
        this.buildingName = buildingName;
        this.postalCode = postalCode;
        this.userInfoId = userInfoId;
        this.createdDate=createdDate;
    }
    public AddressRequest(){}

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

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
