import java.util.ArrayList;

public class Snork extends Character implements Mining {
    ArrayList<String> inventory = new ArrayList<String>();
    private Item knife;
    private Ore[] ores = new Ore[6];
    private int oreCount = 0;
    int chance = (int) Math.random() * 12;

    public Snork(String name, TypeOfPerson typeOfPerson) {
        super(name, typeOfPerson);
    }

    @Override
    public boolean mine(Item item) {
        return item.isMineable();
    }


    @Override
    public Item getGoldPieces(Item item, Item use, Item bp) {
        if (item.getHp() > 0 && use.getHp() > 0 && bp.getBpSpace() > 0) {
            if (item.isMineable() && Math.random() > 0.1d) {
                Ore ore = new Ore();
                System.out.println(getName() + " gets " + ore.sizeToString() + ' ' + ore.getName());

                item.minusHp();  //knife hp
                use.minusHp();  // line hp


                bp.BackPackSpace(); //bpSpace

                inventory.add(ore.sizeToString() + ' ' + ore.getName());   //инвентарь
                addOre(ore);

                return ore;
            } else return item;
        } else return item;
    }

    public void snorkInventory() {
        System.out.println("Snork has a:");
        for (String s : inventory) {

            System.out.println(s);
        }

    }

    public void toTakeKnife(Item knife) {
        this.knife = knife;
    }

    public Item getKnife() {
        return knife;
    }


    public void addOre(Ore ore) {
        if (oreCount < Math.random() * 4) {
            this.ores[oreCount] = ore;
            oreCount++;
        } else System.out.println("bag is full:(");
    }

}
