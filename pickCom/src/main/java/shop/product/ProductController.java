package shop.product;

import common.CommandMap;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import shop.cart.CartService;
import shop.order.OrderService;
import shop.review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class ProductController {
    @Resource(name="cartService")
    private CartService cartService;

    @Resource(name="orderService")
    private OrderService orderService;

    @Resource(name="productService")
    private ProductService productService;

    @Resource(name="reviewService")
    private ReviewService reviewService;

    // NewItem 리스트 출력
    @RequestMapping(value = "/shop/newProductList.do")
    public ModelAndView newProductList(CommandMap commandMap) throws Exception {

        ModelAndView mv = new ModelAndView("shop/productList");

        List<Map<String, Object>> list = productService.newProductList(commandMap.getMap());

        mv.addObject("list", list);
        mv.addObject("titleMain", "새상품");

        return mv;

    }

    // BEST 리스트 출력
    @RequestMapping(value = "/shop/bestProductList.do")
    public ModelAndView bestproductList(CommandMap commandMap) throws Exception {

        ModelAndView mv = new ModelAndView("shop/productList");

        List<Map<String, Object>> list = productService.bestProductList(commandMap.getMap());

        mv.addObject("list", list);
        mv.addObject("titleMain", "베스트");

        return mv;

    }

    // 카테고리별 상품리스트
    @RequestMapping(value = "/shop/productList/{cate}/{orderBy}.do")
    public ModelAndView openBoardList(@PathVariable String cate, @PathVariable String orderBy, CommandMap commandMap,
                                      @RequestParam(value = "keyword", defaultValue = "") String keyword, HttpServletRequest request)
            throws Exception {
        ModelAndView mv = new ModelAndView("/shop/cateProductList");
        commandMap.put("cate", cate);
        request.setAttribute("keyword", keyword);
        System.out.println("카테고리 검색확인=" + commandMap.getMap());
        System.out.println("검색키워드=" + keyword);
        mv.addObject("IDX", commandMap.getMap().get("IDX"));
        if ("NewItem".equals(orderBy)) { // 신상품순
            commandMap.put("orderBy", "PRODUCT_DATE");
            commandMap.put("orderSort", "DESC");
        } else if ("favorite".equals(orderBy)) { // 인기상품
            commandMap.put("orderBy", "PRODUCT_READCNT");
            commandMap.put("orderSort", "DESC");
        } else if ("low".equals(orderBy)) { // 낮은가격순
            commandMap.put("orderBy", "PRODUCT_SELL_PRICE");
            commandMap.put("orderSort", "ASC");
        } else if ("high".equals(orderBy)) { // 높은가격순
            commandMap.put("orderBy", "PRODUCT_SELL_PRICE");
            commandMap.put("orderSort", "DESC");
        }
        mv.addObject("category", cate);
        String filePath_temp = request.getContextPath() + "/file/";
        mv.addObject("path", filePath_temp);
        request.setAttribute("path", filePath_temp);
        return mv;
    }

    // 카테고리별 리스트 제이슨
    /*@RequestMapping(value = "/shop/cateProductList/{cate}/{orderBy}.do")
    public ModelAndView selectProductList(@PathVariable String cate, @PathVariable String orderBy, CommandMap commandMap,
                                        @RequestParam(value = "keyword", defaultValue = "") String keyword, HttpServletRequest request)
            throws Exception {

        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String, Object>> list = null;

        System.out.println("검색어: " + keyword);
        System.out.println("카테고리 = " + cate);
        System.out.println("카테고리 순서 =" + orderBy);

        // category
        commandMap.put("cate", cate);
        commandMap.put("orderBy", orderBy);

        // order by
        if ("NewItem".equals(orderBy)) { // 신상품순
            commandMap.put("orderBy", "PRODUCT_DATE");
            commandMap.put("orderSort", "DESC");
        } else if ("favorite".equals(orderBy)) { // 인기상품
            commandMap.put("orderBy", "PRODUCT_READCNT");
            commandMap.put("orderSort", "DESC");
        } else if ("low".equals(orderBy)) { // 낮은가격순
            commandMap.put("orderBy", "PRODUCT_SELL_PRICE");
            commandMap.put("orderSort", "ASC");
        } else if ("high".equals(orderBy)) { // 높은가격순
            commandMap.put("orderBy", "PRODUCT_SELL_PRICE");
            commandMap.put("orderSort", "DESC");
        }

        list = productService.cateProductList(commandMap.getMap(), keyword);

        //System.out.println("토탈카운트" + list.get(0).get("TOTAL_COUNT"));

        mv.addObject("list", list);
        if (list.size() > 0) {
            mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
        } else {
            mv.addObject("TOTAL", 0);
        }
        // mv.addObject("category", cate);

        return mv;
    }*/

    // 메인에서 검색시 리스트
    @RequestMapping(value = "/shop/openMainSearch.do")
    public ModelAndView openMainSearch(CommandMap commandMap,
                                       @RequestParam(value = "keyword", defaultValue = "") String keyword, HttpServletRequest request)
            throws Exception {
        ModelAndView mv = new ModelAndView("/shop/mainSearch");

        request.setAttribute("keyword", keyword);
        System.out.println("카테고리 검색확인=" + commandMap.getMap());
        System.out.println("검색키워드=" + keyword);
        mv.addObject("keyword");
        mv.addObject("IDX", commandMap.getMap().get("IDX"));

        String filePath_temp = request.getContextPath() + "/file/";
        mv.addObject("path", filePath_temp);
        request.setAttribute("path", filePath_temp);
        return mv;
    }

    // 메인에서 검색시 리스트 제이슨
    /*@RequestMapping(value = "/shop/mainSearch.do")
    public ModelAndView mainSearch(CommandMap commandMap,
                                   @RequestParam(value = "keyword", defaultValue = "") String keyword, HttpServletRequest request)
            throws Exception {

        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String, Object>> list = null;

        System.out.println("메인검색어: " + keyword);

        list = productService.mainSearch(commandMap.getMap(), keyword);

        System.out.println("토탈카운트" + list.get(0).get("TOTAL_COUNT"));

        list.get(0);
        if (list.size() != 0) {
            list.get(0).get("");
        }

        mv.addObject("list", list);
        if (list.size() > 0) {
            mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
        } else {
            mv.addObject("TOTAL", 0);
        }

        return mv;
    }*/

    // 상품디테일
    @RequestMapping(value = "/shop/productDetail.do")
    public ModelAndView productDetail(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("shop/productDetail");

        Map<String, Object> map = productService.selectProductDetail(commandMap.getMap(), request);
        System.out.println("IDX = " + commandMap.getMap());
        Map<String, Object> IDX = commandMap.getMap();
        System.out.println("map = " + map);

        mv.addObject("map", map.get("map")); // 상품의 PK값
        mv.addObject("list", map); // 상품 상세 정보입니다

        Map<String, Object> map1 = productService.selectProductAtt(commandMap.getMap());

        System.out.println("map1=" + map1);

        String Size = map1.get("product_ATT_SIZE").toString();
        String[] SizeList = Size.split(",");
        String Color = map1.get("product_ATT_COLOR").toString();
        String[] ColorList = Color.split(",");
        System.out.println("SizeList" + SizeList.toString());

        ArrayList<String> arrColor = new ArrayList<>();
        ArrayList<String> arrSize = new ArrayList<>();
        TreeSet<String> treeSet = new TreeSet<>();
        for (String data : SizeList) {
            if (!arrSize.contains(data))
                arrSize.add(data);
        }

        for (String data : ColorList) {
            if (!arrColor.contains(data))
                arrColor.add(data);
        }

        System.out.println("arrColor=" + arrColor);
        System.out.println("arrSize=" + arrSize);
        int ColorSize = arrColor.size();
        int Sizecnt = arrSize.size();

        mv.addObject("Color", arrColor); // 컬러 총 갯수
        mv.addObject("ColorSize", ColorSize); // 컬러 종류
        mv.addObject("Size", arrSize); // 사이즈 종류
        mv.addObject("Sizecnt", Sizecnt);
        return mv;

    }

    // 상품 디테일 제이슨
    /*@RequestMapping(value = "/shop/productDetailList.do")
    public ModelAndView productDetailList(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("jsonView");
        List<Map<String, Object>> list = null;

        list = productService.selectProductQna(commandMap.getMap()); // QNA 리스트

        System.out.println("디테일리스트=" + list);


        mv.addObject("list", list);

        if (list.size() > 0) {
            mv.addObject("TOTAL", list.get(0).get("TOTAL_COUNT"));
        } else {
            mv.addObject("TOTAL", 0);
        }

        List<Map<String, Object>> reviewList = reviewService.selectReviewList(commandMap.getMap()); // Review 리스트
        System.out.println("리뷰리스트=" + reviewList);

        mv.addObject("reviewList", reviewList);
        if (reviewList.size() > 0) {
            mv.addObject("TOTAL1", reviewList.get(0).get("TOTAL_COUNT1"));
        } else {
            mv.addObject("TOTAL1", 0);
        }

        return mv;
    }*/

    // 상품등록 폼
    @RequestMapping(value = "/shop/openProductWrite.do") // url
    public ModelAndView productWriteForm(CommandMap commandMap) throws Exception {

        ModelAndView mv = new ModelAndView("shop/productWrite");
        mv.addObject("type", "write");
        mv.addObject("title", "상품등록");
        return mv;

    }

    // 상품등록
    @RequestMapping(value = "/shop/productWrite.do", method = RequestMethod.POST)
    public ModelAndView productWrite(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("redirect:http:/stu/main.do");

        productService.insertProduct(commandMap.getMap(), request);
        System.out.println("글쓰기입니당" + commandMap.getMap());
        return mv;

    }

    // 상품삭제(숨김)
    @RequestMapping(value = "/shop/productDelete.do", method = RequestMethod.POST)
    public ModelAndView deleteProduct(CommandMap commandMap, HttpServletRequest request) throws Exception {

        ModelAndView mv = new ModelAndView("redirect:http:/stu/main.do");

        productService.deleteProduct(commandMap.getMap(), request);
        System.out.println("상품삭제(숨김) = " + commandMap.getMap());
        return mv;

    }

    /*// 상품디테일에서 좋아요 추가
    @RequestMapping(value = "/shop/productLike.do", method = RequestMethod.POST)
    public ModelAndView productLike(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/shop/productDetail.do");

        mv.addObject("IDX", commandMap.getMap().get("PRODUCT_NUM"));
        System.out.println("좋아요!!!!=" + commandMap.getMap().get("PRODUCT_NUM"));

        Object MEMBER_NUM = "";
        // 세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NUM = (Object) session.getAttribute("SESSION_NO"); // 세션 아이디
        // 기존 회원번호 데이터 삭제
        commandMap.remove("MEMBER_NUM");
        // 세션 값으로 적용
        commandMap.put("MEMBER_NUM", MEMBER_NUM);

        Map<String, Object> map = cartService.selectProductLike(commandMap, request);
        String like_cnt = String.valueOf(map.get("LIKE_CNT"));

        if (like_cnt.equals("0")) {
            cartService.insertProductLike(commandMap, request);
        }
        return mv;
    }*/

    // 상품디테일 장바구니 클릭시 팝업창
    @RequestMapping(value = "/shop/cartPopUp.do", method = RequestMethod.GET)
    public ModelAndView cartPopUp(CommandMap commandMap) throws Exception {
        ModelAndView mv = new ModelAndView("/shop/cartPopUp");

        return mv;
    }


    // 상품디테일에서 장바구니 추가
    @RequestMapping(value = "/shop/insertcart.do", method = RequestMethod.POST)
    public ModelAndView insertcart(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("redirect:/shop/productDetail.do");

        commandMap.remove("resultList");
        Object MEMBER_NUM = "";
        // 세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NUM = (Object) session.getAttribute("SESSION_NO");
        // 기존 회원번호 데이터 삭제
        commandMap.remove("MEMBER_NUM");
        // 세션 값으로 적용
        commandMap.put("MEMBER_NUM", MEMBER_NUM);

        //장바구니에 넣을 상품이 한개일때
        if (commandMap.get("ORDER_SIZE").getClass().getName().equals("java.lang.String")) {
            Map<String, Object> map = new HashMap<String, Object>();
            System.out.println("CommandMap1=" + commandMap.getMap());
            map.put("IDX", commandMap.get("IDX"));
            map.put("MEMBER_NUM", commandMap.get("MEMBER_NUM"));
            map.put("ORDER_SIZE", commandMap.get("ORDER_SIZE"));
            map.put("ORDER_COLOR", commandMap.get("ORDER_COLOR"));
            map.put("CART_PRODUCT_AMOUNT", commandMap.get("CART_PRODUCT_AMOUNT"));
            map.put("GUBUN", "0");
            productService.insertCart(map, request);
        } else { //장바구니에 넣을 상품이 두가지 이상일때(색상,사이즈가 다른)
            System.out.println("CommandMap2=" + commandMap.getMap());
            String[] Size = (String[]) commandMap.getMap().get("ORDER_SIZE");
            String[] Color = (String[]) commandMap.getMap().get("ORDER_COLOR");
            String[] Amount = (String[]) commandMap.getMap().get("CART_PRODUCT_AMOUNT");
            String[] product_NUM = (String[]) commandMap.getMap().get("IDX");
            System.out.println("다중 사이즈0=" + product_NUM[0]);
            System.out.println("다중 사이즈1=" + product_NUM[1]);
            Map<String, Object> map1 = new HashMap<String, Object>();

            for (int j = 0; j <= Size.length - 1; j++) {
                map1.put("ORDER_SIZE", Size[j]);
                map1.put("ORDER_COLOR", Color[j]);
                map1.put("CART_PRODUCT_AMOUNT", Amount[j]);
                map1.put("IDX", product_NUM[j]);
                map1.put("MEMBER_NUM", commandMap.get("MEMBER_NUM"));
                map1.put("GUBUN", "0");
                System.out.println("Size1111=" + Size[j]);
                productService.insertCart(map1, request);
            }
        }
        mv.addObject("IDX", commandMap.getMap().get("IDX"));
        return mv;
    }

    // 상품디테일에서 구매
    @RequestMapping(value = "/shop/productOrder.do", method = RequestMethod.POST)
    public ModelAndView productOrder(CommandMap commandMap, HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView("order/orderWrite");

        productService.gumeListDelete(commandMap.getMap());
        Object MEMBER_NUM = "";
        // 세션값 가져오기
        HttpSession session = request.getSession();
        MEMBER_NUM = (Object) session.getAttribute("SESSION_NO");
        // 기존 회원번호 데이터 삭제
        commandMap.remove("MEMBER_NUM");
        // 세션 값으로 적용
        commandMap.put("MEMBER_NUM", MEMBER_NUM);



        System.out.println("CommandMap=" + commandMap.getMap());
        commandMap.remove("resultList");

        if (commandMap.get("ORDER_SIZE").getClass().getName().equals("java.lang.String")) { // 일반 스트링으로 왔을 때
            Map<String, Object> map = new HashMap<String, Object>();                        // 구매시 장바구니에 등록
            System.out.println("CommandMap1=" + commandMap.getMap());

            map.put("IDX", commandMap.get("IDX"));
            map.put("MEMBER_NUM", commandMap.get("MEMBER_NUM"));
            map.put("ORDER_SIZE", commandMap.get("ORDER_SIZE"));
            map.put("ORDER_COLOR", commandMap.get("ORDER_COLOR"));
            map.put("CART_PRODUCT_AMOUNT", commandMap.get("CART_PRODUCT_AMOUNT"));
            map.put("GUBUN", "1");
            productService.insertCart(map, request);
        } else { // 배열로 왔을 때
            System.out.println("CommandMap2=" + commandMap.getMap());
            String[] Size = (String[]) commandMap.getMap().get("ORDER_SIZE");
            String[] Color = (String[]) commandMap.getMap().get("ORDER_COLOR");
            String[] Amount = (String[]) commandMap.getMap().get("CART_PRODUCT_AMOUNT");
            String[] product_NUM = (String[]) commandMap.getMap().get("IDX");

            System.out.println("다중 사이즈0=" + product_NUM[0]);
            System.out.println("다중 사이즈1=" + product_NUM[1]);
            Map<String, Object> map1 = new HashMap<String, Object>();
            for (int j = 0; j <= Size.length - 1; j++) {
                map1.put("ORDER_SIZE", Size[j]);
                map1.put("ORDER_COLOR", Color[j]);
                map1.put("CART_PRODUCT_AMOUNT", Amount[j]);
                map1.put("IDX", product_NUM[j]);
                map1.put("MEMBER_NUM", commandMap.get("MEMBER_NUM"));
                map1.put("GUBUN", "1");
                System.out.println("Size1111=" + Size[j]);
                productService.insertCart(map1, request);
            }
        }

        List<Map<String, Object>> list0 = productService.selectCartNo(commandMap.getMap()); // 장바구니 PK값 가져오기
        System.out.println("장바구니넘버111111" + list0.get(0).get("CART_NUM"));

        commandMap.remove("SELECT_CART_NUM");
        commandMap.put("SELECT_CART_NUM", list0.get(0).get("CART_NUM"));

        List<Map<String, Object>> list = cartService.cartSelectList(commandMap, request); // 장바구니에 있는 정보들

        Map<String, Object> map = orderService.orderMemberInfo(commandMap, request); // 회원의 정보

        mv.addObject("list", list);
        mv.addObject("map", map);
        System.out.println(list);
        System.out.println(map);
        return mv;
    }

    @RequestMapping(value = "/shop/productModifyForm.do")
    public ModelAndView productModifyForm(CommandMap commandMap, HttpServletRequest request) throws Exception { // 상품 수정폼(관리자)
        ModelAndView mv = new ModelAndView("shop/productWrite");

        Map<String, Object> map = productService.selectProductDetail(commandMap.getMap(), request);
        System.out.println("수정폼1=" + commandMap.getMap());
        System.out.println("수정폼2=" + map);
        mv.addObject("map", map);
        mv.addObject("list", map.get("list"));
        mv.addObject("type", "modify");
        mv.addObject("title", "수정하기");
        System.out.println("수정폼3=" + map);
        return mv;
    }

    @RequestMapping(value = "/shop/productModify.do")
    public ModelAndView productModify(CommandMap commandMap, HttpServletRequest request) throws Exception { // 상품 수정완료(관리자)
        ModelAndView mv = new ModelAndView("redirect:/main.do");

        productService.updateProduct(commandMap.getMap(), request);
        System.out.println("업데이트Map=" + commandMap);
        System.out.println("업데이트Map=" + commandMap.getMap());
        mv.addObject("IDX", commandMap.getMap().get("IDX"));

        return mv;
    }

    @RequestMapping(value = "/shop/openQnaForm.do")
    public ModelAndView openProductQna(CommandMap commandMap) throws Exception { // QNA 등록 폼

        ModelAndView mv = new ModelAndView("shop/productQnaForm");
        mv.addObject("IDX", commandMap.get("IDX"));
        return mv;

    }

    @RequestMapping(value = "/shop/productQnaInsert.do", method = RequestMethod.POST) // QNA 등록
    public ModelAndView insertProductQna(CommandMap commandMap, HttpServletRequest request) throws Exception { // QNA 등록완료

        ModelAndView mv = new ModelAndView("redirect:/shop/productDetail.do");

        productService.insertProductQna(commandMap.getMap(), request);
        System.out.println("상품문의작성=" + commandMap.getMap());
        mv.addObject("IDX", commandMap.get("IDX"));

        return mv;

    }

    @RequestMapping(value = "/shop/updateProductQna.do", method = RequestMethod.POST)
    public ModelAndView updateProductQna(CommandMap commandMap, HttpServletRequest request) throws Exception { // QNA 답변 수정 및 등록

        ModelAndView mv = new ModelAndView("redirect:/shop/productDetail.do"); // 보낼 url
        System.out.println("상품 QNA 답변등록=" + commandMap.getMap());
        productService.updateProductQna(commandMap.getMap(), request);

        mv.addObject("PRODUCT_QNA_NUM", commandMap.get("PRODUCT_QNA_NUM"));

        return mv;

    }

    @RequestMapping(value = "/shop/openReviewForm.do")
    public ModelAndView reviewForm(CommandMap commandMap) throws Exception { // Review 등록 폼

        ModelAndView mv = new ModelAndView("shop/reviewForm");
        System.out.println("111111111리뷰폼11111111=" + commandMap.getMap());
        mv.addObject("IDX", commandMap.get("IDX"));

        mv.addObject("title", "REVIEW 등록");

        return mv;

    }

    @RequestMapping(value = "/shop/insertReview.do", method = RequestMethod.POST)
    public ModelAndView insertProductReview(CommandMap commandMap, HttpServletRequest request) throws Exception { // Review 등록완료

        ModelAndView mv = new ModelAndView("redirect:/shop/productDetail.do"); // 보낼 url
        System.out.println("리뷰등록=" + commandMap.getMap());
        reviewService.insertProductReview(commandMap.getMap(), request);

        mv.addObject("IDX", commandMap.get("IDX"));

        return mv;

    }


    @RequestMapping(value = "/shop/openReviewUpdateForm.do")
    public ModelAndView reviewUpdateForm(CommandMap commandMap) throws Exception { // Review 수정

        ModelAndView mv = new ModelAndView("shop/reviewForm");
        System.out.println("111111111리뷰폼11111111=" + commandMap.getMap());
        mv.addObject("IDX", commandMap.get("IDX"));

        mv.addObject("title", "REVIEW 수정");
        mv.addObject("type", "modify");
        return mv;

    }

    @RequestMapping(value = "/shop/updateReview.do", method = RequestMethod.POST)
    public ModelAndView updateReview(CommandMap commandMap, HttpServletRequest request) throws Exception { // Review 수정완료

        ModelAndView mv = new ModelAndView("redirect:/shop/productDetail.do"); // 보낼 url
        System.out.println("리뷰등록=" + commandMap.getMap());
        reviewService.updateReview(commandMap.getMap(), request);

        mv.addObject("IDX", commandMap.get("IDX"));

        return mv;

    }
}
