package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.Pizza;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "pizzasize-web-servlet", urlPatterns = "/selectPizza.do")
public class SelectPizza extends HttpServlet {
    private SpringTemplateEngine springTemplateEngine;

    public SelectPizza(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String pizzaName = req.getParameter("pizza");
        if(pizzaName == null) {
//            resp.addHeader("please", "please");
            resp.sendRedirect("/");
//            context.setVariable("please", "asd");
//            springTemplateEngine.process("listPizzas.html", context, resp.getWriter());
        }
        else {
            Order order = new Order();
            order.setPizzaType(pizzaName);
            HttpSession session = req.getSession();
            session.setAttribute("order", order);
            resp.setContentType("text/html; charset=UTF-8");

            context.setVariable("pizza", pizzaName);
            springTemplateEngine.process("selectPizzaSize.html", context, resp.getWriter());
        }
        }


}
