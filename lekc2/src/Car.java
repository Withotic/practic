import java.util.*;
public class Car implements Comparable<Car>{
    private String vin;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    private CarType type;
    public Car(String vinn, String man, int yer, int milag, double pric, CarType typ){
        vin=vinn;
        manufacturer=man;
        year=yer;
        mileage=milag;
        price=pric;
        type=typ;
    }
    public CarType getType(){
        return type;
    }
    public int getYear(){
        return year;
    }
    public double getPrice(){
        return price;
    }
    public int getMiles(){
        return mileage;
    }
    public String getManuf(){
        return manufacturer;
    }
    @Override
    public boolean equals(Object obj) {
        return vin.equals(((Car)obj).vin);
    }
    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }
    @Override
    public int compareTo(Car o) {
        return year-o.year;
    }
    @Override
    public String toString() {
        return vin+" "+manufacturer+" "+year+" г. "+mileage+" км. "+price+" уе "+type;
    }
}
