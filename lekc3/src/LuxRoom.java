public class LuxRoom extends ProRoom {
    public LuxRoom(int num){
        super(num, Price.lux);
        System.out.println("Создан LuxRoom");
    }

    //небольшой костыль))
    protected LuxRoom(int num, Price pric){
        super(num, pric);
    }

    @Override
    public String toString() {
        return "Люксовый"+super.toString();
    }
}
