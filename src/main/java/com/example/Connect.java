package com.example;

import java.io.IOException;
//import java.net.URI;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
//import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Connect {
    public static void main(String domain, String scamOrSelling) throws IOException {
    Connection.Response response = null;

        String http = "https://";
        String url = http + domain;

        //Variables for connecting to webpage and cycling through html code
        try {
            Document doc = Jsoup.connect(url).get();
            //System.out.println(url);
            response = Jsoup.connect(url)
            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.82 Safari/537.36")
            .timeout(App.timeOut)
            .execute();
            int httpCode = response.statusCode();

            //System.out.println(httpCode);
            if (httpCode == 200 && scamOrSelling.isEmpty()) //"Http code 200" means the website responded and it is up
            {
                Elements elements = doc.body().select("*");
                String haystack = elements.text();
                Find_Element.main(haystack, domain, httpCode);
            }
            else if ((httpCode >= 400 && httpCode <= 511) || (httpCode == 522 || !scamOrSelling.isEmpty()))
            {
                Http_Response.main(httpCode, scamOrSelling, domain);
            }
        } catch (Exception e) {
            System.out.print(e);
            Error_Handler.main(e, "Connect", domain);
        }
    }
}
