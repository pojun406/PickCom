package shop.cart;

import common.JDBConnection;
import java.sql.*;

public class CartDAOImp extends JDBConnection implements CartDAO {
    // 장바구니 리스트 출력
    public void cartList(CartDTO c){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM cart";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    };
    // 장바구니 수량 변경
    public void cartModify(){
        Connection con = null;
        PreparedStatement ps = null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="UPDATE cart SET cart_quantity = ? where member_id = ? and product_num = ?";
            ps=con.prepareStatement(sql);
//            ps.setInt(1, );
//            ps.setString(2, );
//            ps.setString(3, );
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps);
        }
    };
    // 장바구니 상품 삭제
    public void cartDelete(CartDTO c){
        Connection con=null;
        PreparedStatement ps=null;
        try {
            con=DriverManager.getConnection(url + database, user, pwd);
            String sql="DELETE FROM cart WHERE cart_num="+c.getCart_num();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps);
        }
    };
    // 장바구니 초기화
    public void cartClear(){

    };
}
