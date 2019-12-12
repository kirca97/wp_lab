package mk.finki.ukim.mk.lab.service;


import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PizzasService {

    Pizza save(Pizza pizza);

    Pizza edit(String id, Pizza pizza);

    void delete(String id);

    List<Pizza> getAllPizzas();

    Pizza getPizza(String id);
}
