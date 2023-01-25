package dependency.hells.kitchen.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

class CookTest {

    @Test
    public void testUseOvenForBaking() {
        // ARRANGE
        Cook cook = new Cook();
        Action.Type actionType = Action.Type.BAKE;
        Recipe recipe = createTestRecipe(actionType);

        // ACT
        cook.prepareMeal(recipe);

        // ASSERT
    }

    private static Recipe createTestRecipe(Action.Type actionType) {
        Action action = new Action(actionType, "result", List.of("input"));
        return new Recipe(List.of("input"), List.of(action), "result");
    }
}
