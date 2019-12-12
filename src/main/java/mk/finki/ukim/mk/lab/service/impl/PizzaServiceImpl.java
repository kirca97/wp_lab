package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public void savePizza(Pizza pizza) {
        pizzaRepository.getAllPizzas().add(pizza);
    }

    @Override
    public List<Pizza> listPizzas() {
        return pizzaRepository.getAllPizzas();
    }
}
