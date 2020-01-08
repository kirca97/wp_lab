package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.model.Pizza;
import mk.finki.ukim.mk.lab.model.exceptions.NotFoundException;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import mk.finki.ukim.mk.lab.repository.PizzaRepository;
import mk.finki.ukim.mk.lab.service.PizzasService;
import mk.finki.ukim.mk.lab.web.PizzaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzasServiceImpl implements PizzasService {

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Pizza save(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setName(pizzaDTO.name);
        pizza.setDescription(pizzaDTO.description);
        pizza.setVeggie(pizzaDTO.veggie);

        List<Ingredient> ingredients = new ArrayList<>();
        if (pizzaDTO.ingredientIds != null) {
            for (String ingredientId : pizzaDTO.ingredientIds) {
                Ingredient ingredient = ingredientsRepository.findById(ingredientId).get();
                ingredients.add(ingredient);
            }
        }
        pizza.setIngredients(ingredients);

        return pizzaRepository.save(pizza);

//        return pizzaRepository.save(pizza);
    }

    @Override
    public Pizza edit(String id, PizzaDTO pizzaDTO) {
        Pizza toUpdate = pizzaRepository.findById(id).get();
        toUpdate.setDescription(pizzaDTO.description);
        toUpdate.setVeggie(pizzaDTO.veggie);

        List<Ingredient> ingredients = new ArrayList<>();
        if (pizzaDTO.ingredientIds != null) {
            for (String ingredientId : pizzaDTO.ingredientIds) {
                Ingredient ingredient = ingredientsRepository.findById(ingredientId).get();
                ingredients.add(ingredient);
            }
        }
        toUpdate.setIngredients(ingredients);

        return pizzaRepository.save(toUpdate);
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
    public Pizza getPizza(String id) throws Exception {

        return pizzaRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
