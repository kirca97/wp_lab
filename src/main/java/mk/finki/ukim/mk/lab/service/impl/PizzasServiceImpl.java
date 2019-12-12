package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzasServiceImpl implements PizzasService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza edit(String id, Pizza pizza) {
        Pizza pizzaToEdit = pizzaRepository.findById(id).get();
        pizzaToEdit.setDescription(pizza.getDescription());
        pizzaToEdit.setIngredients(pizza.getIngredients());
        pizzaToEdit.setVeggie(pizza.isVeggie());

        return pizzaRepository.save(pizzaToEdit);
    }

    @Override
    public void delete(String id) {
        Pizza pizzaToDelete = pizzaRepository.findById(id).get();
        pizzaRepository.delete(pizzaToDelete);
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public Pizza getPizza(String id) {
        return pizzaRepository.findById(id).get();
    }
}
