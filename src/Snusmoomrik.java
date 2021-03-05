public class Snusmoomrik extends Character {
    private String hat;

    public Snusmoomrik(String hat, String name) {
        super(name, TypeOfPerson.COMMON);
        this.hat = hat;
    }

    public void flashed(String name, String hat) {
        System.out.println(getName() + " " + getHat() + " flashed");
    }

    public String getHat() {
        return hat;
    }

}
