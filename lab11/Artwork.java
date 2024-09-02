class Artwork {
    String artistName;
    String title;
    String medium;
    int year;
    double value;

    // Constructor to initialize an Artwork object with provided details
    public Artwork(String artistName, String title, String medium, int year, double value) {
        this.artistName = artistName;
        this.title = title;
        this.medium = medium;
        this.year = year;
        this.value = value;
    }

    // Override toString method to provide a string representation of the Artwork object
    @Override
    public String toString() {
        return "Artwork{" +
                "artistName='" + artistName + '\'' +
                ", title='" + title + '\'' +
                ", medium='" + medium + '\'' +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}