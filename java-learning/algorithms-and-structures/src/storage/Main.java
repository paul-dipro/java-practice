package storage;

public class Main {
    public static void main(String[] args) {

        DataStore<String> tokenStorage = new CredentialStore();
        tokenStorage.store("Admin123");
        System.out.println("Retrieved Token: " + tokenStorage.getData());

        System.out.println();

        DataStore<Integer> metricStorage = new CloudPayloadStore<>();
        metricStorage.store(2026);
        System.out.println("Retrieved Metric ID: " + metricStorage.getData());
    }
}