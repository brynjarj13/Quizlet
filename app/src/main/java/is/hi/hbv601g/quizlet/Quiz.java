package is.hi.hbv601g.quizlet;

class Quiz {
    private String id;
    private String name;
    private String genre;
    private int quizlength;
    private int image;

    public Quiz(String id, String name, String genre, int quizlength, int image){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quizlength = quizlength;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) { this.genre = genre; }

    public int getQuizlength() {
        return quizlength;
    }

    public void setQuizlength(int quizlength) {
        this.quizlength = quizlength;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}