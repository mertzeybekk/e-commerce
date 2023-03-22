package comIsteGelsinApp.Getir.Dto.Response;

import comIsteGelsinApp.Getir.Entity.UserInfo;

import java.util.Map;

public class CrediCardResponse {
    private String crediCardNumber;
    private String crediCardDate;
    private Map<Integer, UserInfo>userInfoList;

    public CrediCardResponse(String crediCardNumber, String crediCardDate, Map<Integer, UserInfo> userInfoList) {
        this.crediCardNumber = crediCardNumber;
        this.crediCardDate = crediCardDate;
        this.userInfoList = userInfoList;
    }
    public CrediCardResponse(){}

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

    public Map<Integer, UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(Map<Integer, UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }
}
