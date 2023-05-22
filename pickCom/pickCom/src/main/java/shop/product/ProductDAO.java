package shop.product;

import common.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("productDAO")
public class ProductDAO extends AbstractDao {
    // 신제품 리스트
    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> newProductList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>) newProductList("product.newProductList", map);
    }

    // 베스트제품 리스트
    public List<Map<String, Object>> bestProductList(Map<String, Object> map){
        return (List<Map<String, Object>>) bestProductList("product.bestProductList", map);
    }

    // 카테고리별 제품 리스트
    public List<Map<String, Object>> cateProductList(Map<String, Object> map){
        return (List<Map<String, Object>>) selectPagingList("product.cateProductList", map);
    }

    // 메인에서 검색
    public List<Map<String, Object>> mainSearch(Map<String, Object> map);

    // 장바구니 번호 검색
    public List<Map<String, Object>> selectCartNo(Map<String, Object> map);

    // 제품 디테일 데이터 가져옴
    public Map<String, Object> selectProductDetail(Map<String, Object> map);

    // 제품 qna리스트 가져옴
    public List<Map<String, Object>> selectProductQna(Map<String, Object> map);

    // 제품 리뷰리스트 가져옴
    public List<Map<String, Object>> selectReviewList(Map<String, Object> map);

    // 제품 리뷰 수정
    public void updateReview(Map<String, Object> map);

    // 조회수 증가
    public void productHitCnt(Map<String, Object> map);

    // 제품 등록
    public void insertProduct(Map<String, Object> map);

    // 제품 수정
    public void updateProduct(Map<String, Object> map);

    // 제품 삭제
    public void deleteProduct(Map<String, Object> map);

    // 제품 썸네일 이미지 수정
    public void updateProductThumbnail(Map<String, Object> map);

    // 제품 옵션 등록
    public void goodsAttribute(Map<String, Object> map);

    // 제품 옵션 삭제
    public void attributeDelete(Map<String, Object> map);

    // 제품 썸네일 이미지 등록
    public void insertProductThumbnail(Map<String, Object> map);

    // 제품 이미지 등록
    public void insertFile(Map<String, Object> map);

    // 리뷰 이미지 등록
    public void insertReviewFile(Map<String, Object> map);

    // 제품 이미지 삭제
    public void deleteFile(Map<String, Object> map);

    /*
     * public void deleteFileList(Map<String, Object> map) throws Exception {
     * update("goods.deleteFileList", map); }
     */

    /*
     * public void updateFile(Map<String, Object> map) throws Exception { // 파일수정
     * update("goods.updateFile", map); }
     */

    // 제품 좋아요 등록
    public void insertProductLike(Map<String, Object> map);

    // 제품 좋아요 삭제
    public void deleteProductLike(Map<String, Object> map);

    // 제품 장바구니 등록
    public void insertCart(Map<String, Object> map);

    // 제품 pk번호 가져오기
    public Map<String, Object> selectProductAttNum(Map<String, Object> map);

    // 제품 qna 등록
    public void insertProductQna(Map<String, Object> map);

    // 제품 qna 수정
    public void updateProductQna(Map<String, Object> map);

    // 구매 리스트 초기화
    public void gumeListDelete(Map<String, Object> map);
}
