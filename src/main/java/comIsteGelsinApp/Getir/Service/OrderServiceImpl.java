package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.OrderRequest;
import comIsteGelsinApp.Getir.Dto.Response.OrderResponse;

import java.util.List;

public interface OrderServiceImpl {
    public String add(OrderRequest orderRequest);
    public String delete(int id);
    public String update(OrderRequest orderRequest,int id);
    public List<OrderResponse>getAll();
    public List<OrderResponse>getById(int id);
}
