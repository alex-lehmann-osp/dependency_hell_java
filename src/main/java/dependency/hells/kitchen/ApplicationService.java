package dependency.hells.kitchen;

import dependency.hells.kitchen.domain.Cook;
import dependency.hells.kitchen.domain.Ingredient;
import dependency.hells.kitchen.domain.Recipe;
import dependency.hells.kitchen.domain.RecipeRepository;

public class ApplicationService {

    private RecipeRepository repo;
    private final Cook cook;

    public ApplicationService(RecipeRepository recipeRepository, Cook cook) {
        this.repo = recipeRepository;
        this.cook = cook;
    }

    public void cook(String[] args) {
        Recipe recipe = repo.getRecipe();
        Ingredient result = cook.prepareMeal(recipe);
        System.out.println();
        System.out.println("Prepared a " + result.name() + " consisting of " + result.content());
    }
}
