package tw.com.lccnet.galleryapp.bean;

public class Anime {
    private String name;
    private String Description;
    private String rating;
    private int nb_episode;
    private String categorie;
    private String studio;
    private String images_url;


    public Anime() {
    }

    public Anime(String name, String description, String rating, int nb_episode, String categorie, String studio, String images_url) {
        this.name = name;
        Description = description;
        this.rating = rating;
        this.nb_episode = nb_episode;
        this.categorie = categorie;
        this.studio = studio;
        this.images_url = images_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNb_episode() {
        return nb_episode;
    }

    public void setNb_episode(int nb_episode) {
        this.nb_episode = nb_episode;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getImages_url() {
        return images_url;
    }

    public void setImages_url(String images_url) {
        this.images_url = images_url;
    }
}
