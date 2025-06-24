import java.util.Date;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Создаем объекты:");
        BankAccount test1=new BankAccount("null");
        BankAccount test2=new BankAccount("null");
        System.out.println();
        System.out.println();
        System.out.println("пробуем сравнить разные:");
        System.out.println("debug: "+test1.equals(test2));//false
        System.out.println("пробуем сравнить одинаковые:");
        System.out.println("debug: "+test1.equals(test1));//true
        System.out.println();
        System.out.println();
        System.out.println("выводим номер:");
        System.out.println("debug: "+test1.getNumber());//random XXXXXXXX
        System.out.println();
        System.out.println();        
        System.out.println("пробуем вывести с пустого счета:");
        System.out.println("debug: "+test1.withdraw(10));//false
        System.out.println("пробуем положить:");
        System.out.println("debug: "+test1.deposit(10));//true
        System.out.println("пробуем вывести с полного счета:");
        System.out.println("debug: "+test1.withdraw(10));//true
        System.out.println();
        System.out.println();
        System.out.println("пробуем перевести с пустого счета:");
        System.out.println("debug: "+test1.transfer(test2,10));//false
        System.out.println("пробуем положить и перевести с полного счета:");
        System.out.println("debug: "+test1.deposit(10));//true
        System.out.println("debug: "+test1.transfer(test2,10));//true
    }
}

class BankAccount{//предполагается, что поля по умолчанию private
    private String name="";
    private int balance=0;
    private java.util.Date localDateTime=new Date();
    private boolean isBlocked=false;
    private String number="";
    public BankAccount(String nam){
        Random rnd = new Random();
        for(int i=0;i<8;i++)
            number+=rnd.nextInt(10);
        name=nam;
        System.out.println("создан: "+number);
    }
    public boolean deposit(int am){
        balance+=am;
        System.out.println("депозит на: "+number+"; сумма: "+am+"; баланс: "+balance);
        return true;
    }
    public boolean withdraw(int am){
        if(balance-am<0){
            System.out.println("вывод с: "+number+"; не выполнен");
            return false;
        }
            
        balance-=am;
        System.out.println("вывод с: "+number+"; сумма: "+am+"; баланс: "+balance);
        return true;
    }
    public boolean transfer(BankAccount othAcc,int am){
        if(!withdraw(am)){
            System.out.println("перевод с: "+number+"; не выполнен");
            return false;
        }
        othAcc.deposit(am);
        System.out.println("перевод с: "+number+" на:"+othAcc.getNumber()+"; сумма: "+am+"; баланс: "+balance);
        return true;
    }
    @Override
    public String toString() {
        return "Банковский аккаунт владельца "+name+":\nбаланс: "+balance+"\nстатус: "+(isBlocked?"заблокирован":"активен");
    }
    public String getNumber(){
        return number;
    }
    @Override
    public boolean equals(Object obj) {
        return ((BankAccount)obj).number.equals(number);
    }
}