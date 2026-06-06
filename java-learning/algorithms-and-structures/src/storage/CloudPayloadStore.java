package storage;

public class CloudPayloadStore<T> implements DataStore<T> {
    private T payload;

    @Override
    public void store(T data) {
        this.payload = data;
        System.out.println("Log: Broadcasting generic payload layer out to cloud infrastructure.");
    }

    @Override
    public T getData() {
        return this.payload;
    }
}