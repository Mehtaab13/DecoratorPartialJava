public class MushroomDecorator extends ToppingDecorator{

    public MushroomDecorator(Pizza pizza) {
        super(pizza);
    }

    public String getDescription(){
        return pizza.getDescription() + ", mushrooms";
    }

    public double getCost(){
        return pizza.getCost() + 1.25;
    }
}
