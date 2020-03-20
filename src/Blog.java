public class Blog {
    private int id;
    private String header;
    private String content;
    private String image;

    public Blog(int id, String header, String content, String image) {
        this.id = id;
        this.header = header;
        this.content = content;
        this.image = image;
    }

    public Blog() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
