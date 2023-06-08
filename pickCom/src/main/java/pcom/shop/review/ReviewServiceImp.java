package pcom.shop.review;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("reviewService")
public class ReviewServiceImp implements ReviewService {
    @Resource(name="reviewDAO")
    private ReviewDAO reviewDAO;

    // 제품 리뷰 등록
    @Override
    public void insertProductReview(Map<String, Object> map, HttpServletRequest request) throws Exception{
        // 내용에서 이미지 긁어오기 시작
        String img_templist=""; // 이미지 링크를 ','를 기준으로 냐열해둠, 아직 사용 안함
        String img_list[] = {}; // ','로 구분된 문자열을 나눠서 배열에 담음
        String img_thumb=""; // img_list의 첫번째 경로를 저장함
        String comp_text=" src=\"/stu/file/"; // 반복문 안에 temp와 비교될 텍스느. equals(" src=\"")는 안되길래 따로 빼둠
        System.out.println("comp_text="+comp_text);
        String content = (String)map.get("REVIEW_CONTENT"); // 저장된 본문을 불러옴
        int imgCount = 0;  // src="D:\sts4File\      " src=\"/nnS/file/";
        for(int i = 0; i+16 < content.length(); i++) { // 텍스트 비교
            String temp=""; // 잘라진 텍스트가 임시로 들어갈 공간

            temp = content.substring(i,i+16); // content에서 잘라낸 텍스트를 temp에 저장
            if(temp.equals(comp_text)) { // temp와 temp_text가 같을 경우
                img_templist += content.substring(i+16, i+52)+","; // img_list에 잘라진 텍스트 추가 및 구분을 위한 쉼표 삽입
                System.out.println("img_templist = " + img_templist);
                imgCount++;
            }
            System.out.println("temp =" + temp);
        }
        if(img_templist!="") { // img_list가 비어있지 않을 경우
            img_templist = img_templist.substring(0, img_templist.length()-1); // 경로 뒤에 남는 쉼표 제거
            img_thumb = img_templist.substring(0, 36); // 이미지가 있을 경우 첫번째 경로를 썸네일로 저장해줌
            map.put("REVIEW_IMG", img_thumb); // 썸네일 값 전달
        } else { // img_list가 비어이을 경우
            map.put("REVIEW_IMG",""); // 이미지 없음
        }
        // 내용에서 이미지 긁어오기 끝

        // 상품정보 등록 쿼리 실행
        reviewDAO.insertProductReview(map); // 리뷰 등록
        System.out.println("****12132* " + map);

        // 상품 등록 시 IDX 값을 받아 이미지 테이블에 값들을 담아줌
        if(img_templist!="") { // img_list가 비어있지 않을 경우
            img_list = img_templist.split(",");
            for(int i = 0 ; i<imgCount; i++) {
                map.put("UPLOAD_SAVE_NAME", img_list[i]);
                System.out.println((i+1)+"번째업로드 ==========================================");
                reviewDAO.insertReviewFile(map); // 리뷰 이미지 등록
                System.out.println((i+1)+"번째업로드끝=========================================");
            }
        }
    }

    // 리뷰 삭제
    public void deleteReview(Map<String, Object> map) throws Exception{
        reviewDAO.deleteProductReview(map);
    }

    // 제품 리뷰리스트 가져옴
    @Override
    public List<Map<String, Object>> selectReviewList(Map<String, Object> map) throws Exception{
        return reviewDAO.selectReviewList(map);
    }

    // 제품 리뷰 수정
    @Override
    public void updateReview(Map<String, Object> map, HttpServletRequest request) throws Exception{
        reviewDAO.updateReview(map);
    }
}
