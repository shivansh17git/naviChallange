package operations;

import model.PortFolio;

public final class PortFolioSIP implements PortFolioAction {

    private final Double equitySIP;

    private final Double debtSIP;

    private final Double goldSIP;

    PortFolioSIP(Double equitySIP, Double debtSIP, Double goldSIP) {
        this.equitySIP = equitySIP;
        this.debtSIP = debtSIP;
        this.goldSIP = goldSIP;
    }

    public static PortFolioSIPBuilder builder() {
        return new PortFolioSIPBuilder();
    }

    @Override
    public void execute(final PortFolio portFolio) {
        portFolio.setPortFolioSIP(this);
    }

    public Double getEquitySIP() {
        return this.equitySIP;
    }

    public Double getDebtSIP() {
        return this.debtSIP;
    }

    public Double getGoldSIP() {
        return this.goldSIP;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PortFolioSIP)) return false;
        final PortFolioSIP other = (PortFolioSIP) o;
        final Object this$equitySIP = this.getEquitySIP();
        final Object other$equitySIP = other.getEquitySIP();
        if (this$equitySIP == null ? other$equitySIP != null : !this$equitySIP.equals(other$equitySIP)) return false;
        final Object this$debtSIP = this.getDebtSIP();
        final Object other$debtSIP = other.getDebtSIP();
        if (this$debtSIP == null ? other$debtSIP != null : !this$debtSIP.equals(other$debtSIP)) return false;
        final Object this$goldSIP = this.getGoldSIP();
        final Object other$goldSIP = other.getGoldSIP();
        if (this$goldSIP == null ? other$goldSIP != null : !this$goldSIP.equals(other$goldSIP)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $equitySIP = this.getEquitySIP();
        result = result * PRIME + ($equitySIP == null ? 43 : $equitySIP.hashCode());
        final Object $debtSIP = this.getDebtSIP();
        result = result * PRIME + ($debtSIP == null ? 43 : $debtSIP.hashCode());
        final Object $goldSIP = this.getGoldSIP();
        result = result * PRIME + ($goldSIP == null ? 43 : $goldSIP.hashCode());
        return result;
    }

    public String toString() {
        return "PortFolioSIP(equitySIP=" + this.getEquitySIP() + ", debtSIP=" + this.getDebtSIP() + ", goldSIP=" + this.getGoldSIP() + ")";
    }

    public static class PortFolioSIPBuilder {
        private Double equitySIP;
        private Double debtSIP;
        private Double goldSIP;

        PortFolioSIPBuilder() {
        }

        public PortFolioSIP.PortFolioSIPBuilder equitySIP(Double equitySIP) {
            this.equitySIP = equitySIP;
            return this;
        }

        public PortFolioSIP.PortFolioSIPBuilder debtSIP(Double debtSIP) {
            this.debtSIP = debtSIP;
            return this;
        }

        public PortFolioSIP.PortFolioSIPBuilder goldSIP(Double goldSIP) {
            this.goldSIP = goldSIP;
            return this;
        }

        public PortFolioSIP build() {
            return new PortFolioSIP(equitySIP, debtSIP, goldSIP);
        }

        public String toString() {
            return "PortFolioSIP.PortFolioSIPBuilder(equitySIP=" + this.equitySIP + ", debtSIP=" + this.debtSIP + ", goldSIP=" + this.goldSIP + ")";
        }
    }
}
