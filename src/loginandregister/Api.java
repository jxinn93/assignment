package loginandregister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONObject;

public class Api {
    private static final String API_KEY = "ce59ac85d24947638acb679ccb1b9b77";
    private static final String API_URL = "https://api.bing.microsoft.com/v7.0/news/search";

    public static List<NewsFilter.NewsArticle> getNewsNature() {
        try {
            String apiUrl = API_URL + "?q=nature&language=en&count=5";
            System.out.println("API URL: " + apiUrl);

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setRequestProperty("Ocp-Apim-Subscription-Key", API_KEY);

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                System.out.println("Raw JSON response from API: " + response.toString());

                // Parse and return the news
                List<NewsFilter.NewsArticle> articles = parseNatureNewsJson(response.toString());

                // Filter articles to ensure English headlines and add up to 4 more
                List<NewsFilter.NewsArticle> filteredArticles = articles.stream()
                        .filter(article -> {
                            String lowerCaseTitle = article.title.toLowerCase();
                            return lowerCaseTitle.contains("nature") && lowerCaseTitle.matches("\\p{IsLatin}+");
                        })
                        .limit(5) // Limit to 5 additional articles
                        .collect(Collectors.toList());

                System.out.println("Titles of filtered articles:");
                filteredArticles.forEach(article -> System.out.println(article.title));

                // Check if there are results
                if (filteredArticles.isEmpty()) {
                    System.out.println("No English articles with 'nature' found in the API response.");
                }

                return filteredArticles;
            } else {
                System.err.println("API request failed. Response Code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static List<NewsFilter.NewsArticle> parseNatureNewsJson(String natureNewsJson) {
        List<NewsFilter.NewsArticle> newsList = new ArrayList<>();
        try {
            JSONObject jsonResponse = new JSONObject(natureNewsJson);
            JSONArray articles = jsonResponse.getJSONArray("value");

            for (int i = 0; i < articles.length(); i++) {
                JSONObject articleObj = articles.getJSONObject(i);
                String title = articleObj.getString("name");
                String url = articleObj.getString("url");
                String dateString = articleObj.getString("datePublished");

                java.util.Date date = parseDate(dateString);
                NewsFilter.NewsArticle newsArticle = new NewsFilter.NewsArticle(title, url, date);
                newsList.add(newsArticle);
            }
            return newsList;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newsList;
    }

    private static java.util.Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
