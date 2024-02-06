package chain_of_responsibility.sub.support;

import chain_of_responsibility.sub.SolveType;
import chain_of_responsibility.sub.Support;
import chain_of_responsibility.sub.Trouble;

public class ItSupport extends Support {

    public ItSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getSolveType() == SolveType.IT) {
            return true;
        }

        return false;
    }
}
