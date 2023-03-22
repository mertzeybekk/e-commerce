package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.CategoryRequest;
import comIsteGelsinApp.Getir.Dto.Response.CategoryResponse;
import comIsteGelsinApp.Getir.Entity.Category;
import comIsteGelsinApp.Getir.Entity.Product;
import comIsteGelsinApp.Getir.Mapper.ModelMapperService;
import comIsteGelsinApp.Getir.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryService implements CategoryServiceImpl {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;
    public CategoryService(CategoryRepository categoryRepository,ModelMapperService modelMapperService){
        this.categoryRepository=categoryRepository;
        this.modelMapperService=modelMapperService;
    }
    @Override
    public void add(CategoryRequest categoryRequest) {
        Category category=new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
     this.categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryResponse> getAll() {
        List<Category>categoryList=this.categoryRepository.findAll();
        List<CategoryResponse>categoryResponses=new ArrayList<>();
        Map<Integer,Product> productMap = null;
        for(Category category: categoryList){
            CategoryResponse categoryResponse=new CategoryResponse();
            categoryResponse.setCategoryName(category.getCategoryName());
            for(Product p:categoryList.get(category.getId()-1).getProduct()){
                productMap=new HashMap<>();
                productMap.put(p.getId(), new Product(p.getProductName(), p.getUnitInPrice(), p.getUnitInStock()));
            }
            categoryResponse.setProductList(productMap);
            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;
    }

    @Override
    public Optional<CategoryResponse> getById(int id) {
        Optional<Category> category=this.categoryRepository.findById(id);
        CategoryResponse categoryResponse=this.modelMapperService.forResponse().map(category,CategoryResponse.class);
        return Optional.ofNullable(categoryResponse);
    }

    @Override
    public void update(CategoryRequest categoryRequest, int id) {
        Optional<Category> categorynew=this.categoryRepository.findById(id);
        if(categorynew.isPresent()){
            categorynew.get().setCategoryName(categoryRequest.getCategoryName());
            this.categoryRepository.save(categorynew.get());
        }
    }
}
