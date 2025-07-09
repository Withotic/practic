public class customException extends RuntimeException {
    public customException(){
        super("Комната уже забронирована");
    }
    public customException(String mess){
        super(mess);
    }
}
