package shop.cart;

public class CartDTO {
    private int cart_num;
    private String member_id;
    private int product_num;
    private int cart_quantity;
    private String cart_regDate;

    public int getCart_num() {
        return cart_num;
    }

    public void setCart_num(int cart_num) {
        this.cart_num = cart_num;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public int getCart_quantity() {
        return cart_quantity;
    }

    public void setCart_quantity(int cart_quantity) {
        this.cart_quantity = cart_quantity;
    }

    public String getCart_regDate() {
        return cart_regDate;
    }

    public void setCart_regDate(String cart_regDate) {
        this.cart_regDate = cart_regDate;
    }
}
