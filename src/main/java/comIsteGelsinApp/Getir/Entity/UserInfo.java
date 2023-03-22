package comIsteGelsinApp.Getir.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;
    private String roles;
    @OneToMany(mappedBy = "userInfo")
    private List<Address> address;
    @OneToMany(mappedBy = "userInfo")
    private List<CrediCard> crediCard;
    @OneToMany(mappedBy = "userInfo")
    private List<Order>orders;

    public UserInfo(String name, String email) {
        this.name=name;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
        for(Address a:address){
            a.setUserInfo(this);
        }
    }

    public List<CrediCard> getCrediCard() {
        return crediCard;
    }

    public void setCrediCard(List<CrediCard> crediCard) {
        this.crediCard = crediCard;
        for(CrediCard card:crediCard){
            card.setUserInfo(this);
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
        for (Order order:orders){
            order.setUserInfo(this);
        }
    }
}
