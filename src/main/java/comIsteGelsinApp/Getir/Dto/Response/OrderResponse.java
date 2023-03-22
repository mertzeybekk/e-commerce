package comIsteGelsinApp.Getir.Dto.Response;

import comIsteGelsinApp.Getir.Entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private String productName;
    private String userInfoName;
    private String userInfoEmail;
    private int unitInPrice;
    private int orderNumber;
    private String orderDate;
    private int totalPrice;


}
