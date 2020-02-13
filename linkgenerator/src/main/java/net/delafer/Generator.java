package net.delafer;

import net.delafer.models.DataEntry;
import net.delafer.models.Entry;
import net.delafer.models.Link;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Generator {

    public static void main(String[] args) {
        Link[] pages = new Link[] {
                Link.of("http://www.abc-guitars.com/index.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/menu1.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/menu2.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/menu3.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/menu.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/index_all.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/biblio.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/links.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/temp.htm", "other"),
                Link.of("http://www.guitar-times.ru/pages/historians/historians.htm", "historian"),
                Link.of("http://www.guitar-times.ru/pages/publishers/publishers.htm", "publisher"),
                Link.of("http://www.guitar-times.ru/pages/guitarists/guitarists.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/guitar_art/galery/galery1.htm", "guitarist"),
                Link.of("http://www.guitar-times.ru/pages/documents/documents.htm", "article"),
                Link.of("http://www.guitar-times.ru/index.htm", "magazine"),
                Link.of("http://www.abc-guitars.com/links.htm", "links"),
                Link.of("http://www.abc-guitars.com/links_01.htm", "links"),
                Link.of("http://www.abc-guitars.com/news.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_01.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_02.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_03.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_2008_10.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_2007.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_2006.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_2005.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_2004_05.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_2004.htm", "news"),
                Link.of("http://www.abc-guitars.com/news_2003.htm", "news"),
                Link.of("http://www.abc-guitars.com/fest.htm", "fest"),
                Link.of("http://www.abc-guitar.narod.ru/index_all.htm", "guitarist"),
                Link.of("http://www.abc-guitars.com/pages/authors.htm", "other"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag16.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag15.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag13.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag11_12.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag10.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag9.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag8.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag7.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag5.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag4.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag2.htm", "article"),
                Link.of("http://www.guitar-times.ru/pages/magazine/mag.htm", "article"),

                Link.of("http://www.abc-guitars.com/fest/_new.htm", "fest"),
                Link.of("http://www.abc-guitars.com/fest/ru.htm", "fest"),

                Link.of("http://teslov-music.ru/biography-htm/biography-list.htm", "guitarist"),

                //https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D0%B5%D0%BA%D1%82:%D0%9C%D1%83%D0%B7%D1%8B%D0%BA%D0%B0/%D0%A1%D0%BF%D0%B8%D1%81%D0%BA%D0%B8/%D0%A1%D0%BF%D0%B8%D1%81%D0%BE%D0%BA_%D0%B3%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D0%BE%D0%B2
                //https://ru.wikipedia.org/wiki/100_%D0%B2%D0%B5%D0%BB%D0%B8%D1%87%D0%B0%D0%B9%D1%88%D0%B8%D1%85_%D0%B3%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D0%BE%D0%B2_%D0%B2%D1%81%D0%B5%D1%85_%D0%B2%D1%80%D0%B5%D0%BC%D1%91%D0%BD_%D0%BF%D0%BE_%D0%B2%D0%B5%D1%80%D1%81%D0%B8%D0%B8_%D0%B6%D1%83%D1%80%D0%BD%D0%B0%D0%BB%D0%B0_Rolling_Stone
                //https://ru.wikipedia.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%93%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D1%8B
                //https://ru.wikipedia.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%A1%D0%BE%D0%BB%D0%BE-%D0%B3%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D1%8B
                //https://ru.wikipedia.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%98%D1%81%D0%BF%D0%BE%D0%BB%D0%BD%D0%B8%D1%82%D0%B5%D0%BB%D0%B8_%D0%B8%D0%B3%D1%80%D1%8B_%D0%BD%D0%B0_%D1%80%D1%83%D1%81%D1%81%D0%BA%D0%BE%D0%B9_%D1%81%D0%B5%D0%BC%D0%B8%D1%81%D1%82%D1%80%D1%83%D0%BD%D0%BD%D0%BE%D0%B9_%D0%B3%D0%B8%D1%82%D0%B0%D1%80%D0%B5
                //https://ru.wikipedia.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%9A%D0%BB%D0%B0%D1%81%D1%81%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B5_%D0%B3%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D1%8B
                //https://ru.wikipedia.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%9A%D0%BB%D0%B0%D1%81%D1%81%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%B8%D0%B5_%D0%B3%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D1%8B_%D0%A0%D0%BE%D1%81%D1%81%D0%B8%D0%B8
                //https://ru.wikipedia.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%93%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D1%8B_%D0%BF%D0%BE_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B0%D0%BC


                //https://ru.wikipedia.org/wiki/%D0%9A%D0%B0%D1%82%D0%B5%D0%B3%D0%BE%D1%80%D0%B8%D1%8F:%D0%93%D0%B8%D1%82%D0%B0%D1%80%D0%B8%D1%81%D1%82%D1%8B_%D0%A1%D0%A1%D0%A1%D0%A0
                //drugie strany
        };

        TreeSet<DataEntry> entries = new TreeSet<>();

       entries.add(new DataEntry("https://twitter.com/VictorNc20","Twitter Виктор Тавровский", "social"));

        for (Link page : pages) {
            try {
                ListLinks.fetch(page, entries);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        System.out.println("all done!!!");
        System.out.println("all done!!!");
        System.out.println("all done!!!");

        List<Entry> lists = new ArrayList<Entry>();

        for (DataEntry entry : entries) {
            Entry next = convert(entry);
            lists.add(next);
            //System.out.println(next);
        }

        System.out.println(lists.size());

    }


    static Entry convert(DataEntry inp) {
        Entry entr =  new Entry(inp.getText(), inp.getUrl(), inp.getType());

        String name = inp.getText();
        String[] names = name.split(" ");
        if (names.length==2) {
            entr.setForename(names[1]);
        }
        if (names.length>1) {
            entr.setSurname(names[0]);
        }

        if (StringUtils.isNotBlank(entr.getForename())) {
            String[] test = entr.getForename().split("\\.");
//            if (test.length>0) {
//                System.out.println(test.length);
//            }
            if (test.length==2) {
                entr.setForename(test[0]+".");
                entr.setPatronymic(test[1]+".");
            }
        }

        if (entr.getTitle().length()>24) {
            entr.setText(entr.getTitle());
            entr.setTitle(trim(entr.getTitle(), 24));
        }

        return entr;
    }


    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }

}
