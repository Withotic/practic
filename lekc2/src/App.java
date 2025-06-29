import java.util.*;
import java.util.stream.Collectors;

public class App {
    
    static Random rnd = new Random();
    static void Task1(){
        List<Integer> years = new ArrayList<Integer>();
        for(int i = 0; i<50;i++)
            years.add(rnd.nextInt(2000, 2026));
        System.out.println("Задание 1:");
        System.out.println("Исходный массив лет выпусков машин: "+years);
        System.out.println("Машины моложе 2015: "+years.stream().filter(x-> x > 2015).toList());
        System.out.println("Средний возраст: "+years.stream().map(x->2025-x).mapToInt(Integer::intValue).average().getAsDouble()+"\n");
    }
    static void Task2(){
        List<String> cars = Arrays.asList(
    "BMW", "Audi", "Toyota", "Honda","Mazda", "Toyota", "Ford", "BMW", "Honda", "Tesla model X"
        );
        System.out.println("\nЗадание 2:");
        System.out.println("Исходный массив машин: "+cars);
        cars=cars.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println("отсортировано и без дубликатов: "+cars);
        Set<String> sCars = new HashSet<>(cars);
        System.out.println(sCars.stream().map(x->
            x.contains("Tesla")? x.replace("Tesla", "ELECTRO_CAR"):x
         ).toList()+"\n"
         );
    }
    static void Task3(){
        Set<Car> cars=new HashSet<>();
        System.out.println("\nЗадание 3:");
        System.out.println("Попытка добавить в сет одинаковые vin номера");
        System.out.println(cars.add(new Car("9834d02f", "toyota", 2000, 30000, 10000,CarType.SEDAN))); 
        System.out.println(cars.add(new Car("9834d02f", "toyota", 2020, 30000, 10000,CarType.SEDAN)));
        System.out.println("Проверка comparable:");
        int res = (new Car(null, null, 2000, 0, 0,CarType.SEDAN)).compareTo(new Car(null, null, 2010, 0, 0,CarType.SEDAN));
        if (res<0)
            System.out.println("Первая машина произведена раньше");
        else if(res ==0)
            System.out.println("Машины произведены в один год");
        else
            System.out.println("Первая машина произведена позже");
        
        System.out.println();
    }
    static void Task4(){
        System.out.println("\nЗадание 4:");
        List<Car> cars = new ArrayList<>();
        for(int i=0;i<10;i++){
            String vinn="";
            for(int k=0;k<10;k++)
            vinn+="qwertyuiopasdfghjklzxcvbnm1234567890".charAt(rnd.nextInt(36));
            cars.add(new Car(
                vinn, 
                new String[]{"Toyota","Mazda","BMW","Tesla","Audi","Honda","Ford","Hyundai","Mercedes","Renault"}[rnd.nextInt(10)], 
                rnd.nextInt(2000,2026), 
                rnd.nextInt(100000), 
                rnd.nextDouble(1000,100000),
                CarType.SEDAN));
        }
        System.out.println("Фильтр меньше 50000км:\n"+cars.stream().filter(x->x.getYear()<50000).toList());
        List<Car> sorted = cars.stream().sorted((a,b)->Double.compare(b.getPrice(), a.getPrice())).toList();
        System.out.println(
            "\nТоп дорогих:\n"+
            sorted.get(0)+"\n"+
            sorted.get(1)+"\n"+
            sorted.get(2)
        );
        System.out.println("Средний пробег: "+cars.stream().map(x->x.getMiles()).mapToInt(Integer::intValue).average().getAsDouble());
        System.out.println("Группировка по производителю:\n"+cars.stream().collect(Collectors.groupingBy(Car::getManuf)));
        System.out.println();
    }
    static void Task5(){
        System.out.println("\nЗадание 5:");
        CarDealership cds = new CarDealership();
        String toDebug="";
        for(int i = 0;i<10;i++){
            String vinn="";
            for(int k=0;k<10;k++)
                vinn+="qwertyuiopasdfghjklzxcvbnm1234567890".charAt(rnd.nextInt(36));
            cds.AddCar(
                vinn, 
                new String[]{"Toyota","Mazda","BMW","Tesla","Audi"}[rnd.nextInt(5)], 
                rnd.nextInt(2000,2026), 
                rnd.nextInt(100000), 
                rnd.nextDouble(1000,100000),
                CarType.values()[rnd.nextInt(5)]);
            toDebug=vinn;
            }
        System.out.println("\nПроверка дубликата vin:");
        cds.AddCar(toDebug, "Toyota", 0, 0, 0, null);
        System.out.println("\nНайти все машины указанного производителя:\n"+cds.AllByManuf("Toyota"));
        System.out.println("\nВывести среднюю цену машин определённого типа: "+cds.AvgByType(CarType.SUV));
        System.out.println("\nВернуть список машин, отсортированных по году выпуска:\n"+cds.GetSortedByYears());
        System.out.println("\nСтатистика:");
        cds.ShowStat();
    }
    public static void main(String[] args) throws Exception {
        System.out.println();
        Task1();
        Task2();
        Task3();
        Task4();
        Task5();
    }
}

