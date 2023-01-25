package dependency.hells.kitchen.domain;

import java.util.List;

public record Action(Action.Type type, String leftOperand, List<String> inputIngredients) {
    public static enum Type {
        COMBINE,
        PRESS,
        BAKE
    }

    @Override
    public String toString() {
        return "Action{" +
                "leftOperand='" + leftOperand + '\'' +
                ", type=" + type +
                ", inputIngredients=" + inputIngredients +
                '}';
    }
}
