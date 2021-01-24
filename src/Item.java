public class Item{
    protected String name;
    private String longname;
    private boolean isBroken=false;
    private boolean isMineable=false;
    public Item(String name) {
        this.name = name;
        this.longname=name;
    }
    public Item() {

    }

    public String getName() {
        return name;
    }

    public boolean isMineable() {
        return isMineable;
    }

    public void setMineable(boolean mineable) {
        isMineable = mineable;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public void changeLongname(DegreeOfBroke degreeOfBroke){
        this.longname=degreeOfBroke.toString()+' '+longname;
    }

    public String getLongname() {
        return longname;
    }
}
