package shop.cart;

public interface CartDAO {
    // 장바구니 리스트 출력
    public void cartList(CartDTO c);
    // 장바구니 수량 변경
    public void cartModify();
    // 장바구니 상품 삭제
    public void cartDelete(CartDTO c);
    // 장바구니 초기화
    public void cartClear();
}
