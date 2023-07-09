import java.util.ArrayList;
import java.util.List;

public class CompositeBlockImpl implements CompositeBlock{
    private List<Block> blockList;
    public CompositeBlockImpl(){
        blockList = new ArrayList<>();
    }

    @Override
    public String getColor() {
        String pom = new String();
        for (Block bl:blockList) {
            pom = pom + bl.getColor() + ", ";
        }
        return pom;
    }

    @Override
    public String getMaterial() {
        String pom = new String();
        for (Block bl:blockList) {
            pom = pom + bl.getMaterial() + ", ";
        }
        return pom;
    }

    @Override
    public List<Block> getBlocks() {
        return blockList;
    }
    public void add(Block b){
        blockList.add(b);
    }

}
