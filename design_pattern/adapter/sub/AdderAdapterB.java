package adapter.sub;

public class AdderAdapterB extends StringAdderB {
    private final IntegerAdder adder;

    public AdderAdapterB() {
        this.adder = new IntegerAdder();
    }

    @Override
    public String add(String a, String b) {
        int intA = Integer.parseInt(a);
        int intB = Integer.parseInt(b);
        int result = adder.add(intA, intB);
        return String.valueOf(result);
    }
}
