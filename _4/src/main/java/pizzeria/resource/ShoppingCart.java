package pizzeria.resource;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Pizza> pizzas = new ArrayList<>();

    public void addPizza(final Pizza pizza) {
        pizzas.add(pizza);
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void clear() {
        pizzas.clear();
    }


}
