package comIsteGelsinApp.Getir.Dto.Response;

public class ProductResponse {
    private String productName;
    private double unitInPrice;

    public ProductResponse(String productName, double unitInPrice) {
        this.productName = productName;
        this.unitInPrice = unitInPrice;
    }
    public ProductResponse(){}

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
}
