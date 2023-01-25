package dependency.hells.kitchen.domain;

import java.util.List;

public class Recipe {
    private final List<String> ingredients;
    private final List<Action> actions;
    private final String returnName;

    public Recipe(List<String> ingredients, List<Action> actions, String returnName) {
        this.ingredients = ingredients;
        this.actions = actions;
        this.returnName = returnName;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<Action> getActions() {
        return actions;
    }

    public String getReturnName() {
        return returnName;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "ingredients=" + ingredients +
                ", actions=" + actions +
                ", returnName='" + returnName + '\'' +
                '}';
    }
}
