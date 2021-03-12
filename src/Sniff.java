import java.util.Objects;

public class Sniff extends Character {
    Item item;
    // Реализация Singleton
    private static Sniff sniff;

    private Sniff() {
        super("Sniff", TypeOfPerson.COLLECTOR);
    }

    public static Sniff get() {
        if (sniff == null)
            sniff = new Sniff();
        return sniff;
    }

    public void wearItem(Item item) {
        this.item = item;
        Size size;
        if (item.getSize() >= 6) {
            size = Size.RIGHT_FOR_HIM;
        } else
            size = Size.NOT_RIGHT_FOR_HIM;

        System.out.println(getName() + " wears " + item.getLongname() + " it is " + size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sniff sniff = (Sniff) o;
        return item.equals(sniff.item) && getType() == sniff.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), item, getType());
    }
}