import java.util.Objects;

public class Sea {
    private String name;
    public Sea(String name){
        this.name=name;
    }

    public void destruct(Item item, DegreeOfBroke degreeOfBroke){
        item.setBroken(true);
        item.changeLongname(degreeOfBroke);
        System.out.println(getName()+' '+degreeOfBroke.toString()+' '+item.getName());
    }
    public String getName() {
        return name;
    }
    public int hashCode(){
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sea sea = (Sea) o;
        return Objects.equals(name, sea.name);
    }
}
