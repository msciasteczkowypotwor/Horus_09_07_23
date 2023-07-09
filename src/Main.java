// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BlockImpl b1 = new BlockImpl("czarny","beton");
        BlockImpl b7 = new BlockImpl("zolty","papier");
        BlockImpl b2 = new BlockImpl("czerwony","stal");
        BlockImpl b3 = new BlockImpl("niebieski","plastik");
        BlockImpl b4 = new BlockImpl("zielony","papier");
        CompositeBlockImpl cB = new CompositeBlockImpl();
        cB.add(b2);
        cB.add(b3);
        cB.add(b4);
        Wall wl = new Wall();
        wl.add(b1);
        wl.add(b7);
        wl.add(cB);
        System.out.println(wl.findBlockByColor("czerwony").toString());
        System.out.println(wl.findBlocksByMaterial("papier").toString());
        System.out.println(wl.count());
        System.out.println(cB.getColor());
        System.out.println(cB.getMaterial());

    }
}