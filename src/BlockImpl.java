public class BlockImpl implements Block{
    private String color;
    private String material;
    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    public BlockImpl(String color, String material){
        this.color = color;
        this.material = material;
    }
    public String toString(){
        return "Color: " + getColor() + ", material: " + getMaterial();
    }
}
