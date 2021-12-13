package com.example.geektrust;

import model.PortFolio;
import operations.Command;
import operations.PortFolioManager;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        myMoney(args);
        /*
        Old procedural implementation
         */
        //OldImplementation.main1(args);
    }

    public static void myMoney(String[] args) {
        PortFolio portFolio = new PortFolio();
        try (Stream<String> fileLines = Files.lines(new File(args[0]).toPath())) {
            List<String> lines = fileLines.map(String::trim).filter(s -> !s.matches(" ")).collect(Collectors.toList());

            for (String line : lines) {
                String[] instructions = line.trim().split(" ");

                Command command = Command.valueOf(instructions[0]);

                switch (command) {
                    case ALLOCATE:
                        PortFolioManager.execute(portFolio, PortFolioManager.allocate(instructions));
                        break;
                    case SIP:
                        PortFolioManager.execute(portFolio, PortFolioManager.sip(instructions));
                        break;
                    case CHANGE:
                        PortFolioManager.execute(portFolio, PortFolioManager.change(instructions));
                        break;
                    case BALANCE:
                        PortFolioManager.execute(portFolio, PortFolioManager.print(instructions));
                        break;
                    case REBALANCE:
                        PortFolioManager.execute(portFolio, PortFolioManager.rebalance());
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
