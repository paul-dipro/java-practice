package storage;

public interface DataStore<T> {
    void store(T data);
    T getData();
}