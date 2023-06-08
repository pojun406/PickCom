package main.java.shop.order;

import main.java.common.CommandMap;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service("orderService")
public class OrderServiceImp implements OrderService {
    @Resource(name="orderDAO")
    private OrderDAO orderDAO;

    // 주문페이지에서 필요한 정보 검색
    @Override
    public Map<String, Object> orderMemberInfo(CommandMap commandMap, HttpServletRequest request) throws Exception{
        return (Map<String, Object>) orderDAO.orderMemberInfo(commandMap);
    }

    // 주문 테이블 입력
    @Override
    public void insertOrder(CommandMap commandMap, HttpServletRequest request) throws Exception{
        orderDAO.insertOrder(commandMap);
    }

    // 입력한 주문 번호 검색
    @Override
    public Map<String, Object> selectOrder(CommandMap commandMap, HttpServletRequest request) throws Exception{
        return (Map<String, Object>) orderDAO.selectOrder(commandMap);
    }

    /*public void orderModify(CommandMap commandMap, HttpServletRequest request) throws Exception{orderDao.orderModify(commandMap);}*/

    @Override
    public void updateMember(CommandMap commandMap, HttpServletRequest request) throws Exception {
        orderDAO.updateMember(commandMap);

    }
}
