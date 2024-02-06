package chain_of_responsibility.sub;

public class Trouble {
    private SolveType solveType;

    public Trouble(SolveType solveType) {
        this.solveType = solveType;
    }

    public SolveType getSolveType() {
        return solveType;
    }

    @Override
    public String toString() {
        return "[Trouble " + solveType + "]";
    }
}
