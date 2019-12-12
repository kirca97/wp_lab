package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Pizza;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PizzaRepositoryFromLab1 {
     private List<Pizza> allPizzas;

     public PizzaRepositoryFromLab1() {
         this.allPizzas = new ArrayList<>();
         this.allPizzas.add(new Pizza("Margherita", "tomato sauce, mozzarella"));
         this.allPizzas.add(new Pizza("Carbonara", "fresh cream, mozzarella, bacon"));
         this.allPizzas.add(new Pizza("Vegetariana", "tomato sauce, mushrooms"));
         this.allPizzas.add(new Pizza("Calzone", "Pizza dough, ricotta, pepperoni, pizza sauce, olive oil"));
         this.allPizzas.add(new Pizza("Cheddar", "cheddar, tomato sauce"));
         this.allPizzas.add(new Pizza("Capricciosa", "tomato sauce, cheese, ham"));
         this.allPizzas.add(new Pizza("Burger Classic", "barbecue sauce, beef, mozzarella, onions"));
         this.allPizzas.add(new Pizza("Burger Barbecue", "ham, chicken meat, onions"));
         this.allPizzas.add(new Pizza("Pepperoni", "tomato sauce, mozzarella, sausage"));
         this.allPizzas.add(new Pizza("Quattro Formaggi", "Taleggio, Mascarpone, Gorgonzola, Parmesan"));
     }

    public List<Pizza> getAllPizzas() {
        return allPizzas;
    }
}
