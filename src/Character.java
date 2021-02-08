import java.util.Objects;

public abstract class Character {
    private final String name;
    private TypeOfPerson type;

    public Character(String name, TypeOfPerson typeOfPerson) {
        this.name = name;
        this.type = typeOfPerson;
    }

    public String getName() {
        return name;
    }

    void changeTypeOfPerson(TypeOfPerson type) {
        TypeOfPerson prevType = TypeOfPerson.COLLECTOR;
        this.type = type;
        System.out.println(this.getName() + "changes type from " + prevType.toString() + " " + "to " + this.type.toString() + ".");
    }

    public TypeOfPerson getType() {
        return type;
    }
    public int hashCode(){
        return Objects.hash(getName(),getType());
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Character && Objects.equals(getType(),getName());
    }

}