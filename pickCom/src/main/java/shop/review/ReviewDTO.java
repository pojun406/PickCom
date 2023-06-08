package main.java.shop.review;

public class ReviewDTO {
    private int review_num;
    private String member_id;
    private int product_num;
    private String review_content;
    private String review_regDate;

    public int getReview_num() {
        return review_num;
    }

    public void setReview_num(int review_num) {
        this.review_num = review_num;
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

    public String getReview_content() {
        return review_content;
    }

    public void setReview_content(String review_content) {
        this.review_content = review_content;
    }

    public String getReview_regDate() {
        return review_regDate;
    }

    public void setReview_regDate(String review_regDate) {
        this.review_regDate = review_regDate;
    }
}
