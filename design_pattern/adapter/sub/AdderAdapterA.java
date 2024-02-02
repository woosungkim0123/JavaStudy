package adapter.sub;

public class AdderAdapterA extends IntegerAdder implements StringAdderA {

    public AdderAdapterA() {
        super();
    }

    @Override
    public String add(String a, String b) {
        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);
        int result = add(intA, intB);
        return String.valueOf(result);
    }
}
