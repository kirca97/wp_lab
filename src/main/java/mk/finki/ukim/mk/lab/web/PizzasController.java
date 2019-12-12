package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.service.PizzasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzasController {


    @Autowired
    private PizzasService pizzasService;

    @PostMapping("/pizzas")
    public Pizza createPizza(@RequestBody Pizza pizza) {
        return pizzasService.save(pizza);
    }

    @PutMapping("/pizzas/{id}")
    public Pizza editPizza(@PathVariable String id, @RequestBody Pizza pizza) {
        return pizzasService.edit(id, pizza);
    }

    @DeleteMapping("/pizzas/{id}")
    public void deletePizza(@PathVariable String id) {
        pizzasService.delete(id);
    }

    @GetMapping("/pizzas")
    public List<Pizza> getPizzas() {
        return pizzasService.getAllPizzas();
    }

    @GetMapping("/pizzas/{id}")
    public Pizza getPizza(@PathVariable String id) {
        return pizzasService.getPizza(id);
    }
}
