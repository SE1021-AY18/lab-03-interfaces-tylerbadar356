/*
 * SE1011-061
 * Fall 2017
 * File purpose:
 * Name: Badar
 * Created: 
 */


import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * SE 1011-061 2017
 * Purpose: in your own words, what does this class do?
 *
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:29 PM.
 */
public class Assembly implements Part {
    private DecimalFormat costFormat = new DecimalFormat("$00.00");
    String name;
    ArrayList<Part> subParts = new ArrayList<>();
    public static final double USD_PER_SUB_PART = .25;
    public DecimalFormat weightFormat = new DecimalFormat("00.000 lbs");
    public Assembly(String name) {
        this.name = name;
    }
    public void addPart(Part part) {
        subParts.add(part);
    }

    @Override
    public double getCost() {
        double cost = 0;
        for (int i=1;i<=subParts.size();i++) {
            cost += subParts.get(i).getCost();
        }
        cost += subParts.size() * USD_PER_SUB_PART;
        return cost;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        double weight = 0;
        for (int i=1;i<=subParts.size();i++) {
            weight += subParts.get(i).getWeight();
        }
        return weight;
    }

    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.name + "\n====================\n");
        for (int i=1;i<=subParts.size();i++) {
            subParts.get(i).printBillOfMaterials();
        }
    }
}
