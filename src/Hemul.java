public class Hemul extends Character {
    public Hemul(String name, TypeOfPerson typeOfPerson) {
        super(name, typeOfPerson);
    }

    public void dig(String variety, String flower) {
        System.out.println(getName() + " digs out " + variety + flower);
    }

}
