public class EconomyRoom extends Room {
    public EconomyRoom(int num){
        super(num, Price.eco);
        System.out.println("Создан EconomyRoom");
    }
    @Override
    public String toString() {
        return "Эконом"+super.toString();
    }
}
