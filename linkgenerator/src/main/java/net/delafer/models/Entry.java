package net.delafer.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Entry {

    String title;
    String text;
    String type;
    String surname;
    String forename;
    String patronymic;
    String country;

    Dates dates;
    String image;
    String url;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    static int x = 0;
    public Entry(String title, String url, String type) {
        this.title = title;
        this.url = url;
        this.type = type;

        if ("guitarist".equals(type)) {
            this.country = "Россия";
            this.dates = new Dates("11.02.2020", null);
        }

    }

    public Entry(String title, String forename, String surname, String url) {
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.url = url;
        this.dates = new Dates("11.02.2020", null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            String json = mapper.writeValueAsString(this);
            return json;
            //System.out.println(json);
        } catch (JsonProcessingException e) {
            return e.toString();
        }
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class Dates {
        String born;
        String died;

        public Dates(String birth, String death) {
            this.born = birth;
            this.died = death;
        }

        public String getBorn() {
            return born;
        }

        public void setBorn(String born) {
            this.born = born;
        }

        public String getDied() {
            return died;
        }

        public void setDied(String died) {
            this.died = died;
        }
    }
}
