public interface Mining {
    boolean mine(Item item);
    Object getGoldPieces(Item item, Item use, Item bp);
}