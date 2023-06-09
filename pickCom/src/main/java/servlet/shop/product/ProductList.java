package servlet.shop.product;

import lombok.SneakyThrows;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/shop/productList.do")
public class ProductList extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        ProductDAO dao = new ProductDAO();
        Map<String, Object> map = new HashMap<String, Object>();
        String searchField = req.getParameter("searchField");
        String searchWord = req.getParameter("searchWord");
        if (searchWord != null) {
            // 쿼리스트링으로 전달받은 매개변수 중 검색어가 있다면 map에 저장
            map.put("searchField", searchField);
            map.put("searchWord", searchWord);
        }
        int totalCount = dao.selectCount(map);  // 게시물 개수

        /* 페이지 처리 start */
        ServletContext application = getServletContext();
        int pageSize = 10;
        int blockPage = 5;

        // 현재 페이지 확인
        int pageNum = 1;  // 기본값
        String pageTemp = req.getParameter("pageNum");
        if (pageTemp != null && !pageTemp.equals(""))
            pageNum = Integer.parseInt(pageTemp); // 요청받은 페이지로 수정

        // 목록에 출력할 게시물 범위 계산
        int start = (pageNum - 1) * pageSize + 1;  // 첫 게시물 번호
        int end = pageNum * pageSize; // 마지막 게시물 번호
        map.put("start", start);
        map.put("end", end);
        /* 페이지 처리 end */

        List<ProductDTO> boardLists = dao.hitProductList(map);  // 게시물 목록 받기

        // 뷰에 전달할 매개변수 추가
        String pagingImg = Paging.pagingStr(totalCount, pageSize,
                blockPage, pageNum, "../shop/productList.do");  // 바로가기 영역 HTML 문자열
        map.put("pagingImg", pagingImg);
        map.put("totalCount", totalCount);
        map.put("pageSize", pageSize);
        map.put("pageNum", pageNum);

        // 전달할 데이터를 request 영역에 저장 후 List.jsp로 포워드
        req.setAttribute("list", boardLists);
        req.setAttribute("map", map);
        req.setAttribute("cate", "전체");
        req.getRequestDispatcher("/views/shop/productList.jsp").forward(req, resp);
    }
}