package shop.cart;

import common.CommandMap;
import common.JDBConnection;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;
import java.util.Map;

@Service("cartService")
public class CartServiceImp implements CartService {
    @Resource(name="cartDAO")
    private CartDAO cartDAO;

    // 장바구니 리스트 출력
    @Override
    public List<Map<String, Object>> cartList(CommandMap commandMap) throws Exception {
        return (List<Map<String, Object>>) cartDAO.cartList(commandMap);
    }

    // 장바구니 수량 변경
    @Override
    public void cartModify(CommandMap commandMap, HttpServletRequest request) throws Exception{
        cartDAO.cartModify(commandMap);
    }

    // 장바구니 상품 삭제
    @Override
    public void cartDelete(CommandMap commandMap, HttpServletRequest request) throws Exception{
        cartDAO.cartDelete(commandMap);
    }

    // 장바구니 초기화
    @Override
    public void cartClear(CommandMap commandMap, HttpServletRequest request) throws Exception{
        cartDAO.cartClear(commandMap);
    }
}