package prototype.framework;

import java.util.HashMap;
import java.util.Map;

public class ManagerA {
    private Map<String, ProductA> showcase = new HashMap<>();

    public void register(String name, ProductA prototype) {
        showcase.put(name, prototype);
    }

    public ProductA create(String prototypeName) {
        ProductA p = showcase.get(prototypeName);
        return p.createCopy();
    }
}
