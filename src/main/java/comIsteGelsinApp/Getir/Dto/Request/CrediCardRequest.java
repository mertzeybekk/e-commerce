package comIsteGelsinApp.Getir.Dto.Request;

public class CrediCardRequest {
    private String crediCardNumber;
    private String crediCardDate;
    private int userInfoId;

    public CrediCardRequest(String crediCardNumber, String crediCardDate, int userInfoId) {
        this.crediCardNumber = crediCardNumber;
        this.crediCardDate = crediCardDate;
        this.userInfoId = userInfoId;
    }
    public CrediCardRequest(){}

    public String getCrediCardNumber() {
        return crediCardNumber;
    }

    public void setCrediCardNumber(String crediCardNumber) {
        this.crediCardNumber = crediCardNumber;
    }

    public String getCrediCardDate() {
        return crediCardDate;
    }

    public void setCrediCardDate(String crediCardDate) {
        this.crediCardDate = crediCardDate;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }
}
