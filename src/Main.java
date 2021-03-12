public class Main {
    public static void main(String[] args) throws SizeException {
        Snork snork = new Snork("Snork", TypeOfPerson.COLLECTOR);
        Sea sea = new Sea("Sea");
        Item belt = new Item("belt", 10);
        Snusmoomrik snusmoomrik = new Snusmoomrik(new Item("hat", 10), "Snusmoomrik");
        Hemul hemul = new Hemul("Hemul", TypeOfPerson.COLLECTOR);
        Ore rock = new Ore();
        snork.see(Place.ISLAND.getUrl(), sea, Sniff.get(), belt, snusmoomrik, hemul, rock);
        Place overThere = Place.OVER_THERE;
        Lightning.struck(overThere);

        class StoneBlock extends Item implements Destroyable {
            public StoneBlock(String name, int size) throws SizeException {
                super(name, size);
            }

            @Override
            public StoneBlock[] destroy() {
                setHp(2);
                minusHp();
                minusHp();
                StoneBlock[] stoneBlocks = new StoneBlock[2];
                double sizeProportions = Math.random();
                if(sizeProportions ==0){
                    throw new ProportionException("Proportion can`t be equal 0!");
                }
                try {
                    stoneBlocks[0] = new StoneBlock("stone block 1", (int) (getSize() * sizeProportions));
                    stoneBlocks[1] = new StoneBlock("stone block 2", getSize() - stoneBlocks[0].getSize());
                } catch (SizeException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "Big stone block with size " + getSize() + " destroyed to 2 stone blocks with sizes " + stoneBlocks[0].getSize() + " and " + stoneBlocks[1].getSize());
                return stoneBlocks;
            }


        }

        StoneBlock stoneBlock = new StoneBlock("stone block", 20);
        StoneBlock[] stoneBlocks;
        stoneBlocks = (StoneBlock[]) Lightning.struck(stoneBlock);

        CreateGorge createGorge = new CreateGorge() {
            @Override
            public Place createGorge(Item[] items) {
                if (items.length == 2) {
                    System.out.println(items[0].getName() + " and " + items[1].getName() + " creates a gorge");
                    return Place.GORGE;
                } else
                    return null;
            }
        };
        Place gorge = createGorge.createGorge(stoneBlocks);
        if (gorge != null) {
            System.out.println("We have " + gorge.getUrl() + " there");
            snork.getIn(gorge);
        }

        System.out.println();
        System.out.println("\n\n\n");

        Item ship = new Item("ship", 10);
        ship.setHp((int) (Math.random() * 10));

        sea.destruct(ship, DegreeOfBroke.DESTRUCTS);

        belt.setHp((int) (Math.random() * 10));
        sea.destruct(belt, DegreeOfBroke.CORRODES);

        Item knife = new Item("knife", 10);
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

        Sniff.get().wearItem(belt);

    }

    public static class Lightning {
        private static final String name = "Lightning";

        static void struck(Place place) {
            System.out.println(name + " struck " + place.getUrl() + " and change the electric charge to " + place.getElectricCharge());
            place.addElectricCharge(place.getElectricCharge());
        }
        static Object[] struck(Destroyable destroyable){
            System.out.println(name + " struck " + " and destroy " +destroyable.getClass().getSimpleName());
            return destroyable.destroy();
        }
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

