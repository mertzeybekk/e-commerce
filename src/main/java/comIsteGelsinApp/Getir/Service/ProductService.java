package comIsteGelsinApp.Getir.Service;

import comIsteGelsinApp.Getir.Dto.Request.ProductRequest;
import comIsteGelsinApp.Getir.Dto.Response.ProductResponse;
import comIsteGelsinApp.Getir.Entity.Category;
import comIsteGelsinApp.Getir.Entity.Product;
import comIsteGelsinApp.Getir.Mapper.ModelMapperService;
import comIsteGelsinApp.Getir.Repository.CategoryRepository;
import comIsteGelsinApp.Getir.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceImpl {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private ModelMapperService mapperService;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ModelMapperService mapperService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.mapperService = mapperService;
    }

    @Override
    public void add(ProductRequest productRequest) {
        Optional<Category> category=this.categoryRepository.findById(productRequest.getCategoryId());
        Product product= new Product();
        product.setCategory(category.get());
        product.setProductName(productRequest.getProductName());
        product.setUnitInPrice(productRequest.getUnitInPrice());
        product.setUnitInStock(productRequest.getUnitInStock());
        this.productRepository.save(product);

    }

    @Override
    public void delete(int id) {
        this.productRepository.deleteById(id);

    }

    @Override
    public void update(ProductRequest productRequest, int id) {
        Optional<Product>product=this.productRepository.findById(id);
        if(product.isPresent()){
            product.get().setUnitInStock(productRequest.getUnitInStock());
            product.get().setUnitInPrice(productRequest.getUnitInPrice());
            this.productRepository.save(product.get());
        }

    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> productList=this.productRepository.findAll();
        List<ProductResponse>productResponses=
                productList.stream().
                map(product -> this.mapperService.forResponse().map(product,ProductResponse.class))
                .collect(Collectors.toList());
        return productResponses;
    }

    @Override
    public Optional<ProductResponse> getById(int id) {
        Optional<Product> product=this.productRepository.findById(id);
        ProductResponse productResponse = this.mapperService.forResponse().map(product,ProductResponse.class);
        return Optional.ofNullable(productResponse);
    }

    @Override
    public List<ProductResponse> getByPrice(double price) {
        List<Product>productList=this.productRepository.getProductWithMinimumPrice(price);
        List<ProductResponse>productResponses=
                productList.stream().
                map(product -> this.mapperService.forResponse().map(product,ProductResponse.class))
                        .collect(Collectors.toList());

        return productResponses;
    }
}
