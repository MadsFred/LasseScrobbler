package sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Line on 24-04-2015.
 */
public class ScrobblerThread extends Thread{

    private Document doc;

    public void run(){
        if(System.currentTimeMillis() % 10000 == 0){
            try {
                doc = Jsoup.parse(new URL("http://thelakeradio.com/"), 10000); // Make document object from URL, with timeout limit of 10 seconds.
            } catch (IOException e) {
                e.printStackTrace();
            }
            String tempString = doc.body().getElementsByTag("span").text();
            System.out.println(tempString);
        }
    }
}
