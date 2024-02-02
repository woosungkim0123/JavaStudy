package prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class ManagerB {
    private Map<String, ProductB> showcase = new HashMap<>();

    public void register(String name, ProductB prototype) {
        showcase.put(name, prototype);
    }

    public ProductB create(String prototypeName) {
        ProductB p = showcase.get(prototypeName);
        return p.createCopy();
    }
}
