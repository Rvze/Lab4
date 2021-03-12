public class Line extends Item implements Mineable {
    private final int size;
    public Line(String name) {
        this.name = name;
        this.size = (int) (Math.random()*10);
        this.setMineable(true);
    }

    @Override
    public int getSize() {
        return size;
    }
}