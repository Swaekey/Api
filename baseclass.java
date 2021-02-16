package casino;

/**
 *
 * @author Keshawn
 */

import casino.api;
import casino.OpenBlackJack;


public class baseclass {

    // Here we designate the Translator that we want to use. In this case, the OpenMovieDatabaseAPITranslator.
    protected final static api myMovieAPI = new OpenBlackJack();

    // This commented out line of code would switch the API we're using for the entire application.
    // protected final static MovieApiInterface myMovieAPI = new InternetMovieDatabaseAPITranslator();
}
