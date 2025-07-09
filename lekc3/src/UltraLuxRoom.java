public class UltraLuxRoom extends LuxRoom {
    public UltraLuxRoom(int num){
        super(num, Price.ulux);
        System.out.println("Создан UltraLuxRoom");
    }
    @Override
    public String toString() {
        return "Ультра-люксовый"+super.toString();
    }
}
