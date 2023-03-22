package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.CategoryRequest;
import comIsteGelsinApp.Getir.Dto.Response.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceImpl {
    public void add(CategoryRequest categoryRequest);
    public void delete(int id);
    public List<CategoryResponse> getAll();
    public Optional<CategoryResponse> getById(int id);
    public void update(CategoryRequest categoryRequest,int id);

}
