package android.example.helpinghands.Domain;

public class novelDomain {
    private String tittle;
    private String pic;
    private String category;
    private String price;
    private String description;

    public novelDomain(String tittle, String pic, String category, String price, String description) {
        this.tittle = tittle;
        this.pic = pic;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
