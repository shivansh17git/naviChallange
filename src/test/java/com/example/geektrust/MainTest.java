package com.example.geektrust;

import model.PortFolio;
import operations.PortFolioManager;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void testCreateMonths() {
        List<String> months = OldImplementation.createMonths();
        assertNotNull(months);
    }

    @Test
    public void changeGains() {
        PortFolio portFolio = new PortFolio();
        portFolio.allocate(6000.0 , 3000.0 , 1000.0);
        String[] instructions = parseInstruction("CHANGE 4.00% 10.00% 2.00% JANUARY");
        PortFolioManager.execute(portFolio , PortFolioManager.change(instructions));
        PortFolio expected = new PortFolio(6240.0	,3300.0	,1020.0);
        assertTrue(portFolio.equals(expected));
    }



    @Test
    public void calculatePercent() {
        PortFolio portFolio = new PortFolio();
        portFolio.allocate(6000.0 , 3000.0 , 1000.0);
        assertEquals(portFolio.getEquityRatio().doubleValue() , 0.6);
        assertEquals(portFolio.getDebtRatio().doubleValue() , 0.3);
        assertEquals(portFolio.getGoldRatio().doubleValue() , 0.1);
    }

    @Test
    public void printBalance() {
        PortFolio portFolio = new PortFolio();
        portFolio.allocate(6000.0 , 3000.0 , 1000.0);
        String[] instructions = parseInstruction("CHANGE 4.00% 10.00% 2.00% JANUARY");
        PortFolioManager.execute(portFolio , PortFolioManager.change(instructions));
        assertTrue("6240 3300 1020".equals(portFolio.toString()));
    }

    String[] parseInstruction(String line) {
        return line.trim().split(" ");
    }
}