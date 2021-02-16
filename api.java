package casino;
import models.Actor;
/**
 *
 * @author Keshawn
 */
public interface api {
    public String loadMovieTitleById(int _id);

    public int loadMovieIdByTitle(String _title);

    public Actor loadActorById(int _id);

}
