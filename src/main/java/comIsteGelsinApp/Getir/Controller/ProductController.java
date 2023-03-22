package comIsteGelsinApp.Getir.Controller;

import comIsteGelsinApp.Getir.Dto.Request.ProductRequest;
import comIsteGelsinApp.Getir.Dto.Response.ProductResponse;
import comIsteGelsinApp.Getir.Service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productAdd")
public class ProductController {
    private ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @PostMapping("/addNewProduct")
    public void add(@RequestBody ProductRequest productRequest){
        this.productService.add(productRequest);
    }

}
