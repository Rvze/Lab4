class Ore extends Item implements Mineable {
    private String name;
    //private final int chance = (int) Math.random() * 12;
    private final double size; // size is the double in range of 0 to 10
    private static int ind = 1;
    Snork snork = new Snork("snork",TypeOfPerson.COLLECTOR);

    public String typeOfOre() {
        String type;
        if (snork.chance >= 0 && snork.chance < 3) {
            type = "sand";
        } else if (snork.chance >= 3 && snork.chance < 6) {
            type = "rock";
        } else if (snork.chance >= 6 && snork.chance < 9) {
            type = "iron";
        } else {
            type = "gold";
        }
        return type;
    }

    Ore() {
        this.name = "piece" + ind++ + " of " + typeOfOre();
        this.size = Math.random() * 10;
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


}