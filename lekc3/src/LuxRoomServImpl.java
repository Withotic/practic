public class LuxRoomServImpl<T extends LuxRoom> extends RoomServiceImpl<T> implements LuxRoomService<T>{
    @Override
    public void foodDelivery(T q) {
        System.out.println("Доставка еды в номер "+q.getNumber());
    }
    
}
