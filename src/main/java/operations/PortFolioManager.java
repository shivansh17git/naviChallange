package operations;

import model.PortFolio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortFolioManager {

    final static int EQUITY = 1;

    final static int DEBT = 2;

    final static int GOLD = 3;

    final static int MONTHS = 4;


    public static void execute(PortFolio portFolio, PortFolioAction action) {
        action.execute(portFolio);
    }

    public static PortFolioAction allocate(String[] instructions) {
        return PortFolioAllocate.builder()
                .debt(Double.parseDouble(instructions[DEBT]))
                .gold(Double.parseDouble(instructions[GOLD]))
                .equity(Double.parseDouble(instructions[EQUITY]))
                .build();
    }

    public static PortFolioAction sip(String[] instructions) {
        return PortFolioSIP.builder()
                .debtSIP(Double.parseDouble(instructions[DEBT]))
                .goldSIP(Double.parseDouble(instructions[GOLD]))
                .equitySIP(Double.parseDouble(instructions[EQUITY]))
                .build();
    }

    public static PortFolioAction change(String[] instructions) {
        return PortFolioChange.builder()
                .debtChangeRate(rate(instructions[DEBT]))
                .goldChangeRate(rate(instructions[GOLD]))
                .equityChangeRate(rate(instructions[EQUITY]))
                .month(instructions[MONTHS])
                .build();
    }

    private static Double rate(String parse) {
        Pattern p = Pattern.compile("^-?\\d+\\.?\\d+");
        Matcher m = p.matcher(parse);
        if(m.find())
        return Double.parseDouble(m.group())/100;
        return 0.0;
    }

    public static PortFolioAction print(String[] instructions) {
        return PortFolioBalance.builder()
                .month(instructions[1])
                .build();
    }

    public static PortFolioAction rebalance() {
        return (portFolio -> {portFolio.printLastReBalance();});
    }
}
