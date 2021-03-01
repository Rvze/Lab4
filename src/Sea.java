import java.util.Objects;

public class Sea {
    private final String name;
    public int dmg = (int) (Math.random()*3);
    private boolean calm;

    public Sea(String name) {
        this.name = name;
    }

    public void destruct(Item item, DegreeOfBroke degreeOfBroke) {
        item.setBroken(true);
        item.changeLongname(degreeOfBroke);
        if (item.hp <= 0) {
            degreeOfBroke = DegreeOfBroke.DESTRUCTS;
        } else if (item.hp >= 2 && item.hp < 4) {
            degreeOfBroke = DegreeOfBroke.BATTERED;
        } else {
            degreeOfBroke = DegreeOfBroke.CORRODES;
        }
        System.out.println(degreeOfBroke +" " + item.getName());
    }
    public String condition(boolean calm){
        if (calm){
            return "calm";
        }
        return "not calm";
    }

    public String getName() {
        return name;
    }

    public int hashCode() {
        return Objects.hash(getName());
    }

    public void seaDamage(Item item) {
        item.setHp(item.hp - dmg);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sea sea = (Sea) o;
        return Objects.equals(name, sea.name);
    }
}
