import java.util.*;
public class CarDealership {
    public CarDealership(){
        System.out.println("Создан дилер");
    }
    //статистика
    private int[] typeCount=new int[5];
    private Car oldestCar;
    private Car newestCar;

    private Set<Car> cars=new HashSet<>();
    public void AddCar(Car car){//тут нет проверки по vin т.к. сет и equals уже это обеспечивают
        if(cars.add(car)){
            System.out.println("Машина добавлена: "+car);
            typeCount[car.getType().ordinal()]+=1;
            if(oldestCar==null||oldestCar.getYear()>car.getYear())
                oldestCar=car;
            if(newestCar==null||newestCar.getYear()<car.getYear())
                newestCar=car;
            
        }
        else
            System.out.println("Машина с таким vin уже существует");
    }
    public void AddCar(String vinn, String man, int yer, int milag, double pric, CarType typ){
        AddCar(new Car(vinn, man, yer, milag, pric, typ));
    }
    public List<Car> AllByManuf(String manuf){
        return cars.stream().filter(x->x.getManuf().equals(manuf)).toList();
    }
    public double AvgByType(CarType type){
        return cars.stream().filter(x->x.getType().equals(type)).map(x->x.getPrice()).mapToDouble(Double::doubleValue).average().getAsDouble();
    }
    public List<Car> GetSortedByYears(){
        return cars.stream().sorted((a,b)->Integer.compare(b.getYear(), a.getYear())).toList();
    }
    public void ShowStat(){
        for(int i = 0;i<5;i++)
        System.out.println(CarType.values()[i]+": "+typeCount[i]);
        System.out.println("Старейшая: "+oldestCar);
        System.out.println("Новейшая: "+newestCar);
    }
}
