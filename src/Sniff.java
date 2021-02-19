import java.lang.reflect.Type;
import java.util.Objects;

public class Sniff extends Character {
    Item item;
    private final int sizeChance = (int) (Math.random() * 10);
    private TypeOfPerson typeOfPerson;

    public Sniff(String name, TypeOfPerson typeOfPerson) {
        super(name, typeOfPerson);
        typeOfPerson = TypeOfPerson.COLLECTOR;
    }

    public void wearItem(Item item) {
        this.item = item;
        Size size;
        if (sizeChance >= 6) {
            size = Size.RIGHT_FOR_HIM;
        } else
            size = Size.NOT_RIGHT_FOR_HIM;

        System.out.println(getName() + " wears " + item.getLongname() + " it is " + size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sniff sniff = (Sniff) o;
        return sizeChance == sniff.sizeChance &&
                item.equals(sniff.item) &&
                typeOfPerson == sniff.typeOfPerson;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), item, sizeChance, typeOfPerson);
    }
}
