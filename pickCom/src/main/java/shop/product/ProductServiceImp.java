package main.java.shop.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("productService")
public class ProductServiceImp implements ProductService{
    @Resource(name="productDAO")
    private ProductDAO productDAO;

    // 히트상품 리스트
    @Override
    public List<Map<String, Object>> hitProductList(Map<String, Object> map) throws Exception{
        return productDAO.hitProductList(map);
    }

    // 추천상품 리스트
    @Override
    public List<Map<String, Object>> recommendedProductList(Map<String, Object> map) throws Exception{
        return productDAO.recommendedProductList(map);
    }

    // 최신상품 리스트
    @Override
    public List<Map<String, Object>> newProductList(Map<String, Object> map) throws Exception{
        return productDAO.newProductList(map);
    }

    // 인기상품 리스트
    @Override
    public List<Map<String, Object>> bestProductList(Map<String, Object> map) throws Exception{
        return productDAO.bestProductList(map);
    }

    // 할인상품 리스트
    @Override
    public List<Map<String, Object>> saleProductList(Map<String, Object> map) throws Exception{
        return productDAO.saleProductList(map);
    }

    // 카테고리별 제품 리스트
    @Override
    public List<Map<String, Object>> cateProductList(Map<String, Object> map, String keyword) throws Exception{
        map.put("keyword", keyword);
        return productDAO.cateProductList(map);
    }

    // 메인에서 검색
    @Override
    public List<Map<String, Object>> mainSearch(Map<String, Object> map, String keyword) throws Exception{
        map.put("keyword", keyword);
        return productDAO.mainSearch(map);
    }

    // 장바구니 번호 검색
    @Override
    public List<Map<String, Object>> selectCartNo(Map<String, Object> map) throws Exception{
        return productDAO.selectCartNo(map);
    }

    // 제품 디테일 데이터 가져옴
    @Override
    public Map<String, Object> selectProductDetail(Map<String, Object> map, HttpServletRequest request) throws Exception{
        System.out.println("map1111111="+map.get("IDX"));


        if(map.get("IDX").getClass().getName().equals("java.lang.String")){  // PK값이 일반 스트링으로 왔을 때
            Map<String,Object> map1 = new HashMap<String,Object>();
            map1.put("IDX", map.get("IDX"));
            productDAO.productHitCnt(map1); //조회수
        }else { // PK값이 배열로 넘어 왔을 때
            String[] Product_No = (String[])map.get("IDX");
            map.put("IDX", Product_No[0]);
            productDAO.productHitCnt(map); //조회수
        }

        System.out.println("map="+map);
        Map<String, Object> resultMap = productDAO.selectProductDetail(map);

        return resultMap;
    }

    // 제품속성 디테일
    public Map<String, Object> selectProductAtt(Map<String, Object> map) throws Exception{
        Map<String, Object> resultMap = productDAO.selectProductAtt(map);

        return resultMap;
    }

    // 제품 qna리스트 가져옴
    @Override
    public List<Map<String, Object>> selectProductQna(Map<String, Object> map) throws Exception{
        return productDAO.selectProductQna(map);
    }

    // 제품 등록
    @Override
    public void insertProduct(Map<String, Object> map, HttpServletRequest request) throws Exception{
        // 내용에서 이미지 긁어오기 시작
        String img_templist=""; // 이미지 링크를 ','를 기준으로 냐열해둠, 아직 사용 안함
        String img_list[] = {}; // ','로 구분된 문자열을 나눠서 배열에 담음
        String img_thumb=""; // img_list의 첫번째 경로를 저장함
        String img_thumb1=""; // img_list의 첫번째 경로를 저장함
        String comp_text=" src=\"/stu/file/"; // 반복문 안에 temp와 비교될 텍스느. equals(" src=\"")는 안되길래 따로 빼둠
        System.out.println("comp_text="+comp_text);
        String content = (String)map.get("Product_CONTENT"); // 저장된 본문을 불러옴
        int imgCount = 0;  // src="D:\sts4File\     
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
            map.put("Product_THUMBNAIL", img_thumb); // 썸네일 값 전달
        } else { // img_list가 비어이을 경우
            map.put("Product_THUMBNAIL",""); // 이미지 없음
        }
        // 내용에서 이미지 긁어오기 끝

        // 상품정보 등록 쿼리 실행
        productDAO.insertProduct(map);
        System.out.println("****12132* " + map);

        // 상품 등록 시 IDX 값을 받아 이미지 테이블에 값들을 담아줌
        if(img_templist!="") { // img_list가 비어있지 않을 경우			
            img_list = img_templist.split(",");
            String img_result = "";
            for(int i = 0 ; i<imgCount; i++) {
                //map.put("UPLOAD_SAVE_NAME", img_list[i]);
                img_result += img_list[i] + ",";
                System.out.println("이미지 리졸트="+img_result);
                System.out.println((i+1)+"번째업로드 ==========================================");
                //productDAO.insertFile(map); 
                System.out.println((i+1)+"번째업로드끝=========================================");
            }
            System.out.println("img_result!!!!!!!= "+img_result);

            map.put("UPLOAD_SAVE_NAME", img_result.substring(0, img_result.length()-1));
            productDAO.insertFile(map);
        }

        map.get("Product_ATT_SIZE");
        map.get("Product_ATT_COLOR");
        System.out.println("선택한 컬러="+map.get("Product_ATT_COLOR"));
        System.out.println("선택한 사이즈="+map.get("Product_ATT_SIZE"));

        String Size = map.get("Product_ATT_SIZE").toString();
        String Color = map.get("Product_ATT_COLOR").toString();
        String ColorList[] = Color.split(",");
        String SizeList[] = Size.split(",");
        System.out.println(ColorList.length);

        for(int i=0; i <=ColorList.length-1; i++) { // 상품등록시 선택한 사이즈 컬러 하나하나씩 상품옵션테이블에 등록해줌
            for(int j=0; j<=SizeList.length-1; j++) {
                System.out.println("배열입니당="+ColorList[i]+","+SizeList[j]);
                map.put("Product_ATT_SIZE", SizeList[j]);
                map.put("Product_ATT_COLOR", ColorList[i]);
                productDAO.productAttribute(map);

            }
        }

        System.out.println("옵션값="+map);
    }

    // 제품 수정
    @Override
    public void updateProduct(Map<String, Object> map, HttpServletRequest request) throws Exception{
        productDAO.updateProduct(map); // 상품테이블 업데이트
        productDAO.attributeDelete(map); // 기존 상품에 있는 옵션들 삭제
        productDAO.deleteFile(map);  // 이미지 삭제
        // 내용에서 이미지 긁어오기 시작
        String img_templist=""; // 이미지 링크를 ','를 기준으로 냐열해둠, 아직 사용 안함
        String img_list[] = {}; // ','로 구분된 문자열을 나눠서 배열에 담음
        String img_thumb=""; // img_list의 첫번째 경로를 저장함
        String comp_text=" src=\"/stu/file/"; // 반복문 안에 temp와 비교될 텍스느. equals(" src=\"")는 안되길래 따로 빼둠
        System.out.println("comp_text="+comp_text);
        String content = (String)map.get("Product_CONTENT"); // 저장된 본문을 불러옴
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
            map.put("Product_THUMBNAIL", img_thumb); // 썸네일 값 전달
        } else { // img_list가 비어이을 경우
            map.put("Product_THUMBNAIL",""); // 이미지 없음
        }
        // 내용에서 이미지 긁어오기 끝

        // 상품정보 등록 쿼리 실행
        productDAO.updateProductThumbnail(map); // 상품테이블에 있는 썸네일 사진 업데이트 
        System.out.println("****12132* " + map);

        // 상품 등록 시 IDX 값을 받아 이미지 테이블에 값들을 담아줌
        if(img_templist!="") { // img_list가 비어있지 않을 경우			
            img_list = img_templist.split(",");
            String img_result = "";
            for(int i = 0 ; i<imgCount; i++) {
                //map.put("UPLOAD_SAVE_NAME", img_list[i]);
                img_result += img_list[i] + ",";
                System.out.println("이미지 리졸트="+img_result);
                System.out.println((i+1)+"번째업로드 ==========================================");
                //productDAO.insertFile(map); 
                System.out.println((i+1)+"번째업로드끝=========================================");
            }
            System.out.println("img_result!!!!!!!= "+img_result);

            map.put("UPLOAD_SAVE_NAME", img_result.substring(0, img_result.length()-1));
            productDAO.insertFile(map);
        }

        map.get("Product_ATT_SIZE");
        map.get("Product_ATT_COLOR");
        System.out.println("선택한 컬러="+map.get("Product_ATT_COLOR"));
        System.out.println("선택한 사이즈="+map.get("Product_ATT_SIZE"));

        String Size = map.get("Product_ATT_SIZE").toString();
        String Color = map.get("Product_ATT_COLOR").toString();
        String ColorList[] = Color.split(",");
        String SizeList[] = Size.split(",");
        System.out.println(ColorList.length);

        for(int i=0; i <=ColorList.length-1; i++) {
            for(int j=0; j<=SizeList.length-1; j++) {
                System.out.println("배열입니당="+ColorList[i]+","+SizeList[j]);
                map.put("Product_ATT_SIZE", SizeList[j]);
                map.put("Product_ATT_COLOR", ColorList[i]);
                productDAO.productAttribute(map); // 상품 수정시 선택한 컬러 사이즈 다시 등록

            }
        }
    }

    // 제품 삭제
    @Override
    public void deleteProduct(Map<String, Object> map, HttpServletRequest request) throws Exception{
        productDAO.deleteProduct(map);
    }


    /*
     * public void deleteFileList(Map<String, Object> map) throws Exception {
     * update("Product.deleteFileList", map); }
     */

    /*
     * public void updateFile(Map<String, Object> map) throws Exception { // 파일수정
     * update("Product.updateFile", map); }
     */

    // 제품 좋아요 등록
    @Override
    public void insertProductLike(Map<String, Object> map) throws Exception{
        productDAO.insertProductLike(map);
    }

    // 제품 좋아요 삭제
    @Override
    public void deleteProductLike(Map<String, Object> map) throws Exception{
        productDAO.deleteProductLike(map);
    }

    // 제품 장바구니 등록
    @Override
    public void insertCart(Map<String, Object> map, HttpServletRequest request) throws Exception{
        map.remove("resultList");
        System.out.println("서비스맵"+map);
        productDAO.insertCart(map);
    }

    // 제품 pk번호 가져오기
    @Override
    public Map<String, Object> selectProductAttNum(Map<String, Object> map) throws Exception{
        return productDAO.selectProductAttNum(map);
    }

    // 제품 qna 등록
    @Override
    public void insertProductQna(Map<String, Object> map, HttpServletRequest request) throws Exception{
        productDAO.insertProductQna(map);
    }

    // 제품 qna 수정
    @Override
    public void updateProductQna(Map<String, Object> map, HttpServletRequest request) throws Exception{
        productDAO.updateProductQna(map);
    }



    // 구매 리스트 초기화
    @Override
    public void gumeListDelete(Map<String, Object> map) throws Exception{
        productDAO.gumeListDelete(map);
    }
}
