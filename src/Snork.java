import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

public class Snork extends Character implements Mining {
    ArrayList<String> inventory = new ArrayList<String>(10);
    private Place place = Place.UNKNOWN;
    TypeOfPerson typeOfPerson;
    private Item knife;
    private int bpSpace;

    public Snork(String name, TypeOfPerson typeOfPerson) {
        super(name, typeOfPerson);
    }

    @Override
    public boolean mine(Item item) {
        return item.isMineable();
    }


    @Override
    public Item getOre(Item item, Item use, Snork bp) {
        if (item.getHp() > 0 && use.getHp() > 0 && bp.getBpSpace() > 0) {
            if (item.isMineable() && Math.random() > 0.1d) {
                Ore ore = new Ore();
                System.out.println(getName() + " gets " + ore.sizeToString() + ' ' + ore.getName() + ore.typeOfOre());

                item.minusHp();  //knife hp
                use.minusHp();  // line hp


                bp.BackPackSpace(); //bpSpace

                inventory.add(ore.sizeToString() + ' ' + ore.getName() + ore.typeOfOre());   //инвентарь

                return ore;
            } else return item;
        } else return item;
    }

    public boolean crumbledUp() {
        if (Math.random() * 10 >= 5) {

            System.out.println("Snork crumbled up to the top of the cliff and looked around");
            return true;
        } else
            return false;
    }

    public void see(String isle, Sea sea, Sniff sniff, Item item, Snusmoomrik hat) {

        while (!crumbledUp()) {
            System.out.println(isle + " swung open in front of " + getName() + " and seemed like a bouquet of flowers floating to " + sea.condition(true) + " " + sea.getName());
            if(Math.random()*10>=3){
                sniff.wearItem(item);
            }
            hat.flashed();
        }
            System.out.println("Snork slipped and fell ");
    }

    public void BackPackSpace() {
        this.bpSpace = bpSpace - 1;
        if (bpSpace == 0) {
            System.out.println("bag is full:(");
        }

    }

    public void setBpSpace(int bpSpace) {
        if (bpSpace <= 0) {
            System.out.println("error bpSpace can`t be less 0!");
        }
        this.bpSpace = bpSpace;
    }

    public void removeBpSpace() {
        Ore ore = new Ore();
        var s = ore.sizeToString() + ' ' + ore.getName() + ore.typeOfOre();
        inventory.remove(s);
        System.out.println("Snork has a:");
        for (String a : inventory) {
            System.out.println(a);
        }
    }

    public int getBpSpace() {
        return bpSpace;
    }


    public void snorkInventory() {
        System.out.println("Snork has a:");
        for (var s : inventory) {

            System.out.println(s);
        }

    }

    public void toTakeKnife(Item knife) {
        this.knife = knife;
    }

    public Item getKnife() {
        return knife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(getName(), ((Snork) o).getName()) && Objects.equals(getType(), ((Snork) o).getType()) && Objects.equals(getKnife(), ((Snork) o).getKnife()) && Objects.equals(getBpSpace(), ((Snork) o).getBpSpace()) && Objects.equals(getClass(), ((Snork) o).getClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), inventory, knife, bpSpace);
    }
}
