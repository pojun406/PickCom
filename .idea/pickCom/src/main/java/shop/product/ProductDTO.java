package shop.product;

public class ProductDTO {
    private int product_num;
    private String manufacturer_name;
    private String product_name;
    private int product_salePrice;
    private int product_originalPrice;
    private int product_quantity;
    private String product_classification;
    private String product_description;
    private boolean product_stat;

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_salePrice() {
        return product_salePrice;
    }

    public void setProduct_salePrice(int product_salePrice) {
        this.product_salePrice = product_salePrice;
    }

    public int getProduct_originalPrice() {
        return product_originalPrice;
    }

    public void setProduct_originalPrice(int product_originalPrice) {
        this.product_originalPrice = product_originalPrice;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_classification() {
        return product_classification;
    }

    public void setProduct_classification(String product_classification) {
        this.product_classification = product_classification;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public boolean isProduct_stat() {
        return product_stat;
    }

    public void setProduct_stat(boolean product_stat) {
        this.product_stat = product_stat;
    }
}
