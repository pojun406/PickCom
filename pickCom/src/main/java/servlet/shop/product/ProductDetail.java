package servlet.shop.product;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shop/productDetail.do")
public class ProductDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int idx = (int) req.getAttribute("idx");

        ProductDAO dao = new ProductDAO();
        ProductDTO dto = dao.selectProductDetail(idx);

        req.setAttribute("item", dto);
        req.getRequestDispatcher("/views/shop/productDetail.jsp").forward(req, resp);
    }
}
