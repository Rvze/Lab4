public class Sniff extends Character{
    Item item;
    public Sniff(String name, TypeOfPerson typeOfPerson) {
        super(name, typeOfPerson);
    }

    public void wearItem(Item item, Size size){
        this.item=item;
        System.out.println(getName()+" wears "+item.getLongname()+" it is "+size.toString());
    }

}
