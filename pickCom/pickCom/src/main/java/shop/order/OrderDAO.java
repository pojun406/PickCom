package shop.order;

import common.AbstractDao;
import common.CommandMap;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("orderDAO")
public class OrderDAO extends AbstractDao {
    // 주문페이지에서 필요한 정보 검색
    public Map<String, Object> orderMemberInfo(CommandMap commandMap) throws Exception{
        return (Map<String, Object>) selectOne("order.orderMemberInfo", commandMap.getMap());
    }

    // 주문 테이블 입력
    public void insertOrder(CommandMap commandMap) throws Exception{
        insert("order.insertOrder", commandMap.getMap());
    }

    // 입력한 주문 번호 검색
    public Map<String, Object> selectOrder(CommandMap commandMap) throws Exception{
        return (Map<String, Object>) selectOne("order.selectOrder", commandMap.getMap());
    }

    /*public void orderModify(CommandMap commandMap) throws Exception{update("order.orderModify", commandMap.getMap());}

    public void updateMember(CommandMap commandMap) throws Exception{}*/

}
