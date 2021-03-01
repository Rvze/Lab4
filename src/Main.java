public class Main {
    public static void main(String[] args) {
        Snork snork = new Snork("Snork", TypeOfPerson.COLLECTOR);
        Sea sea = new Sea("Sea");
        Sniff sniff = new Sniff("Sniff", TypeOfPerson.COLLECTOR);
        Item belt = new Item("belt");
        snork.see("island", sea, sniff, belt);

        Item ship = new Item("ship");
        ship.setHp((int) (Math.random() * 10));

        sea.destruct(ship, DegreeOfBroke.DESTRUCTS);

        belt.setHp((int) (Math.random() * 10));
        sea.destruct(belt, DegreeOfBroke.CORRODES);

        Item knife = new Item("knife");
        knife.setHp((int) (Math.random() * 4 + 3));

        snork.toTakeKnife(knife);

        Snork bp = new Snork("backpack", TypeOfPerson.COLLECTOR);
        Line line = new Line("line");
        line.setHp((int) (Math.random() * 4 + 3));
        bp.setBpSpace((int) (Math.random() * 5 + 2));

        for (int i = 0; i < 6; i++) {
            if (snork.mine(line)) {
                snork.getOre(line, snork.getKnife(), bp);
            }
        }
        Ore ore = new Ore();
        snork.snorkInventory();
        bp.removeBpSpace();
        // snork.snorkInventory();

        snork.changeTypeOfPerson(TypeOfPerson.GOLDMINER);


        sniff.wearItem(belt);


    }
}

/**
 * Ну а Снорк -- тот вскарабкался на вершину самой высокой скалы и огляделся. Остров распахнулся перед ним от побережья до
 * //    побережья и казался букетом цветов, плывущим по неспокойному морю. Вон виднеется маленькая движущаяся точка -- это Снифф, он ищет
 * //    обломки кораблекрушения, вон мелькнула шляпа Снусмумрика, а вон Хемуль выкапывает особо редкую разновидность венерина башмачка...
 * //    А вон там -- это как дважды два четыре -- там ударила молния! Большущая каменная глыба, больше, чем десять Муми-домов, вместе взятых,
 * //    раскололась, словно яблоко, и обе половины раздались в стороны, образовав ущелье с отвесными стенами. С замиранием сердца вошел Снорк в
 * //    ущелье и осмотрелся. Вот здесь она прошла! Извилистой черной как уголь линией обозначился ее путь по обнажившемуся нутру камня. А с нею
 * //    рядом бежала другая полоска, светлая и блестящая! Это было золото, не что иное, как золото!
 */
//    Снорк ковырнул полоску ножом. В лапу ему упала золотая крупинка.
//    Он отколупнул еще и еще. Словно в горячке выковыривал он куски один другого крупнее и скоро забыл обо всем на свете,
//    кроме вскрытых молнией золотых жил. Теперь он уже был не какой-то там собиратель выброшенных морем обломков кораблекрушения, а настоящий
//    золотоискатель! Снифф же тем временем сделал совсем немудреное открытие, но и оно подарило ему немудреную, а все же радость: он нашел
//    пробковый пояс -- пояс, отчасти разъеденный морской водой, но пришедшийся ему как раз впору.

