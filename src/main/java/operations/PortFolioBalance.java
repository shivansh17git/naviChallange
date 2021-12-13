package operations;

import model.PortFolio;
public class PortFolioBalance implements PortFolioAction {

    String month;

    PortFolioBalance(String month) {
        this.month = month;
    }

    public static PortFolioBalanceBuilder builder() {
        return new PortFolioBalanceBuilder();
    }

    @Override
    public void execute(PortFolio portFolio) {
        System.out.println(portFolio.getPortFolioHistory().get(month));
    }

    public static class PortFolioBalanceBuilder {
        private String month;

        PortFolioBalanceBuilder() {
        }

        public PortFolioBalanceBuilder month(String month) {
            this.month = month;
            return this;
        }

        public PortFolioBalance build() {
            return new PortFolioBalance(month);
        }

        public String toString() {
            return "PortFolioBalance.PortFolioBalanceBuilder(month=" + this.month + ")";
        }
    }
}
