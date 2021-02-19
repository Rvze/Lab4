import java.util.Objects;

class Ore extends Item implements Mineable {
    private String name;
    private final double size; // size is the double in range of 0 to 10
    private static int ind = 1;
    private final int chance;
    Snork snork = new Snork("snork",TypeOfPerson.COLLECTOR);

    public String typeOfOre() {
        String type;
        if (this.chance >= 0 && this.chance < 3) {
            type = "sand";
        } else if (this.chance >= 3 && this.chance < 6) {
            type = "rock";
        } else if (this.chance >= 6 && this.chance < 9) {
            type = "iron";
        } else {
            type = "gold";
        }
        return type;
    }

    Ore() {
        this.name = "piece" + ind++ + " of " ;
        this.size = Math.random() * 10;
        this.chance = (int) (Math.random()*20);
        this.setMineable(true);

    }

    public String sizeToString() {
        StringBuilder res = new StringBuilder();
        if (this.size <= 0) {
            System.err.println("Size of " + this.name + " isn't correct!!!");
        } else if (this.size <= 2.5) {
            res.append("small");
        } else if (this.size <= 5.0) {
            res.append("medium");
        } else if (this.size <= 7.5) {
            res.append("large");
        } else if (this.size <= 10.0) {
            res.append("huge");
        } else {
            System.err.println("Size of " + this.name + " isn't correct!!!");
        }
        return res.toString();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ore ore = (Ore) o;
        return Double.compare(ore.size, size) == 0 &&
                chance == ore.chance &&
                name.equals(ore.name) &&
                snork.equals(ore.snork);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, size, chance, snork);
    }
}