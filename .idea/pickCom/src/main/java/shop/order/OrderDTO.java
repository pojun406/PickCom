package shop.order;

public class OrderDTO {
    private int order_num;
    private String member_id;
    private int product_num;
    private String order_quntity;
    private String order_address;

    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
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

    public String getOrder_quntity() {
        return order_quntity;
    }

    public void setOrder_quntity(String order_quntity) {
        this.order_quntity = order_quntity;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }
}
