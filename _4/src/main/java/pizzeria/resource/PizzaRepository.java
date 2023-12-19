package pizzeria.resource;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PizzaRepository implements CrudeRepository<Pizza, Long> {

    private final Map<Long, Pizza> pizzaDatabase = new HashMap<>();

    @Override
    public Pizza save(final Pizza pizza) {
        if (pizza.getId() == null) {
            pizza.setId(generateId());
        }
        pizzaDatabase.put(pizza.getId(), pizza);
        return pizza;
    }

    @Override
    public Pizza findById(final Long id) {
        return pizzaDatabase.get(id);
    }

    @Override
    public void deleteById(final Long id) {
        pizzaDatabase.remove(id);
    }


    private Long generateId() {
        return System.currentTimeMillis();
    }
    @Override
    public List<Pizza> findAll() {
        return new ArrayList<>(pizzaDatabase.values());
    }
}
