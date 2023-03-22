package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.ProductRequest;
import comIsteGelsinApp.Getir.Dto.Response.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductServiceImpl {
    public void add(ProductRequest productRequest);
    public void delete(int id);
    public void update(ProductRequest productRequest,int id);
    public List<ProductResponse>getAll();
    public Optional<ProductResponse> getById(int id);
    public List<ProductResponse>getByPrice(double price);
}
