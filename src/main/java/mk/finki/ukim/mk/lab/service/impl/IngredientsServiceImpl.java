package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import mk.finki.ukim.mk.lab.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class IngredientsServiceImpl implements IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    @Override
    public Ingredient create(Ingredient ingredient) {
        return ingredientsRepository.save(ingredient);
    }

    @Override
    public Ingredient edit(String id, Ingredient ingredient) {
        Ingredient ingredientToEdit = ingredientsRepository.findById(id).get();
        ingredientToEdit.setAmount(ingredient.getAmount());
        ingredientToEdit.setSpicy(ingredient.isSpicy());
        ingredientToEdit.setVeggie(ingredient.isVeggie());
        return ingredientsRepository.save(ingredientToEdit);
    }

    @Override
    public void delete(String id) {
        Ingredient ingredientToDelete = ingredientsRepository.findById(id).get();
        ingredientsRepository.delete(ingredientToDelete);
    }

    @Override
    public Page<Ingredient> getPage(Pageable pageable) {
        return ingredientsRepository.findAll(pageable);
    }

    @Override
    public Ingredient getIngredient(String id) {
        return ingredientsRepository.findById(id).get();
    }
}
