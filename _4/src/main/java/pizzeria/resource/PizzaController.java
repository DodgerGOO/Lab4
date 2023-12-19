package pizzeria.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

    private final PizzaRepository pizzaRepository;
    private final Order order;

    @Autowired
    public PizzaController(final PizzaRepository pizzaRepository, final Order order) {
        this.pizzaRepository = pizzaRepository;
        this.order = order;
    }

    @GetMapping("/get/{pizzaId}")
    public Pizza getPizza(@PathVariable final Long pizzaId) {
        return pizzaRepository.findById(pizzaId);
    }

    @PostMapping("/add-ingredient/{pizzaId}")
    public void addIngredientToPizza(@PathVariable final Long pizzaId, @RequestBody final String ingredient) {
        final Pizza pizza = pizzaRepository.findById(pizzaId);
        if (pizza != null) {
            pizza.getToppings().add(ingredient);
            pizzaRepository.save(pizza);
        }
    }

    @GetMapping("/get-all-pizzas")
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @PostMapping("/add-to-cart/{pizzaId}")
    public void addToCart(@PathVariable final Long pizzaId, @RequestBody final ShoppingCart cart) {
        final Pizza pizza = pizzaRepository.findById(pizzaId);
        order.addToCart(cart, pizza);
    }

    @PostMapping("/place-order")
    public void placeOrder(@RequestBody final ShoppingCart cart) {
        order.placeOrder(cart);
    }
    @PostMapping("/confirm-order")
    public void confirmOrder(@RequestBody final ShoppingCart cart) {
        order.confirmOrder(cart);
    }

}