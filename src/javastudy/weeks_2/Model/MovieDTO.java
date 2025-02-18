package javastudy.weeks_2.Model;

public class MovieDTO {
    private int movieId;	//번호
    private String title;	//제목
    private int viewCount;	//시청수
    private double rating;	//평점
    private String condition;


    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getViewCount() {
        return viewCount;
    }
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
    @Override
    public String toString() {
        return "MovieDTO [movieId=" + movieId + ", title=" + title + ", viewCount=" + viewCount + ", rating=" + rating
                + "]";
    }
}
