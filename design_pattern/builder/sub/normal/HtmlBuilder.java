package builder.sub.normal;

public class HtmlBuilder extends Builder{

    public HtmlBuilder(Data data) {
        super(data);
    }

    @Override
    public String makeTitle() {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>" + data.getTitle() + "</title></head><body>\n");
        sb.append("<h1>" + data.getTitle() + "</h1>\n");
        return sb.toString();
    }

    @Override
    public String makeString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<p>" + data.getStr() + "</p>\n");

        return sb.toString();
    }

    @Override
    public String makeItems() {
        StringBuilder sb = new StringBuilder();

        sb.append("<ul>\n");
        for (String item : data.getItems()) {
            sb.append("<li>" + item + "</li>\n");
        }
        sb.append("</ul>\n");

        return sb.toString();
    }
}
