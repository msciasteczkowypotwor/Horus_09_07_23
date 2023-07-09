import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
    private List<Block> blocks;
    @Override
    public Optional<Block> findBlockByColor(String color) {
        List<Block> onlyBlocks = blocks;

        while(anyCompositeBlocks(onlyBlocks)){
            onlyBlocks = formatToBlocks(onlyBlocks);
        }

        return onlyBlocks.stream().filter(block -> block.getColor().equals(color)).findFirst();

    }
    public boolean anyCompositeBlocks(List<Block> blocks){
        for (Block bl:blocks) {
            if(bl  instanceof CompositeBlock)
                return true;
        }
        return false;
    }
    public List<Block> formatToBlocks(List<Block> blocks){
        List<Block> newBlocks = new ArrayList<>();

        for (Block bl: blocks) {
            if(bl instanceof CompositeBlock){
                newBlocks.addAll(((CompositeBlock) bl).getBlocks());
            }
            else{
                newBlocks.add(bl);
            }
        }
        return newBlocks;
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> onlyBlocks = blocks;

        while(anyCompositeBlocks(onlyBlocks)){
            onlyBlocks = formatToBlocks(onlyBlocks);
        }
      onlyBlocks.removeIf(block -> !block.getMaterial().equals(material));

        return onlyBlocks;

    }

    @Override
    public int count() {
        List<Block> onlyBlocks = blocks;

        while(anyCompositeBlocks(onlyBlocks)){
            onlyBlocks = formatToBlocks(onlyBlocks);
        }
        return onlyBlocks.size();
    }

    public Wall(){
        blocks = new ArrayList<>();
    }
    public void add(Block bl){
        blocks.add(bl);
    }
}
