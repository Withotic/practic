public class App {
    public static void main(String[] args) throws Exception {
        Room[] rooms = new Room[4];
        rooms[0] =new EconomyRoom(0);
        rooms[1] = new StandartRoom(1);
        rooms[2] = new LuxRoom(2);
        rooms[3] = new UltraLuxRoom(3);
        RoomServiceImpl<Room> serv=new RoomServiceImpl<>();
        for (Room room : rooms) {
        serv.reserve(room);
        try {
            serv.reserve(room);
        } catch (customException e) {
            System.out.println("Сработало кастомное исключение: "+e.getMessage());
        }
        serv.clean(room);
        serv.free(room);    
        }
        LuxRoomServImpl<LuxRoom> luxserv = new LuxRoomServImpl<>();
        for(int i =2;i<4;i++)
            luxserv.foodDelivery((LuxRoom)rooms[i]);
    }
}
