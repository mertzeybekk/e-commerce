package comIsteGelsinApp.Getir.Dto.Request;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private int userInfoId;
    private List<Integer> productId;

}
