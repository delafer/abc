package net.delafer.models;

public class Link {
    String url;
    String type;

    public Link(String url, String type) {
        this.url = url;
        this.type = type;
    }

    public static Link of(String url, String type) {
        return new Link(url, type);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
