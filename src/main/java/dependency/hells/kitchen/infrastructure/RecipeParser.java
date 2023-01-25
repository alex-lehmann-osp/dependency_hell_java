package dependency.hells.kitchen.infrastructure;

import dependency.hells.kitchen.domain.Action;
import dependency.hells.kitchen.domain.Recipe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecipeParser {
    private final static Pattern INGREDIENT_PATTERN = Pattern.compile("\\[(\\S+)\\]");

    public Recipe parse(List<String> recipeLines) {
        List<String> ingredients = new ArrayList();
        List<Action> actions = new ArrayList<Action>();
        String returnName = null;

        Iterator<String> linesIter = recipeLines.iterator();
        String line = linesIter.next().trim();

        while(line.startsWith("* ")) {
            ingredients.add(line.substring(2));
            line = linesIter.next();
        }

        if(ingredients.size() == 0) {
            throw new RuntimeException("recipe contains no ingredients");
        }

        while(!line.contains("=")) { line = linesIter.next(); }

        while(line.contains("=")) {
            actions.add(parseAction(line));
            line = linesIter.next();
        }

        while(!line.startsWith("return ")) { line = linesIter.next(); }
        returnName = line.substring(7);

        return new Recipe(ingredients, actions, returnName);
    }

    private Action parseAction(String actionString) {
        String[] split = actionString.split("=");
        String leftOperand = split[0].trim();
        String rightOperand = split[1].trim();
        List<String> ingredients = new ArrayList<>();
        Action.Type type = null;
        if(rightOperand.matches("\\[\\S+\\](?:\\s*\\+\\s*\\[\\S+\\])+")) {
            type = Action.Type.COMBINE;
            Matcher matcher = INGREDIENT_PATTERN.matcher(rightOperand);
            while (matcher.find()) {
                ingredients.add(matcher.group(1));
            }
        } else {
            for(String part : rightOperand.split("\\s+")) {
                Matcher matcher = INGREDIENT_PATTERN.matcher(part);
                if(matcher.matches()) {
                    ingredients.add(matcher.group(1));
                } else {
                    type = Action.Type.valueOf(part.toUpperCase(Locale.ROOT));
                }
            }
        }
        return new Action(type, leftOperand, ingredients);
    }
}
