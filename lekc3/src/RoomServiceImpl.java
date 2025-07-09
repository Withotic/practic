public class RoomServiceImpl<T extends Room> implements RoomService<T> {
    @Override
    public void clean(T q) {
        q.cleanhehe();
    }

    @Override
    public void free(T q) {
        q.setFree();
    }

    @Override
    public void reserve(T q) {
        if(q.isBusy())
            throw new customException();
        else
            q.setBusy();
    }
}
