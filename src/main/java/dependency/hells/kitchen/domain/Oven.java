package dependency.hells.kitchen.domain;

public class Oven {

    private boolean heated = false;

    public void heat() {
        heated = true;
    }

    public boolean isHeated() {
        return heated;
    }

    public Ingredient bake(Ingredient ingredient, String newName) {
        if(!heated) {
            throw new RuntimeException("cannot bake something in a cold oven");
        }
        System.out.println("baking " + ingredient.name());
        return new Ingredient(newName, "baked " + ingredient.content());
    }
}
