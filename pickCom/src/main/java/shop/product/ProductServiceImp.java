package shop.product;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class ProductServiceImp implements ProductService{
    // 신제품 리스트 * 기능 추가 예정
    public List<Map<String, Object>> newProductList(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return (List<Map<String, Object>>) map;
    }

    // 베스트제품 리스트
    public List<Map<String, Object>> bestProductList(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return (List<Map<String, Object>>) map;
    }

    // 카테고리별 제품 리스트
    public List<Map<String, Object>> cateProductList(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return (List<Map<String, Object>>) map;
    }

    // 메인에서 검색
    public List<Map<String, Object>> mainSearch(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return (List<Map<String, Object>>) map;
    }

    // 장바구니 번호 검색
    public List<Map<String, Object>> selectCartNo(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return (List<Map<String, Object>>) map;
    }

    // 제품 디테일 데이터 가져옴
    public Map<String, Object> selectProductDetail(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return map;
    }

    // 제품 qna리스트 가져옴
    public List<Map<String, Object>> selectProductQna(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return (List<Map<String, Object>>) map;
    }

    // 제품 리뷰리스트 가져옴
    public List<Map<String, Object>> selectReviewList(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="SELECT * FROM product ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
        return (List<Map<String, Object>>) map;
    }

    // 제품 리뷰 수정
    public void updateReview(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="UPDATE review SET review_content=? WHERE review_num=?";
            ps=con.prepareStatement(sql);
//            ps.setString(1, );
//            ps.setInt(2, );
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 조회수 증가
    public void productHitCnt(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="UPDATE product SET product_hit=? WHERE product_num=?";
            ps=con.prepareStatement(sql);
//            ps.setString(1, );
//            ps.setInt(2, );
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 등록
    public void insertProduct(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 수정
    public void updateProduct(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="UPDATE product SET product_hit=? WHERE product_num=?";
            ps=con.prepareStatement(sql);
//            ps.setString(1, );
//            ps.setInt(2, );
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 삭제
    public void deleteProduct(Map<String, Object> map) {

    }

    // 제품 썸네일 이미지 수정
    public void updateProductThumbnail(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="UPDATE product SET product_hit=? WHERE product_num=?";
            ps=con.prepareStatement(sql);
//            ps.setString(1, );
//            ps.setInt(2, );
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 옵션 등록
    public void productAttribute(Map<String, Object> map) {

    }

    // 제품 옵션 삭제
    public void attributeDelete(Map<String, Object> map) {

    }

    // 제품 썸네일 이미지 등록
    public void insertProductThumbnail(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 이미지 등록
    public void insertFile(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 리뷰 이미지 등록
    public void insertReviewFile(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 이미지 삭제
    public void deleteFile(Map<String, Object> map) {

    }


    /*
     * public void deleteFileList(Map<String, Object> map) throws Exception {
     * update("goods.deleteFileList", map); }
     */

    /*
     * public void updateFile(Map<String, Object> map) throws Exception { // 파일수정
     * update("goods.updateFile", map); }
     */

    // 제품 좋아요 등록
    public void insertProductLike(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 좋아요 삭제
    public void deleteProductLike(Map<String, Object> map) {

    }

    // 제품 장바구니 등록
    public void insertCart(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 pk번호 가져오기
    public Map<String, Object> selectProductAttNum(Map<String, Object> map) {
        return map;
    }

    // 제품 qna 등록
    public void insertProductQna(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 qna 수정
    public void updateProductQna(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="UPDATE product SET product_hit=? WHERE product_num=?";
            ps=con.prepareStatement(sql);
//            ps.setString(1, );
//            ps.setInt(2, );
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 제품 리뷰 등록
    public void insertProductReview(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try{
            con= DriverManager.getConnection(url + database,user,pwd);
            String sql="INSERT INTO product VALUES () ";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {

            }
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(con, ps, rs);
        }
    }

    // 구매 리스트 초기화
    public void gumeListDelete(Map<String, Object> map) {

    }
}
