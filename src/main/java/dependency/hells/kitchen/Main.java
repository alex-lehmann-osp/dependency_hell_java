package dependency.hells.kitchen;

import dependency.hells.kitchen.domain.Oven;

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

        Oven.getInstance().heat();
        ApplicationService appSvc = new ApplicationService();
        if(args[0].equals("cook")) {
            appSvc.cook(args);
        } else {
            printHelp();
        }
    }


    private static void printHelp() {
        System.out.println("You can choose between the following commands:");
        System.out.println("  * cook");
    }
}
