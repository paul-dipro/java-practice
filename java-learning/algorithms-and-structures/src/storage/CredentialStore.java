package storage;

public class CredentialStore implements DataStore<String> {
    public String securedToken;

    @Override
    public void store(String data) {
        this.securedToken = "ENC_" + data.trim();
        System.out.println("Log: Securely saved string to credentials file.");

    }

    @Override
    public String getData() {
        return this.securedToken;
    }

}