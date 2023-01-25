package dependency.hells.kitchen.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Acts as a kind of working memory for a {@link Cook}.
 */
public class KitchenTable {
    private final Map<String, Ingredient> ingredientMap = new HashMap<>();

    void put(Ingredient ingredient) {
        ingredientMap.put(ingredient.name(), ingredient);
    }

    Ingredient get(String ingredientName) {
        return ingredientMap.remove(ingredientName);
    }
}
