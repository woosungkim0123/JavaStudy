package builder.sub.normal;

public class Data {
    private String title;
    private String str;
    private String[] items;

    public Data(String title, String str, String[] items) {
        this.title = title;
        this.str = str;
        this.items = items;
    }

    public String getTitle() {
        return title;
    }

    public String getStr() {
        return str;
    }

    public String[] getItems() {
        return items;
    }
}
