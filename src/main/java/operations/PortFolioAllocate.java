package operations;

import model.PortFolio;

public class PortFolioAllocate implements PortFolioAction {

    private Double equity;

    private Double debt;

    private Double gold;

    PortFolioAllocate(Double equity, Double debt, Double gold) {
        this.equity = equity;
        this.debt = debt;
        this.gold = gold;
    }

    public static PortFolioAllocateBuilder builder() {
        return new PortFolioAllocateBuilder();
    }

    @Override
    public void execute(PortFolio portFolio) {
        portFolio.allocate(equity, debt, gold);
    }

    public static class PortFolioAllocateBuilder {
        private Double equity;
        private Double debt;
        private Double gold;

        PortFolioAllocateBuilder() {
        }

        public PortFolioAllocateBuilder equity(Double equity) {
            this.equity = equity;
            return this;
        }

        public PortFolioAllocateBuilder debt(Double debt) {
            this.debt = debt;
            return this;
        }

        public PortFolioAllocateBuilder gold(Double gold) {
            this.gold = gold;
            return this;
        }

        public PortFolioAllocate build() {
            return new PortFolioAllocate(equity, debt, gold);
        }

        public String toString() {
            return "PortFolioAllocate.PortFolioAllocateBuilder(equity=" + this.equity + ", debt=" + this.debt + ", gold=" + this.gold + ")";
        }
    }
}
