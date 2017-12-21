/*
 * SE1021
 * Winter 2017-2018
 * Lab 3 - Interfaces
 * Created: 12/14/2016
 */
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * SE1021 2017
 * Purpose: Creates an assembly which implements the Part interface and is made up of
 * duplicates and other assembly objects
 * @author badartt
 * @version 1.0 Created on 12/14/2017 at 3:29 PM.
 */
public class Assembly implements Part {
    private DecimalFormat costFormat = new DecimalFormat("$#0.00");
    String name;
    ArrayList<Part> subParts = new ArrayList<>();
    /**
     * cost multiplier
     */
    public static final double USD_PER_SUB_PART = .25;
    /**
     * weight format pattern
     */
    public DecimalFormat weightFormat = new DecimalFormat("##.### lbs");

    /**
     * Constructor for Assembly, sets the name
     * @param name the name for the assembly
     */
    public Assembly(String name) {
        this.name = name;
    }

    /**
     * adds a part to the assembly
     * @param part part to be added
     */
    public void addPart(Part part) {
        subParts.add(part);
    }

    /**
     * calculates cost by adding together each parts cost
     * multiplied by the cost multiplier
     * @return returns cost calculated
     */
    @Override
    public double getCost() {
        double cost = 0;
        for (int i=0;i<subParts.size();i++) {
            cost += subParts.get(i).getCost();
        }
        cost += subParts.size() * USD_PER_SUB_PART;
        return cost;
    }

    /**
     * name of the assembly
     * @return returns name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * calculates the weight by adding the weight of each part together
     * @return returns weight calculated
     */
    @Override
    public double getWeight() {
        double weight = 0;
        for (int i=0;i<subParts.size();i++) {
            weight += subParts.get(i).getWeight();
        }
        return weight;
    }

    /**
     * prints the name, cost, and weight of each part, the total cost and weight
     * of the assembly, and then the bill of materials for each sub part
     */
    @Override
    public void printBillOfMaterials() {
        System.out.println("====================\n" +
                this.name + "\n====================");
        for (int i=0;i<subParts.size();i++) {
            System.out.println("Part: " + subParts.get(i).getName() + "s\n" +
                    "Cost: " + costFormat.format(subParts.get(i).getCost()) + "\n" +
                    "Weight: " + weightFormat.format(subParts.get(i).getWeight()) + "\n");
        }
        System.out.println("TotalCost: " + costFormat.format(this.getCost()) + "\n" +
                "Total weight: " + weightFormat.format(this.getWeight()) + "\n");
        for (int i=0;i<subParts.size();i++) {
            subParts.get(i).printBillOfMaterials();
        }
    }
}
