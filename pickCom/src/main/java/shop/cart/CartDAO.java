package shop.cart;

import common.AbstractDAO;
import common.CommandMap;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("cartDAO")
public class CartDAO extends AbstractDAO {
    // 장바구니 리스트 출력
    public List<Map<String, Object>> cartList(CommandMap commandMap) throws Exception {
        return (List<Map<String,Object>>) selectList("cart.cartList", commandMap.getMap());
    }

    // 장바구니 수량 변경
    public void cartModify(CommandMap commandMap) throws Exception{
        update("cart.cartModify", commandMap.getMap());
    }

    // 장바구니 상품 삭제
    public void cartDelete(CommandMap commandMap) throws Exception{
        delete("cart.cartDelete", commandMap.getMap());
    }

    // 장바구니 초기화
    public void cartClear(CommandMap commandMap) throws Exception{
        delete("cart.cartClear", commandMap.getMap());
    }
}
