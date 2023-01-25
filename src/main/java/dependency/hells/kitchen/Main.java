package dependency.hells.kitchen;

import dependency.hells.kitchen.domain.*;
import dependency.hells.kitchen.infrastructure.ClassResourcesRecipeRepository;
import dependency.hells.kitchen.infrastructure.MagicFridge;
import dependency.hells.kitchen.infrastructure.RecipeParser;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        if(args.length < 1) {
            printHelp();
            return;
        }

        ApplicationService appSvc = getApplicationService();

        if(args[0].equals("cook")) {
            appSvc.cook(args);
        } else {
            printHelp();
        }
    }

    private static ApplicationService getApplicationService() {
        RecipeParser recipeParser = new RecipeParser();
        RecipeRepository recipeRepo = new ClassResourcesRecipeRepository(recipeParser);

        KitchenTable kitchenTable = new KitchenTable();
        Oven oven = new Oven();
        oven.heat();
        MagicFridge fridge = new MagicFridge();
        Press press = new Press();
        Cook cook = new Cook(kitchenTable, oven, fridge, press);

        return new ApplicationService(recipeRepo, cook);
    }


    private static void printHelp() {
        System.out.println("You can choose between the following commands:");
        System.out.println("  * cook");
    }
}
