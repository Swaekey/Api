package casino;

/**
 *
 * @author Keshawn
 */
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
// You are only able to use the org.json library after you've installed it.
import org.json.*;

public class Casino {

    public static void getMovieInfo(){
        // Create a HTTP Connection.
        String baseUrl = "https://api.themoviedb.org";
        String callAction = "/3/movie/";
        String movieId = "299536";
        String apiKey = "680201a1d38ff559b9c8b20ffde6db61";
        String urlString = baseUrl + callAction + movieId + "?api_key=" + apiKey + "&language=en-US";
        URL url;
        try {
            // Make the connection.
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Examine the response code.
            int status = con.getResponseCode();
            if (status != 200) {
                System.out.printf("Error: Could not load movie: " + status);
            } else {
                // Parsing input stream into a text string.
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                // Close the connections.
                in.close();
                con.disconnect();
                // Print out our complete JSON string.
                System.out.println("Output: " + content.toString());
                // Parse that object into a usable Java JSON object.
                JSONObject obj = new JSONObject(content.toString());
                // Print out the movie name.
                String movieName = obj.getString("original_title");
                System.out.println("Movie Name: " + movieName);
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            return;
        }
    }
}