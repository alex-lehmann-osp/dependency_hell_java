package dependency.hells.kitchen.infrastructure;

import dependency.hells.kitchen.domain.Fridge;
import dependency.hells.kitchen.domain.Ingredient;

public class MagicFridge implements Fridge {
    @Override
    public Ingredient getIngredient(String name) {
        System.out.println("got " + name + " out of the magic fridge");
        return new Ingredient(name, name);
    }
}
