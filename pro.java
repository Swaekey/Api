package casino;

/**
 *
 * @author Keshawn
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.json.*;

/**
 * This prototype demonstrates a call to an API.
 * @author Ike
 */
public class pro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a HTTP Connection.
        String baseUrl = "https://api.themoviedb.org";
        String callAction = "/3/movie/";
        String movieId = "299536";
        String apiKey = "680201a1d38ff559b9c8b20ffde6db61";
        String urlString = baseUrl + callAction + movieId + "?api_key=" + apiKey + "&language=en-US";
        URL url;
        System.out.println("Marker 1");
        try {
        System.out.println("Marker 2");
            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
        System.out.println("Marker 3");

            int status = con.getResponseCode();
            System.out.println("Response Code: " + status);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            System.out.println("Output: " + content.toString());
            JSONObject obj = new JSONObject(content.toString());
            String movieName = obj.getString("original_title");
            System.out.println("Movie Name: " + movieName);
        } catch (Exception ex) {
            Logger.getLogger(pro.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

    }

}
