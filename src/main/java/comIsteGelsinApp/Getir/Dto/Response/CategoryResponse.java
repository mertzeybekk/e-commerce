package comIsteGelsinApp.Getir.Dto.Response;

import comIsteGelsinApp.Getir.Entity.Product;

import java.util.List;
import java.util.Map;

public class CategoryResponse {
    private String categoryName;
    private Map<Integer, Product> productList;

    public CategoryResponse(String categoryName, Map<Integer, Product> productList) {
        this.categoryName = categoryName;
        this.productList = productList;
    }
    public CategoryResponse(){}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Map<Integer, Product> getProductList() {
        return productList;
    }

    public void setProductList(Map<Integer, Product> productList) {
        this.productList = productList;
    }
}
