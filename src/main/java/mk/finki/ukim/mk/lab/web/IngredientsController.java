package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.model.Ingredient;
import mk.finki.ukim.mk.lab.repository.IngredientsRepository;
import mk.finki.ukim.mk.lab.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @PostMapping("/ingredients")
    public Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        return ingredientsService.create(ingredient);
    }

    @PatchMapping("/ingredients/{id}")
    public Ingredient editIngredient(@PathVariable String id, @RequestBody Ingredient ingredient) {
        return ingredientsService.edit(id, ingredient);
    }

    @DeleteMapping("/ingredients/{id}")
    public void deleteIngredient(@PathVariable String id) {
        ingredientsService.delete(id);
    }

    @GetMapping("/ingredients")
    public Page<Ingredient> getIngredientsPage(@PageableDefault(value = 10, size = 5, page = 0,
    sort = {"name"}) Pageable pageable) {
        return ingredientsService.getPage(pageable);
    }

    @GetMapping("/ingredients/{id}")
    public Ingredient getIngredient(@PathVariable String id) {
        return ingredientsService.getIngredient(id);
    }
}
