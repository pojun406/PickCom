package shop.review;

import common.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("reviewDAO")
public class ReviewDAO extends AbstractDAO {
    // 리뷰 이미지 등록
    public void insertReviewFile(Map<String, Object> map){
        insert("review.insertReviewFile", map);
    }

    // 제품 리뷰리스트 가져옴
    public List<Map<String, Object>> selectReviewList(Map<String, Object> map) throws Exception{
        return (List<Map<String, Object>>) selectPagingList("product.selectReviewList", map);
    }

    // 제품 리뷰 수정
    public void updateReview(Map<String, Object> map) throws Exception{
        update("review.updateReview", map);
    }

    // 제품 리뷰 등록
    public void insertProductReview(Map<String, Object> map) throws Exception {
        insert("review.insertProductReview", map);
    }

    // 제품 리뷰 삭제
    public void deleteProductReview(Map<String, Object> map) throws Exception {
        delete("review.deleteProductReview",map);
    }
}
