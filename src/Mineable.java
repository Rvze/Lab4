interface Mineable {
    default boolean isMineable(){
        return true;
    }
    default boolean isNotMineable(){
        return true;
    }
}
