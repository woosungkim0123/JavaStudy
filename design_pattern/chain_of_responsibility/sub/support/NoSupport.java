package chain_of_responsibility.sub.support;

import chain_of_responsibility.sub.Support;
import chain_of_responsibility.sub.Trouble;

public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false; // 아무것도 해결하지 않음
    }
}
