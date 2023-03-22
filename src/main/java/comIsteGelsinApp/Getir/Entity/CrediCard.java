package comIsteGelsinApp.Getir.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "crediCard")
public class CrediCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private int id;
    @Column(name = "crediCard_Number")
    private String crediCardNumber;
    @Column(name = "crediCard_Date")
    private String crediCardDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    public CrediCard(int id, String crediCardNumber, String crediCardDate, UserInfo userInfo) {
        this.id = id;
        this.crediCardNumber = crediCardNumber;
        this.crediCardDate = crediCardDate;
        this.userInfo = userInfo;
    }
    public CrediCard(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
