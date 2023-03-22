package comIsteGelsinApp.Getir.Controller;

import comIsteGelsinApp.Getir.Dto.Request.CategoryRequest;
import comIsteGelsinApp.Getir.Dto.Response.CategoryResponse;
import comIsteGelsinApp.Getir.Service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoryAdd")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService=categoryService;
    }
    @PostMapping("/addNewCategory")

    public void add(@RequestBody CategoryRequest categoryRequest){
        this.categoryService.add(categoryRequest);
    }
    @GetMapping("/getCategoryAll")

    public List<CategoryResponse>getAll(){
        return this.categoryService.getAll();
    }
    @DeleteMapping("/deleteCategory/{id}")

    public void deleteCategory(@PathVariable int id){
        this.categoryService.delete(id);
    }
    @PutMapping("/updateCategory/{id}")

    public void updateCategory(@RequestBody CategoryRequest categoryRequest,@PathVariable int id){
        this.categoryService.update(categoryRequest,id);
    }
    @GetMapping("/getCategoryById/{id}")
    public Optional<CategoryResponse> getByIdCategory(@PathVariable int id){
        return this.categoryService.getById(id);
    }
}
