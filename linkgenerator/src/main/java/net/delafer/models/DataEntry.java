package net.delafer.models;

import java.util.Objects;

public class DataEntry implements  Comparable<DataEntry> {

    String text;
    String url;
    String type;

    public DataEntry() {
    }

    static String notNull(String value) {
        return value != null ? value : "";
    }

    @Override
    public String toString() {
        return String.format("<a href=\"%s\">%s</a>", getUrl(), notNull(getText()));
    }

    public DataEntry(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataEntry(String url, String text, String type) {
        this.text = text;
        this.url = url;
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return notNull(trimUrl(trimUrl(url, trim1), trim2));
    }

    final static String trim1 = "http://www.abc-guitars.com/";
    final static String trim2 = "http://www.abc-guitar.narod.ru/";

    static String trimUrl(String val, String totrim) {
        if (val != null && val.startsWith(totrim))
            return val.substring(totrim.length());
        else
            return val;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataEntry dataEntry = (DataEntry) o;
        return this.getText().equals(dataEntry.getText()) &&
                this.getUrl().equals(dataEntry.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getText(), this.getUrl());
    }

    private String toCmp() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.getType()).append(':').append(this.getUrl().trim());
        return sb.toString();
    }

    @Override
    public int compareTo(DataEntry o) {
        return this.toCmp().compareToIgnoreCase(o.toCmp());
    }
}
