package dependency.hells.kitchen;

import dependency.hells.kitchen.domain.Cook;
import dependency.hells.kitchen.domain.Ingredient;
import dependency.hells.kitchen.domain.Recipe;
import dependency.hells.kitchen.domain.RecipeRepository;
import dependency.hells.kitchen.infrastructure.ClassResourcesRecipeRepository;

public class ApplicationService {
    public void cook(String[] args) {
        RecipeRepository repo = new ClassResourcesRecipeRepository();
        Recipe recipe = repo.getRecipe();
        Cook cook = new Cook();
        Ingredient result = cook.prepareMeal(recipe);

        System.out.println();
        System.out.println("Prepared a " + result.name() + " consisting of " + result.content());
    }
}
