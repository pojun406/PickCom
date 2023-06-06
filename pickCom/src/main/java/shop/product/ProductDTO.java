package shop.product;

public class ProductDTO {
    private int product_num;
    private String manufacturer_name;
    private int seller_num;
    private String product_name;
    private int product_salePrice;
    private int product_originalPrice;
    private int product_shippingFee;
    private int product_quantity;
    private String product_category1;
    private String product_category2;
    private String product_description;
    private String product_img;
    private boolean product_soldOut;
    private int product_sales;
    private String product_regDate;
    private int product_visitCount;
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

    public int getProduct_shippingFee() {
        return product_shippingFee;
    }

    public void setProduct_shippingFee(int product_shippingFee) {
        this.product_shippingFee = product_shippingFee;
    }

    public int getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }

    public String getProduct_category1() {
        return product_category1;
    }

    public void setProduct_category1(String product_category1) {
        this.product_category1 = product_category1;
    }

    public String getProduct_category2() {
        return product_category2;
    }

    public void setProduct_category2(String product_category2) {
        this.product_category2 = product_category2;
    }

    public int getSeller_num() {
        return seller_num;
    }

    public void setSeller_num(int seller_num) {
        this.seller_num = seller_num;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public boolean isProduct_soldOut() {
        return product_soldOut;
    }

    public void setProduct_soldOut(boolean product_soldOut) {
        this.product_soldOut = product_soldOut;
    }

    public int getProduct_sales() {
        return product_sales;
    }

    public void setProduct_sales(int product_sales) {
        this.product_sales = product_sales;
    }

    public String getProduct_regDate() {
        return product_regDate;
    }

    public void setProduct_regDate(String product_regDate) {
        this.product_regDate = product_regDate;
    }

    public int getProduct_visitCount() {
        return product_visitCount;
    }

    public void setProduct_visitCount(int product_visitCount) {
        this.product_visitCount = product_visitCount;
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
