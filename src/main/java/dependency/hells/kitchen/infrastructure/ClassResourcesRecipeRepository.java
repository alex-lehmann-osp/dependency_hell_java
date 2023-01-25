package dependency.hells.kitchen.infrastructure;

import dependency.hells.kitchen.ApplicationService;
import dependency.hells.kitchen.domain.Recipe;
import dependency.hells.kitchen.domain.RecipeRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ClassResourcesRecipeRepository implements RecipeRepository {
    @Override
    public Recipe getRecipe() {
        List<String> lines = readRecipe();
        RecipeParser recipeParser = new RecipeParser();
        Recipe recipe = recipeParser.parse(lines);
        return recipe;
    }

    private static List<String> readRecipe() {
        try {
            return Files.readAllLines(Path.of(ApplicationService.class.getResource("apple_crumble.recipe").toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
