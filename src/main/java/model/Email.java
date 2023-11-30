package model;

public class Email {
    private String username;
    private String domain;
    private int tld;

    public Email(String username, String domain, int tld) {
        this.username = username;
        this.domain = domain;
        this.tld = tld;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public int getTld() {
        return tld;
    }
}
