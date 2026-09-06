package Templates.Creational;

/*
 * Classic Builder Pattern Assignment
 *
 * Problem:
 * A Computer object has many configuration steps. Different computer types
 * need different values, but the construction process should stay consistent.
 *
 * Student task:
 * 1. Complete the ComputerProduct fields, setters, and toString.
 * 2. Implement concrete builders for Gaming and Office computers.
 * 3. Implement the Director so it controls the build sequence.
 */

class ComputerProduct {
    private String cpu;
    private int ram;
    private int storage;
    private String gpu;
    private boolean hasWifi;

    void setCpu(String cpu) {
        // TODO: Store the cpu value.
    }

    void setRam(int ram) {
        // TODO: Store the ram value.
    }

    void setStorage(int storage) {
        // TODO: Store the storage value.
    }

    void setGpu(String gpu) {
        // TODO: Store the gpu value.
    }

    void setWifi(boolean hasWifi) {
        // TODO: Store the wifi value.
    }

    @Override
    public String toString() {
        // TODO: Return a readable summary of this computer.
        return "";
    }
}

interface ComputerBuilder {
    void buildCpu();

    void buildRam();

    void buildStorage();

    void buildGpu();

    void buildWifi();

    ComputerProduct getResult();
}

class GamingComputerBuilder implements ComputerBuilder {
    private final ComputerProduct computer = new ComputerProduct();

    @Override
    public void buildCpu() {
        // TODO: Choose a CPU suitable for a gaming computer.
    }

    @Override
    public void buildRam() {
        // TODO: Choose RAM suitable for a gaming computer.
    }

    @Override
    public void buildStorage() {
        // TODO: Choose storage suitable for a gaming computer.
    }

    @Override
    public void buildGpu() {
        // TODO: Choose a GPU suitable for a gaming computer.
    }

    @Override
    public void buildWifi() {
        // TODO: Choose whether this computer has Wi-Fi.
    }

    @Override
    public ComputerProduct getResult() {
        // TODO: Return the finished product.
        return null;
    }
}

class OfficeComputerBuilder implements ComputerBuilder {
    private final ComputerProduct computer = new ComputerProduct();

    @Override
    public void buildCpu() {
        // TODO: Choose a CPU suitable for an office computer.
    }

    @Override
    public void buildRam() {
        // TODO: Choose RAM suitable for an office computer.
    }

    @Override
    public void buildStorage() {
        // TODO: Choose storage suitable for an office computer.
    }

    @Override
    public void buildGpu() {
        // TODO: Choose a GPU suitable for an office computer.
    }

    @Override
    public void buildWifi() {
        // TODO: Choose whether this computer has Wi-Fi.
    }

    @Override
    public ComputerProduct getResult() {
        // TODO: Return the finished product.
        return null;
    }
}

class ComputerDirector {
    void construct(ComputerBuilder builder) {
        // TODO: Call the builder steps in the desired construction order.
    }
}

public class ClassicBuilderTemplate {
    public static void main(String[] args) {
        // TODO: Create a director.
        // TODO: Build a gaming computer using GamingComputerBuilder.
        // TODO: Build an office computer using OfficeComputerBuilder.
        // TODO: Print both results.
    }
}
