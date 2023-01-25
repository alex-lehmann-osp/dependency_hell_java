package dependency.hells.kitchen.domain;

public class Press {
    public Ingredient press(Ingredient ingredient, String newName) {
        System.out.println("pressing " + ingredient.name());
        return new Ingredient(newName, "pressed " + ingredient.content());
    }
}
