package dependency.hells.kitchen.infrastructure;

import dependency.hells.kitchen.ApplicationService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class RecipeReader {
    public List<String> readRecipe() {
        try {
            return Files.readAllLines(Path.of(ApplicationService.class.getResource("apple_crumble.recipe").toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
