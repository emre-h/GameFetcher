package emre;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {

        String result = "";

        try {
            Document document = Jsoup.connect("https://play.google.com/store/apps/category/GAME/collection/topselling_free").get();

            Document document2 = Jsoup.connect("https://play.google.com/store/apps/category/GAME/collection/topselling_paid").get();

            Elements links = document.select("span.preview-overlay-container");

            for (Element link : links) {
                result += link.attr("data-docid") + "\n";
            }

            Elements links2 = document2.select("span.preview-overlay-container");

            for (Element link : links2) {
                result += link.attr("data-docid") + "\n";
            }

            writeFile(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeFile(String list) throws Exception {
        PrintWriter writer = new PrintWriter("play_games.txt", "UTF-8");
        writer.println(list);
        writer.close();
    }
}