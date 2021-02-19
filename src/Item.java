import java.util.Objects;

public class Item {
    protected String name;
    private String longname;
    private boolean isBroken = false;
    private boolean isMineable = false;


    public Item(String name) {
        this.name = name;
        this.longname = name;
    }


    public int hp;

    public Item() {

    }

    public void setHp(int hp) {
        if (hp <= 0) {
            System.out.println("error hp can`t be less 0!");
        }
        this.hp = hp;
    }


    public void minusHp() {
        this.hp = hp - 1;
        if (hp == 0) {
            isBroken = true;
            System.out.println(getName() + " is broken");
        }

    }


    public int getHp() {
        return hp;
    }


    public String getName() {
        return name;
    }

    public boolean isMineable() {
        return isMineable;
    }

    public void setMineable(boolean mineable) {
        isMineable = mineable;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void changeLongname(DegreeOfBroke degreeOfBroke) {
        this.longname = degreeOfBroke.toString() + ' ' + longname;
    }

    public String getLongname() {
        return longname;
    }

    public int hashCode() {
        return Objects.hash(getLongname(), getName());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item;
        item = (Item) o;
        return isBroken == item.isBroken &&
                isMineable == item.isMineable &&
                Objects.equals(name, item.name) &&
                Objects.equals(longname, item.longname);
    }
}
