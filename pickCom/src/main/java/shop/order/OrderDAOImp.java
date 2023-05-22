package shop.order;

import common.JDBConnection;
import java.util.List;
import java.util.Map;

public class OrderDAOImp extends JDBConnection implements OrderDAO {
    // 주문페이지에서 필요한 정보 검색
    public void orderMemberInfo(){

    };

    // 회원이 보유한 쿠폰 검색
    public List<Map<String, Object>> memberCoupon(Map<String, Object> map){
        return (List<Map<String, Object>>) map;
    };

    // 주문 테이블 입력
    public void insertOrder(){

    };

    // 입력한 주문 번호 검색
    public Map<String, Object> selectOrder(Map<String, Object> map){
        return map;
    };

    /*public void orderModify();

    public void updateMember();*/
}
