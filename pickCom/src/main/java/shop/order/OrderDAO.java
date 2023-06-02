package shop.order;

import common.AbstractDAO;
import common.CommandMap;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("orderDAO")
public class OrderDAO extends AbstractDAO {
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

    /*public void orderModify(CommandMap commandMap) throws Exception{update("order.orderModify", commandMap.getMap());}*/

    public void updateMember(CommandMap commandMap) {
        update("join.updateMemberTotal", commandMap.getMap());

        Map<String,Object> map = (Map<String, Object>) selectOne("join.selectMemberTotal", commandMap.getMap());

        int MEMBER_TOTAL = Integer.parseInt(map.get("MEMBER_TOTAL").toString());
        String MEMBER_GRADE = "";

        if(MEMBER_TOTAL<200000) {
            MEMBER_GRADE = "NORMAL";
        }else if(MEMBER_TOTAL>=200000 && MEMBER_TOTAL<500000) {
            MEMBER_GRADE = "GOLD";
        }else {
            MEMBER_GRADE = "VIP";
        }
        Map<String,Object> mg = new HashMap<String, Object>();
        mg.put("MEMBER_GRADE", MEMBER_GRADE);
        mg.put("MEMBER_NO", commandMap.get("MEMBER_NO"));
        update("join.updateMemberGrade", mg);
    }

}
