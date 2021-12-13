package model;

import operations.PortFolioSIP;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class PortFolio {

    private Double equity;

    private Double debt;

    private Double gold;

    private Double equityRatio;

    private Double debtRatio;

    private Double goldRatio;

    private Optional<PortFolio> lastReBalancePortFolio = Optional.empty();

    private Map<String, PortFolio> portFolioHistory;

    private PortFolioSIP portFolioSIP;

    public PortFolio() {
        portFolioHistory = new LinkedHashMap<>();
    }

    public PortFolio(PortFolio portFolio) {
        this.equity = portFolio.equity;
        this.debt = portFolio.debt;
        this.gold = portFolio.gold;
    }

    public PortFolio(Double newEquity, Double newDebt, Double newGold) {
        equity = newEquity;
        debt = newDebt;
        gold = newGold;
    }


    public Double getTotal() {
        return equity + debt + gold;
    }

    public void allocate(Double newEquity, Double newDebt, Double newGold) {
        update(newEquity, newDebt, newGold);
        this.equityRatio = equity / getTotal();
        this.debtRatio = debt / getTotal();
        this.goldRatio = gold / getTotal();
        portFolioHistory = new HashMap<>();
    }

    public void update(Double newEquity, Double newDebt, Double newGold) {
        equity = newEquity;
        debt = newDebt;
        gold = newGold;
    }

    @Override
    public String toString() {
        return equity.shortValue() + " " + debt.shortValue() + " " + gold.shortValue();
    }

    public void updateAfterReBalance(String month) {
        if (this.portFolioHistory.size() % 6 == 0) {
            Double equityRatio = getEquityRatio();
            Double debtRatio = getDebtRatio();
            Double goldRatio = getGoldRatio();
            Double total = getTotal();
            equity = total * equityRatio;
            debt = total * debtRatio;
            gold = total * goldRatio;
            lastReBalancePortFolio = Optional.of(new PortFolio(this));
            portFolioHistory.put(month, lastReBalancePortFolio.get());
        }
    }


    public void printLastReBalance() {
        if (getLastReBalancePortFolio().isPresent()) {
            System.out.println(getLastReBalancePortFolio().get());
        } else {
            System.out.println("CANNOT_REBALANCE");
        }
    }

    public void sip() {
        update(portFolioSIP.getEquitySIP() + equity,
                portFolioSIP.getDebtSIP() + debt,
                portFolioSIP.getGoldSIP() + gold);
    }

    public Double getEquity() {
        return this.equity;
    }

    public Double getDebt() {
        return this.debt;
    }

    public Double getGold() {
        return this.gold;
    }

    public Double getEquityRatio() {
        return this.equityRatio;
    }

    public Double getDebtRatio() {
        return this.debtRatio;
    }

    public Double getGoldRatio() {
        return this.goldRatio;
    }

    public Optional<PortFolio> getLastReBalancePortFolio() {
        return this.lastReBalancePortFolio;
    }

    public Map<String, PortFolio> getPortFolioHistory() {
        return this.portFolioHistory;
    }

    public PortFolioSIP getPortFolioSIP() {
        return this.portFolioSIP;
    }

    public void setPortFolioSIP(PortFolioSIP portFolioSIP) {
        this.portFolioSIP = portFolioSIP;
    }

    @Override
    public boolean equals(final Object o) {
        if (o instanceof PortFolio) {
            PortFolio p = (PortFolio) o;
            return p.toString().equals(this.toString());
        }
        return false;
    }
}
