package mk.finki.ukim.mk.lab.service;


import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.web.PizzaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzasService {

    Pizza save(PizzaDTO pizzaDTO);

    Pizza edit(String id, PizzaDTO pizzaDTO);

    void delete(String id);

    List<Pizza> getAllPizzas();

    Pizza getPizza(String id) throws Exception;
}
