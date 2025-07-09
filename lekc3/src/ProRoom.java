public abstract class ProRoom extends Room {
    public ProRoom(int num,Price pric){
        super(num, pric);
    }
    @Override
    public String toString() {
        return "Про"+super.toString();
    }
}
