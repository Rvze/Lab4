public interface Mining {
    boolean mine(Item item);
    Object getOre(Item item, Item use, Snork bp);
}