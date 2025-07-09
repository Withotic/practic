import java.util.Random;

public abstract class Room {
    private int number;
    private int maxVisitors;
    private int price;
    private boolean isBusy;
    public int getNumber() {
        return number;
    }
    public int getMaxVisitors() {
        return maxVisitors;
    }
    public int getPrice() {
        return price;
    }
    public boolean isBusy() {
        return isBusy;
    }
    public void setBusy(){
        isBusy=true;
        System.out.println("Номер "+number+" забронирован");
    }
    public void setFree(){
        isBusy=false;
        System.out.println("Номер "+number+" освобожден");
    }
    public void cleanhehe(){
        price++;
        System.out.println("Номер "+number+" стал на один кредит чище");
    }
    public Room(int num,Price pric){
        number=num;
        switch (pric) {
            case eco:
                price=500;
                break;
            case stand:
                price=1000;
                break;
            case lux:
                price=1500;
                break;
            case ulux:
                price=2000;
                break;
            default:
                break;
        }
        Random rnd = new Random();
        maxVisitors=rnd.nextInt(7)+1;
        isBusy=false;
    }
    @Override
    public String toString() {
        return " номер: "+number+"; Посетители: "+maxVisitors+"; цена: "+price+"; "+(isBusy?"":"не")+" забронирован";
    }
}