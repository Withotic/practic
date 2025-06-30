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
    static void Info(){
        System.out.println("Введите цифру и нажмите enter для выбора:");
        System.out.println("1. Добавить машину");
        System.out.println("2. Найти машины производителя");
        System.out.println("3. Вывести среднюю цену машин типа...");
        System.out.println("4. Отсортировать по году выпуска");
        System.out.println("5. Вывести статистику");
        System.out.println("6. Автоматическая отладка программы");
        System.out.println("0. Выход");
    }

    static void Task5(){
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("\nЗадание 5:");
        CarDealership cds = new CarDealership();
        Info();
        String ss = scanner.nextLine();
        while(!ss.equals("0"))
        {
            switch (ss) {
                case "1":
                    System.out.println("Введите несколько значений через пробел:");
                    System.out.println("vin, производитель, год выпуска, пробег (int), цена (double), цифра от 1 до 5 означающая тип: SEDAN, SUV, HATCHBACK, COUPE, PICKUP");
                    String[] sss = scanner.nextLine().split(" ");
                    try {
                    cds.AddCar(sss[0], sss[1], Integer.parseInt(sss[2]), Integer.parseInt(sss[3]), Double.parseDouble(sss[4]), CarType.values()[Integer.parseInt(sss[5])-1]);
                    } catch (Exception e) {
                        System.out.println("Ошибка обработки, выход.\n");
                    }
                    break;
            
                case "2":
                    System.out.println("Введите производителя:");
                    ss = scanner.nextLine();
                    System.out.println(cds.AllByManuf(ss));
                    break;
                    
                case "3":
                    System.out.println("Введите цифру от 1 до 5 означающую тип: SEDAN, SUV, HATCHBACK, COUPE, PICKUP");
                    ss = scanner.nextLine();
                    try {
                    cds.AvgByType(CarType.values()[Integer.parseInt(ss)-1]);
                    } catch (Exception e) {
                        System.out.println("Ошибка обработки, выход.\n");
                    }
                    break;
                    
                case "4":
                    System.out.println(cds.GetSortedByYears()); 
                    break;
                case "5":
                    cds.ShowStat();
                    break;
                case "6":
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
                    System.out.println("\n1. Проверка дубликата vin:");
                    cds.AddCar(toDebug, "Toyota", 0, 0, 0, null);
                    System.out.println("\n2. Найти все машины указанного производителя:\n"+cds.AllByManuf("Toyota"));
                    System.out.println("\n3. Вывести среднюю цену машин определённого типа: "+cds.AvgByType(CarType.SUV));
                    System.out.println("\n4. Вернуть список машин, отсортированных по году выпуска:\n"+cds.GetSortedByYears());
                    System.out.println("\n5. Статистика:");
                    cds.ShowStat();
                    break;
                default:
                    System.out.println("Повторите ввод");
                    break;
            }
            Info();
            ss = scanner.nextLine();
        }
        scanner.close();

        


        
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

