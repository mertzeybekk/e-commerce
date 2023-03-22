package comIsteGelsinApp.Getir.Dto.Request;

public class ProductRequest {
    private String productName;
    private double unitInPrice;
    private int unitInStock;
    private int categoryId;

    public ProductRequest(String productName, double unitInPrice, int unitInStock, int categoryId) {
        this.productName = productName;
        this.unitInPrice = unitInPrice;
        this.unitInStock = unitInStock;
        this.categoryId = categoryId;
    }
    public ProductRequest(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitInPrice() {
        return unitInPrice;
    }

    public void setUnitInPrice(double unitInPrice) {
        this.unitInPrice = unitInPrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
