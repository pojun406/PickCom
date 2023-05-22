package shop.review;

import java.util.List;
import java.util.Map;

public interface ReviewDAO {
    // 리뷰 리스트 출력
    public List<Map<String, Object>> selectReviewList(Map<String, Object> map);

    // 리뷰 작성
    public void insertReview(Map<String, Object> map) ;

    // 리뷰 수정
    public void updateReview(Map<String, Object> map);

    // 리뷰 삭제
    public void deleteReview(Map<String, Object> map);
}
