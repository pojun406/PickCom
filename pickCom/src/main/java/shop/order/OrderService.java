package shop.order;

import common.CommandMap;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface OrderService {
    // 주문페이지에서 필요한 정보 검색
    public Map<String, Object> orderMemberInfo(CommandMap commandMap, HttpServletRequest request) throws Exception;

    // 주문 테이블 입력
    public void insertOrder(CommandMap commandMap, HttpServletRequest request) throws Exception;

    // 입력한 주문 번호 검색
    public Map<String, Object> selectOrder(CommandMap commandMap, HttpServletRequest request) throws Exception;

    /*public void orderModify(CommandMap commandMap, HttpServletRequest request) throws Exception;*/

    public void updateMember(CommandMap commandMap, HttpServletRequest request) throws Exception;
}
