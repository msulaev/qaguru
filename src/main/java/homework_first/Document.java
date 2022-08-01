public class Document {
    private int size;
    private String name;
    private String type;

    public int getSize() {
        return size;
    }

    public Document(int size, String name, String type) {
        this.size = size;
        this.name = name;
        this.type = type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void checkSize() {
        if (this.size > 1000) {
            System.out.println("Too big");
        }
    }

    public void typeCheck() {
        if (!(this.type.equalsIgnoreCase("PDF"))) {
            System.out.println("This type of Document doens't support");
        }
    }
}
