# Lab 3: Interfaces

## Objectives
- Translate UML class diagrams into source code
- Construct software using a interface
- Employ aggregation and composition in the development of software

## Assignment
In this lab, you will write a program for managing the parts needed to assemble a machine. Your program will provide a complete bill of materials including both the weight and cost for each part.

To facilitate a wide variety of parts, your program should make use of a generic Part interface. This interface will allow generic information about a part to be accessed:

- The part’s name
- The total cost of the part
- The total weight of the part
- The bill of materials for a part

There are a few kinds of parts that the system supports:

- Nuts
- Bolts
- Sheet metal
- Duplicate parts
- Assemblies of parts
- Nuts, bolts, and sheet metal are basic parts. Duplicate parts and assemblies are built out of other pre-existing parts.

## Assignment Details
A class diagram for the program is shown in the figure below:
![Lab3 UML](http://msoe.us/taylor/se1021/parts.gif)

Implement all of the classes shown in the diagram above based on the discussion that follows. The arrows with black diamonds simply indicate that one class has a reference to another, as is already shown in the member variables of the class diagrams for Assembly and Duplicate part.

- A nut costs $0.50×size$0.50×size, where size is the inner diameter of the nut in inches. A nut weights 0.01lbs×(size)20.01lbs×(size)^2.
- A bolt costs $1×diameter×length$1×diameter×length, where diameterdiameter is the diameter of the threads in inches and lengthlength is the overall length of the bolt in inches. A bolt weighs 0.05lbs×(diameter)^2×length0.05lbs×(diameter)2×length.
- Sheet metal costs $0.50×thickness×width×length$0.50×thickness×width×length, where each of the dimensions is measured in inches. Sheet metal weighs 0.1lbs×thickness×width×length0.1lbs×thickness×width×length.

Bolts, nuts, and sheet-metal print a simple bill of materials including the name of the part in the title and the dimensions, cost, and weight of the part. For example, this is a Bill of Materials for a Sheet:

```
==========================
12.0x12.0x0.25 sheet
==========================
Length: 12.0 inches
Width: 12.0 inches
Thickness: 0.25 inches
Cost: $18.00
Weight: 3.6 lbs
```
A duplicate part represents count identical parts. Its cost and weight are both count times the cost and weight of the single part. However, if there are at least 5 identical parts, there is a 5% discount off the cost of the duplicate parts, and if there are at least 10 identical parts, the discount increases to 10% discount off the cost of the duplicate parts. The duplicate part stores a single reference to another object describing just one of the identical parts.

A duplicate part’s Bill of Materials includes both a summary section and the bill of materials for the part that is duplicated. The summary section includes the duplicate part’s name on a title line. Below the title line are the name, cost, and weight of the individual part, along with the number of copies of that part. It prints the total cost and weight for the duplicate part. After the summary comes the complete bill of materials for the individual part.

For example, the fan option in the program MachineDriver.java is a duplicate part consisting of five identical blades. When the ```printBillOfMaterials()``` is called on the dupicate part, it prints:

```
Building a fan
==========================
5 8.0x6.0x0.0625 sheets
==========================
Duplicate part: 8.0x6.0x0.0625 sheet
Copies: 5
Individual cost: $1.50
Individual weight: 0.3 lbs
 
Total cost: $7.12
Total weight: 1.5 lbs
 
==========================
8.0x6.0x0.0625 sheet
==========================
Length: 8.0 inches
Width: 6.0 inches
Thickness: 0.0625 inches
Cost: $1.50
Weight: 0.3 lbs
```

An assembly consists of multiple different parts. Both the cost and weight of the assembly are determined by adding the cost and weight of each part in the assembly. However, the assembly has an additional construction cost which is $0.25 per sub-part in the assembly. The assembly maintains a List of all the parts that are stored in it.

A duplicate part or an assembly may be a sub-part of another part. For example, in the cube option in the program MachineDriver.java, the cube consists of two parts: a set of metal sheets and several sets of nut-bolt pairs. The set of sheets is actually a duplicate part, consisting of six identical pieces of sheet metal. The sets of nut-bolt pairs are also a duplicate part, consisting of 36 identical nut-bolt pairs. Each nut-bolt pair is an assembly, consisting of both a nut and a bolt. This hierarchy of parts is illustrated in the diagram below.

![parts](http://msoe.us/taylor/se1021/partsHierarchy.png)

When a duplicate part or assembly prints the bill of materials, it first prints a summary of each part (including name, cost, and weight for each part), then prints the full bill of materials for each part.

For example, the bill of materials for the cube in MachineDriver.java is:

```
==========================
Cube
==========================
Part: 36 Nut-Bolt Pairs
Cost: $36.45
Weight: 0.247 lbs
Part: 6 12.0x12.0x0.25 sheets
Cost: $102.60
Weight: 21.6 lbs
Total cost: $139.55
Total weight: 21.848 lbs
==========================
36 Nut-Bolt Pairs
==========================
Duplicate part: Nut-Bolt Pair
Copies: 36
Individual cost: $1.12
Individual weight: 0.007 lbs
Total cost: $36.45
Total weight: 0.247 lbs
==========================
Nut-Bolt Pair
==========================
Part: 0.25x2.0 bolt
Cost: $0.50
Weight: 0.006 lbs
Part: 0.25 inch nut
Cost: $0.12
Weight: 0.001 lbs
Total cost: $1.12
Total weight: 0.007 lbs
==========================
0.25x2.0 bolt
==========================
Diameter: 0.25 inches
Length: 2.0 inches
Cost: $0.50
Weight: 0.006 lbs
==========================
0.25 inch nut
==========================
Diameter: 0.25 inches
Cost: $0.12
Weight: 0.001 lbs
==========================
6 12.0x12.0x0.25 sheets
==========================
Duplicate part: 12.0x12.0x0.25 sheet
Copies: 6
Individual cost: $18.00
Individual weight: 3.6 lbs
Total cost: $102.60
Total weight: 21.6 lbs
==========================
12.0x12.0x0.25 sheet
==========================
Length: 12.0 inches
Width: 12.0 inches
Thickness: 0.25 inches
Cost: $18.00
Weight: 3.6 lbs
```

As shown in the example above, format numeric values cleanly. In particular, dollar amounts should always include two places after the decimal.

You may add new options to the example program, but do not edit the options provided in the example. Let the single printBillOfMaterials() call print everything.

## Appendix: Shovel option
As a final example, the shovel option in the example program produces an assembly consisting of three different parts.

```
==========================
Shovel
==========================
Part: 30.0x3.0x0.125 sheet
Cost: $5.62
Weight: 1.125 lbs
Part: 10.0x8.0x0.25 sheet
Cost: $10.00
Weight: 2 lbs
Part: 0.125x0.5 bolt
Cost: $0.06
Weight: 0 lbs
Total cost: $16.44
Total weight: 3.125 lbs
==========================
30.0x3.0x0.125 sheet
==========================
Length: 30.0 inches
Width: 3.0 inches
Thickness: 0.125 inches
Cost: $5.62
Weight: 1.125 lbs

[... more sub-parts ...]
```