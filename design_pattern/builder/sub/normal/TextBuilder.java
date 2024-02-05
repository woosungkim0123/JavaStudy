package builder.sub.normal;

public class TextBuilder extends Builder{

    public TextBuilder(Data data) {
        super(data);
    }

    @Override
    public String makeTitle() {
        StringBuilder sb = new StringBuilder();
        String title = data.getTitle();
        sb.append("『" + title + "』\n");
        sb.append("\n");

        return sb.toString();
    }

    @Override
    public String makeString() {
        StringBuilder sb = new StringBuilder();
        String str = data.getStr();
        sb.append("■ " + str + "\n");
        sb.append("\n");

        return sb.toString();
    }

    @Override
    public String makeItems() {
        StringBuilder sb = new StringBuilder();
        String[] items = data.getItems();
        for (String item : items) {
            sb.append(" ・" + item + "\n");
        }
        sb.append("\n");

        return sb.toString();
    }
}
