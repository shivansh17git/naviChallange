package operations;

import model.PortFolio;

public class PortFolioChange implements PortFolioAction {

    private Double equityChangeRate;

    private Double debtChangeRate;

    private Double goldChangeRate;

    private String month;

    PortFolioChange(Double equityChangeRate, Double debtChangeRate, Double goldChangeRate, String month) {
        this.equityChangeRate = equityChangeRate;
        this.debtChangeRate = debtChangeRate;
        this.goldChangeRate = goldChangeRate;
        this.month = month;
    }

    public static PortFolioChangeBuilder builder() {
        return new PortFolioChangeBuilder();
    }

    @Override
    public void execute(PortFolio portFolio) {

        if (portFolio.getPortFolioHistory().size() > 0)
            portFolio.sip();

        Double newEquity = portFolio.getEquity() * (1 + equityChangeRate);
        Double newDebt = portFolio.getDebt() * (1 + debtChangeRate);
        Double newGold = portFolio.getGold() * (1 + goldChangeRate);

        portFolio.update(newEquity, newDebt, newGold);

        final PortFolio pastPortFolio = new PortFolio(portFolio);
        portFolio.getPortFolioHistory().put(month, pastPortFolio);

        portFolio.updateAfterReBalance(month);
    }

    public static class PortFolioChangeBuilder {
        private Double equityChangeRate;
        private Double debtChangeRate;
        private Double goldChangeRate;
        private String month;

        PortFolioChangeBuilder() {
        }

        public PortFolioChangeBuilder equityChangeRate(Double equityChangeRate) {
            this.equityChangeRate = equityChangeRate;
            return this;
        }

        public PortFolioChangeBuilder debtChangeRate(Double debtChangeRate) {
            this.debtChangeRate = debtChangeRate;
            return this;
        }

        public PortFolioChangeBuilder goldChangeRate(Double goldChangeRate) {
            this.goldChangeRate = goldChangeRate;
            return this;
        }

        public PortFolioChangeBuilder month(String month) {
            this.month = month;
            return this;
        }

        public PortFolioChange build() {
            return new PortFolioChange(equityChangeRate, debtChangeRate, goldChangeRate, month);
        }

        public String toString() {
            return "PortFolioChange.PortFolioChangeBuilder(equityChangeRate=" + this.equityChangeRate + ", debtChangeRate=" + this.debtChangeRate + ", goldChangeRate=" + this.goldChangeRate + ", month=" + this.month + ")";
        }
    }
}
