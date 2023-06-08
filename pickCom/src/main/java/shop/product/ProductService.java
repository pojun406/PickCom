package main.java.shop.product;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ProductService{
    // 히트상품 리스트
    public List<Map<String, Object>> hitProductList(Map<String, Object> map) throws Exception;

    // 추천상품 리스트
    public List<Map<String, Object>> recommendedProductList(Map<String, Object> map) throws Exception;

    // 최신상품 리스트
    public List<Map<String, Object>> newProductList(Map<String, Object> map) throws Exception;

    // 베스트상품 리스트
    public List<Map<String, Object>> bestProductList(Map<String, Object> map) throws Exception;

    // 할인상품 리스트
    public List<Map<String, Object>> saleProductList(Map<String, Object> map) throws Exception;

    // 카테고리별 제품 리스트
    public List<Map<String, Object>> cateProductList(Map<String, Object> map, String keyword) throws Exception;

    // 메인에서 검색
    public List<Map<String, Object>> mainSearch(Map<String, Object> map, String keyword) throws Exception;

    // 장바구니 번호 검색
    public List<Map<String, Object>> selectCartNo(Map<String, Object> map) throws Exception;

    // 제품 디테일 데이터 가져옴
    public Map<String, Object> selectProductDetail(Map<String, Object> map, HttpServletRequest request) throws Exception;

    // 제품속성 디테일
    public Map<String, Object> selectProductAtt(Map<String, Object> map) throws Exception;

    // 제품 qna리스트 가져옴
    public List<Map<String, Object>> selectProductQna(Map<String, Object> map) throws Exception;

    // 제품 등록
    public void insertProduct(Map<String, Object> map, HttpServletRequest request) throws Exception;

    // 제품 수정
    public void updateProduct(Map<String, Object> map, HttpServletRequest request) throws Exception;

    // 제품 삭제
    public void deleteProduct(Map<String, Object> map, HttpServletRequest request) throws Exception;


    /*
     * public void deleteFileList(Map<String, Object> map) throws Exception {
     * update("goods.deleteFileList", map); }
     */

    /*
     * public void updateFile(Map<String, Object> map) throws Exception { // 파일수정
     * update("goods.updateFile", map); }
     */

    // 제품 좋아요 등록
    public void insertProductLike(Map<String, Object> map) throws Exception;

    // 제품 좋아요 삭제
    public void deleteProductLike(Map<String, Object> map) throws Exception;

    // 제품 장바구니 등록
    public void insertCart(Map<String, Object> map, HttpServletRequest request) throws Exception;

    // 제품 pk번호 가져오기
    public Map<String, Object> selectProductAttNum(Map<String, Object> map) throws Exception;

    // 제품 qna 등록
    public void insertProductQna(Map<String, Object> map, HttpServletRequest request) throws Exception;

    // 제품 qna 수정
    public void updateProductQna(Map<String, Object> map, HttpServletRequest request) throws Exception;

    // 구매 리스트 초기화
    public void gumeListDelete(Map<String, Object> map) throws Exception;
}
