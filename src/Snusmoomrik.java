public class Snusmoomrik extends Character {
    private final Item hat;

    public Snusmoomrik(Item hat, String name) {
        super(name, TypeOfPerson.COMMON);
        this.hat = hat;
    }

    public void flashed() {
        System.out.println(getName() + "'s " + getHat().getName() + " flashed");
    }

    public Item getHat() {
        return hat;
    }
}