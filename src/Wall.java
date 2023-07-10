import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Wall implements Structure{
    public Wall(){
        blocks = new ArrayList<>();
    }
    private final List<Block> blocks;
    @Override
    public Optional<Block> findBlockByColor(String color) {
        //tworzę listę składającą się tylko z pojedynczych bloków
        //brak composite block
        List<Block> onlyBlocks = leaveOnlyBlocks(blocks);

        //znajduję pierwszy element który zgadza się co do koloru
        return onlyBlocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();

    }
    private  List<Block> leaveOnlyBlocks(List<Block> blocks){
        //metoda zostawia w liście tylko proste bloki
        //brak compositeblock
        List<Block> onlyBlocks = blocks;
        while(anyCompositeBlocks(onlyBlocks)){
            onlyBlocks = formatToBlocks(onlyBlocks);
        }
        return onlyBlocks;
    }
    private boolean anyCompositeBlocks(List<Block> blocks){
        //sprawdza czy na liście znajduje się jakikolwiek compositeBlock
        for (Block bl:blocks) {
            if(bl  instanceof CompositeBlock)
                return true;
        }
        return false;
    }

    private List<Block> formatToBlocks(List<Block> blocks){
        //metoda iteruje po blokach, jeżeli blok jest composite to dodaje do
        //listy poszczególne jego składniki
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
        //analogicznie jak w findBlocksByColor tworzę listę
        //składającą się tylko z prostych bloków
        //brak compositeBlock
        List<Block> onlyBlocks = leaveOnlyBlocks(blocks);

        //zostawiam tylko bloki z odpowiedniego materiału
      onlyBlocks.removeIf(block -> !block.getMaterial().equals(material));

        return onlyBlocks;

    }

    @Override
    public int count() {
        //analogicznie jak wcześniej, tworzę listę
        //składającą się tylko z prostych bloków
        //brak compositeBlock
        List<Block> onlyBlocks = leaveOnlyBlocks(blocks);
        return onlyBlocks.size();
    }
    public void add(Block bl){
        blocks.add(bl);
    }
}
