package casino;

/**
 *
 * @author Keshawn
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import models.Actor;
import org.json.JSONObject;

public class OpenBlackJack implements api {

    private static final String baseURL = "https://api.themoviedb.org";
    private static final String apiKey = "680201a1d38ff559b9c8b20ffde6db61";

    /**
     * Given an id number, this method queries the MovieDbApi for a movie title and
     * returns it.
     * @param _id
     * @return String - the movie title.
     */
    @Override
    public String loadMovieTitleById (int _id) {
       // Build the base url string.
       String searchString = "/3/movie/" + _id + "?api_key=" + OpenBlackJack.apiKey +  "&language=en-US";
        try {
            URL url = new URL(OpenBlackJack.baseURL + searchString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            // Build the content from the buffered input.
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            // Close the connections.
            in.close();
            con.disconnect();
            // Extract the JSON object.
            JSONObject obj = new JSONObject(content.toString());
            String movieName = obj.getString("original_title");
            return movieName;
        } catch (Exception ex) {
            //Logger.getLogger(MovieApp.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * STUB: This stub method returns a dummy value of 12.
     * @param _title
     * @return int - the movie ID.
     */
    @Override
    public int loadMovieIdByTitle(String _title) {
        return 12;
    }

    @Override
    public Actor loadActorById(int _id) {
        return null;
    }
}