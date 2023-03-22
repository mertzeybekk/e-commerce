package comIsteGelsinApp.Getir.Dto.Request;

public class CategoryRequest {
    private String categoryName;

    public CategoryRequest(String categoryName) {
        this.categoryName = categoryName;
    }
    public CategoryRequest(){}

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
