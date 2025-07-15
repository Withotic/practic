import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Printable {
    void print();
}

public class App {
    static int x=0;
    static String s="";
    static void Task1(){
        System.out.println("Задание 1");
        Printable pr=()->System.out.println(x);
        x=1;
        pr.print();
    }
    static void Task2(){
        System.out.println("Задание 2");
        Predicate<String> nn=(s)->s!=null;
        Predicate<String> ne=(s)->!s.equals("");
        Predicate<String> all=nn.and(ne);
        System.out.println(all.test(s));//false
        s="f";  
        System.out.println(all.test(s));//true
        s=null;
        System.out.println(all.test(s));//false
    }
    static void Task3(){
        System.out.println("Задание 3");
        Predicate<String> q=(s)->(s.charAt(0)=='J'||s.charAt(0)=='N')&&s.charAt(s.length()-1)=='A';
        System.out.println(q.test("JENA"));//true
        System.out.println(q.test("NOGA"));//true
        System.out.println(q.test("YOGA"));//false
        System.out.println(q.test("JOY"));//false
    }
    static void Task4(){
        System.out.println("Задание 4");
        Consumer<HeavyBox> otgr = box -> System.out.println("Отгрузили ящик с весом " + box.getWeight());
        Consumer<HeavyBox> otpr = box ->System.out.println("Отправляем ящик с весом " + box.getWeight());
        Consumer<HeavyBox> andthen = otgr.andThen(otpr);
        HeavyBox box = new HeavyBox(3);
        andthen.accept(box);
    }
    static void Task5(){
        System.out.println("Задание 5");
        Function<Integer, String> check = num -> {
            if (num > 0) {
                return "Положительное число";
            } else if (num < 0) {
                return "Отрицательное число";
            } else {
                return "Ноль";
            }
        };
        System.out.println(check.apply(5));//Положительное число
        System.out.println(check.apply(-3));//Отрицательное число
        System.out.println(check.apply(0));//Ноль
    }
    static void Task6(){
        System.out.println("Задание 6");
        Supplier<Integer> rnd = () -> new Random().nextInt(11);
        System.out.println(rnd.get());
        System.out.println(rnd.get());
        System.out.println(rnd.get());
    }
    static void Task11(){
        System.out.println("Задание 1");
        AnnotationProc.procAnn(oldClass.class);
    }
    static void Task12(){
        System.out.println("Задание 2");
        toJsonAnn clas = new toJsonAnn();
        System.out.println(JsonSer.toJson(clas));
    }
    public static void main(String[] args) throws Exception {
        Task1();
        Task2();
        Task3();
        Task4();
        Task5();
        Task6();
        Task11();
        Task12();
    }
}
