package dependency.hells.kitchen.domain;

import dependency.hells.kitchen.infrastructure.MagicFridge;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cook {
    KitchenTable kitchenTable = new KitchenTable();

    public Ingredient prepareMeal(Recipe recipe) {
        Fridge fridge = new MagicFridge();
        Press press = new Press();

        // get initial ingredients
        for (String ingredientName : recipe.getIngredients()) {
            Ingredient ingredient = fridge.getIngredient(ingredientName);
            kitchenTable.put(ingredient);
        }
        System.out.println();

        // execute all actions in the recipe
        for (Action action : recipe.getActions()) {
            switch (action.type()) {
                case PRESS -> doAction(action, ingredient -> press.press(ingredient, action.leftOperand()));
                case BAKE -> doAction(action, ingredient -> Oven.getInstance().bake(ingredient, action.leftOperand()));
                case COMBINE -> doCombine(action);
                default -> throw new RuntimeException("unknown action type " + action.type());
            }
        }

        // return the final result
        return kitchenTable.get(recipe.getReturnName());
    }

    private void doCombine(Action action) {
        List<Ingredient> toBeCombined = new ArrayList<>();
        action.inputIngredients().forEach((name) -> toBeCombined.add(kitchenTable.get(name)));
        String combined = toBeCombined.stream().map(Ingredient::content).collect(Collectors.joining(" and ", "(", ")"));
        System.out.println("combining " + String.join(" and ", action.inputIngredients()) + " to " + action.leftOperand());
        kitchenTable.put(new Ingredient(action.leftOperand(), combined));
    }

    private void doAction(Action action, Function<Ingredient, Ingredient> function) {
        var ingredientName = action.inputIngredients().get(0);
        var ingredient = kitchenTable.get(ingredientName);
        var result = function.apply(ingredient);
        kitchenTable.put(result);
    }
}
