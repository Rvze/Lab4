import java.lang.reflect.Type;

public class Sniff extends Character {
    Item item;
    private Size size;
    private final int sizeChance = (int) (Math.random() * 10);
    private TypeOfPerson typeOfPerson;

    public Sniff(String name, TypeOfPerson typeOfPerson) {
        super(name, typeOfPerson);
        typeOfPerson = TypeOfPerson.COLLECTOR;
    }

    public void wearItem(Item item) {
        this.item = item;
        if (sizeChance >= 6) {
            size = Size.RIGHT_FOR_HIM;
        } else
            size = Size.NOT_RIGHT_FOR_HIM;

        System.out.println(getName() + " wears " + item.getLongname() + " it is " +size);
    }

}
