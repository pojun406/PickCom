package shop.review;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ReviewService {
    // 리뷰 작성
    public void insertProductReview(Map<String, Object> map, HttpServletRequest request) throws Exception;

    // 리뷰 삭제
    public void deleteReview(Map<String, Object> map) throws Exception;

    // 제품 리뷰리스트 가져옴
    public List<Map<String, Object>> selectReviewList(Map<String, Object> map) throws Exception;

    // 제품 리뷰 수정
    public void updateReview(Map<String, Object> map, HttpServletRequest request) throws Exception;
}
