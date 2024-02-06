package chain_of_responsibility.sub.support;

import chain_of_responsibility.sub.SolveType;
import chain_of_responsibility.sub.Support;
import chain_of_responsibility.sub.Trouble;

public class DesignSupport extends Support {

    public DesignSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getSolveType() == SolveType.DESIGN) {
            return true;
        }

        return false;
    }
}
