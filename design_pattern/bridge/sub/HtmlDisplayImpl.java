package bridge.sub;

public class HtmlDisplayImpl extends DisplayImpl {
    private String string;

    public HtmlDisplayImpl(String string) {
        this.string = string;
    }

    @Override
    public void rawOpen() {
        System.out.println("<html><head><title>Bridge</title></head><body>");
    }

    @Override
    public void rawPrint() {
        System.out.println("<p>" + string + "</p>");
    }

    @Override
    public void rawClose() {
        System.out.println("</body></html>");
    }
}
