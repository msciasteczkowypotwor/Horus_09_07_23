import java.util.ArrayList;
import java.util.List;

public class CompositeBlockImpl implements CompositeBlock{
    public CompositeBlockImpl(){
        blocks = new ArrayList<>();
    }
    private List<Block> blocks;

    @Override
    public String getColor() {
        //nie wiedziałem do końca co powinna zwracać ta metoda
        //w przypadku compositeblock - zwarcam wszystkie kolory
        //poszczególnych bloków zawierających się w composite block
        String pom = "";
        for (Block bl: blocks) {
            pom = pom + bl.getColor() + ", ";
        }
        return pom;
    }

    @Override
    public String getMaterial() {
        //zwarcam wszystkie materiały
        //poszczególnych bloków zawierających się w composite block
        String pom = "";
        for (Block bl: blocks) {
            pom = pom + bl.getMaterial() + ", ";
        }
        return pom;
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
    public void add(Block b){
        blocks.add(b);
    }

}
