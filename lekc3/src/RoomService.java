public interface RoomService<T extends Room> {
    public void clean(T q);
    public void reserve(T q);
    public void free(T q);
}
