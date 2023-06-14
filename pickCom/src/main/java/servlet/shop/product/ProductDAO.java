package servlet.shop.product;

import servlet.common.DBConnPool;
import servlet.shop.product.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class ProductDAO {
    private DBConnPool db;

    // 검색 조건에 맞는 게시물의 개수를 반환합니다.
    public int selectCount(Map<String, Object> map) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int totalCount = 0;

        String query = "SELECT COUNT(*) FROM product";
        if (map.get("searchWord") != null) {
            query += " WHERE " + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%'";
        }
        try {
            db = new DBConnPool();
            con = db.getConnection();
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                totalCount = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("게시물 카운트 중 예외 발생");
            e.printStackTrace();
        } finally {
            db.close();
        }

        return totalCount;
    }

    // 히트상품 리스트 출력
    public List<ProductDTO> hitProductList(Map<String, Object> map) throws Exception{
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ProductDTO> product = new Vector<>();

        String query = "SELECT * FROM ( " + "    SELECT Tb.*, @rownum := @rownum + 1 AS rNum FROM ( "
                + "        SELECT * FROM product WHERE product_category=?";
        if (map.get("searchWord") != null) {
            query += " AND b." + map.get("searchField") + " LIKE '%" + map.get("searchWord") + "%'";
        }
        query += " ORDER BY product_num DESC   " +
                ") Tb, (SELECT @rownum := 0) R " + ") AS result " + "WHERE rNum BETWEEN ? AND ?";

        try {
            db = new DBConnPool();
            con = db.getConnection();
            System.out.println("query ==> " + query);
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, "Case");
            pstmt.setString(2, map.get("start").toString());
            pstmt.setString(3, map.get("end").toString());
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ProductDTO dto = new ProductDTO();

                dto.setProduct_num(rs.getInt("product_num"));
                dto.setProduct_img(rs.getString("product_img"));
                dto.setProduct_name(rs.getString("product_name"));
                dto.setProduct_description(rs.getString("product_description"));
                dto.setProduct_salePrice(rs.getInt("product_salePrice"));
                dto.setProduct_originalPrice(rs.getInt("product_originalPrice"));
                dto.setProduct_shippingFee(rs.getInt("product_shippingFee"));
                product.add(dto);
            }
        } catch (Exception e) {
            System.out.println("게시물 조회 중 예외 발생");
            e.printStackTrace();
        } finally {
            db.close();
        }
        return product;
    }

    // 상품 디테일
    public ProductDTO selectProductDetail(int idx) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ProductDTO dto = null;

        String query = "SELECT * FROM product WHERE product_num=?";
        try {
            db = new DBConnPool();
            con = db.getConnection();
            System.out.println("query ==> " + query);
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, idx);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                dto = new ProductDTO();

                dto.setProduct_num(rs.getInt("product_num"));
                dto.setProduct_img(rs.getString("product_img"));
                dto.setProduct_name(rs.getString("product_name"));
                dto.setProduct_category(rs.getString("product_category"));
                dto.setProduct_description(rs.getString("product_description"));
                dto.setProduct_salePrice(rs.getInt("product_salePrice"));
                dto.setProduct_originalPrice(rs.getInt("product_originalPrice"));
                dto.setProduct_shippingFee(rs.getInt("product_shippingFee"));
            }
        } catch (Exception e) {
            System.out.println("Exception[selectProductDetail] : " + e.getMessage());
        } finally {
            db.close();
        }
        return dto;
    }
}
