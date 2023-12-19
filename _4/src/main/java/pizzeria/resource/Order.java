package pizzeria.resource;

import org.springframework.stereotype.Service;

@Service
public class Order {

    public void addToCart(final ShoppingCart cart, final Pizza pizza) {
        cart.addPizza(pizza);
    }

    public void placeOrder(final ShoppingCart cart) {
        if (cart.getPizzas().isEmpty()) {
            System.out.println("Empty list.");
            return;
        }

        System.out.println("Order get:");

        for (final Pizza pizza : cart.getPizzas()) {
            System.out.println("- " + pizza.getName() + " topings: " + pizza.getToppings());
        }

        System.out.println("Order comfirmed!");
        cart.clear();
    }

    public void confirmOrder(final ShoppingCart cart) {
        System.out.println("Order confirmed:");
        for (final Pizza pizza : cart.getPizzas()) {
            System.out.println("Pizza ID: " + pizza.getId() + ", Name: " + pizza.getName());
        }
        final double totalPrice = calculateTotalPrice(cart);
        System.out.println("Total Price: " + totalPrice);
    }

    private double calculateTotalPrice(final ShoppingCart cart) {
        double totalPrice = 0.0;
        for (final Pizza pizza : cart.getPizzas()) {
            totalPrice += pizza.getPrice();
        }
        return totalPrice;
    }
}
