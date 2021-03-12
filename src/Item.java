import java.util.Objects;

public class Item {
    protected String name;
    private String longname;
    private boolean isBroken = false;
    private boolean isMineable = false;
    private int size;
    private int hp;

    public Item(String name, int size) throws SizeException {
        this.name = name;
        this.longname = name;
        if(size<=0){
            throw new SizeException("Size is can`t be less than 0");
        }
        else
            this.size=size;
    }

    public Item() {
    }

    public Item(String name) {
        this.name = name;
        size=(int)(Math.random()*10);
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

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void changeLongname(DegreeOfBroke degreeOfBroke) {
        this.longname = degreeOfBroke.toString() + ' ' + longname;
    }

    public String getLongname() {
        return longname;
    }

    public void setSize(int size) throws SizeException {
        if(size<=0)
            throw new SizeException();
        else
            this.size = size;
    }

    public int getSize() {
        return size;
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