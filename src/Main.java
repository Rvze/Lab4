public class Main {
    public static void main(String[] args) {
        Item ship = new Item("ship");
        Sea sea = new Sea("Sea");
        sea.destruct(ship,DegreeOfBroke.DESTRUCTS);
        Item belt = new Item("belt");
        sea.destruct(belt, DegreeOfBroke.CORRODES);

        Item knife = new Item("knife");
        Snork snork = new Snork("Snork",TypeOfPerson.COLLECTOR);
        snork.toTakeKnife(knife);

        Line line = new Line("line");
        if(snork.mine(line)){
            snork.getGoldPieces(line);
        }
        for(int i=0;i<3;i++){
            if(snork.mine(line)){
                snork.getGoldPieces(line);
            }
        }
        snork.changeTypeOfPerson(TypeOfPerson.GOLDMINER);

        Sniff sniff = new Sniff("Sniff",TypeOfPerson.COLLECTOR);
        sniff.wearItem(belt,Size.RIGHT_FOR_HIM);

    }
}
// С замиранием сердца вошел Снорк в ущелье и осмотрелся.
//    Снорк ковырнул полоску ножом.
//        В лапу ему упала золотая крупинка.
//        Он отколупнул еще и еще.
//        Словно в горячке выковыривал он куски один другого крупнее и скоро забыл обо всем на свете, кроме вскрытых молнией золотых жил.
//        Теперь он уже был не какой-то там собиратель выброшенных морем обломков кораблекрушения, а настоящий золотоискатель!
//        Снифф же тем временем сделал совсем немудреное открытие, но и оно подарило ему немудреную, а все же радость:
//            он нашел пробковый пояс -- пояс, отчасти разъеденный морской водой, но пришедшийся ему как раз впору.
// Тут Снифф завидел вдали Муми-тролля. Тот стоял в воде и что-то тащил, дергал к себе изо всех сил. Явно что-то очень большое!
// А Муми-тролль уже вытащил на берег свою находку и покатил ее перед собой по песку.
// Snork, Sniff
