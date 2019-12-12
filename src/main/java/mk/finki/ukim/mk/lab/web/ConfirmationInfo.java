package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.service.impl.OrderServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="confirmation-web-servlet", urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {
    private SpringTemplateEngine springTemplateEngine;
    private OrderServiceImpl orderService;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine, OrderServiceImpl orderService) {
        this.springTemplateEngine = springTemplateEngine;
        this.orderService = orderService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Order order = (Order) session.getAttribute("order");
        String name = req.getParameter("clientName");
        String address = req.getParameter("clientAddress");
        WebContext context = new WebContext(req, resp, req.getServletContext());
        String ipAddress = req.getRemoteHost();
        String browser = req.getHeader("User-Agent");
        context.setVariable("pizza", order);
        context.setVariable("name", name);
        context.setVariable("address", address);
        context.setVariable("ipAddress", ipAddress);
        context.setVariable("browser", browser);
        orderService.placeOrder(order.getPizzaType(), order.getPizzaSize(), name, address);
        springTemplateEngine.process("confirmationInfo.html", context, resp.getWriter());
    }
}
