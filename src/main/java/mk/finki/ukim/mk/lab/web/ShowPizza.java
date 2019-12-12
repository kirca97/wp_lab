package mk.finki.ukim.mk.lab.web;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzaService;
import mk.finki.ukim.mk.lab.service.impl.PizzaServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "pizzas-web-servlet", urlPatterns = "/*")
public class ShowPizza extends HttpServlet {
    private final PizzaServiceImpl pizzaService;
    private final SpringTemplateEngine springTemplateEngine;

    public ShowPizza(PizzaServiceImpl pizzaService, SpringTemplateEngine springTemplateEngine) {
        this.pizzaService = pizzaService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Pizza> pizzas = pizzaService.listPizzas();
        String pizzaName = req.getParameter("pizzaName");
        String pizzaDesc = req.getParameter("pizzaDesc");
//        pizzas.add(new Pizza(pizzaName, pizzaDesc));
        pizzaService.savePizza(new Pizza(pizzaName, pizzaDesc));
        resp.sendRedirect("/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getSession().invalidate();
        if(req.getHeader("please")!=null) {
        resp.getWriter().println("pls pls"); }
        resp.setContentType("text/html; charset=UTF-8");
        WebContext context = new WebContext(req, resp, req.getServletContext());
        List<Pizza> pizzas = pizzaService.listPizzas();
        context.setVariable("pizzas", pizzas);
        springTemplateEngine.process("listPizzas.html", context, resp.getWriter());
    }


}
