import java.util.Scanner;
public class application {
    public static void main(String[] args) {
        System.out.println("Welcome to MyPizzaApp");
        Scanner myObj = new Scanner(System.in);
        System.out.println("What type of Pizza? (NewYork, Chicago, exit to exit)");
        String pizzaFactory = myObj.nextLine();
        PizzaStore pizzaStore = null;
        PizzaIngredientFactory pizzaIngredientFactory = null;
        if (pizzaFactory.equalsIgnoreCase("NewYork")) {
            pizzaStore = new NYPizzaStore();
            pizzaIngredientFactory = new NYPizzaIngredientFactory();
        } else if (pizzaFactory.equalsIgnoreCase("Chicago")) {
            pizzaStore = new ChicagoPizzaStore();
            pizzaIngredientFactory = new ChicagoPizzaIngredientFactory();
        } else {
            System.out.println("Invalid Pizza Factory option");
        }
        System.out.println("Choose Pizza Type (cheese, pepperoni, veggie, clam, exit to exit)");
        String pizzaType = myObj.nextLine();
        if ((pizzaType.equalsIgnoreCase("cheese")) || (pizzaType.equalsIgnoreCase("pepperoni")) || (pizzaType.equalsIgnoreCase("veggie")) || (pizzaType.equalsIgnoreCase("clam"))) {
            Pizza pizza = pizzaStore.orderPizza(pizzaType);
            System.out.println("---- " + pizza.getName() + " ----");
            System.out.println("Dough: " + pizzaIngredientFactory.createDough());
            System.out.println("Sauce: " + pizzaIngredientFactory.createSauce());
            System.out.println("Cheese: " + pizzaIngredientFactory.createCheese());
            if(pizzaType.equalsIgnoreCase("pepperoni")){
                System.out.println("Pepperoni: " + pizzaIngredientFactory.createPepperoni());
            }
            else if(pizzaType.equalsIgnoreCase("veggie")){
                Veggies[] veggies = pizzaIngredientFactory.createVeggies();
                StringBuilder veggiesString = new StringBuilder();
                for (Veggies veggie : veggies) {
                    veggiesString.append(veggie).append(", ");
                }
                if (veggiesString.length() > 0) {
                    veggiesString.setLength(veggiesString.length() - 2);
                }
                System.out.println("Veggies: " + veggiesString);
            }
            else if(pizzaType.equalsIgnoreCase("clam")){
                System.out.println("Clam: " + pizzaIngredientFactory.createClam());
            }
        } else {
            System.out.println("Invalid Pizza Type");
        }
    }
}
