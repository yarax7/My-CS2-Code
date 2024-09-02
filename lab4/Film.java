public class Film{
    String title;
    String director;
    String genre;
    int releaseYear;
    double rating;
    Film next;

    public Film() {
    }

    public Film(String title, String director, String genre, int releaseYear, double rating) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }


    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                "\nDirector: " + director +
                "\nGenre: " + genre +
                "\nRelease Year: " + releaseYear +
                "\nRating: " + rating + "\n";
    }
}