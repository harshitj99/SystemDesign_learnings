package Templates.Creational;

/*
 * Fluent Builder Pattern Assignment
 *
 * Problem:
 * A Computer has required values and optional values. The caller should be able
 * to chain only the optional settings they care about.
 *
 * Student task:
 * 1. Keep Computer immutable from the outside.
 * 2. Force the required field through the Builder constructor.
 * 3. Return the same Builder from each optional method to support chaining.
 * 4. Create the Computer only inside build().
 */

class FluentComputer {
    private final String cpu;
    private final int ram;
    private final int storage;
    private final String gpu;
    private final boolean hasWifi;

    private FluentComputer(Builder builder) {
        // TODO: Copy values from builder fields into this object.
        this.cpu = null;
        this.ram = 0;
        this.storage = 0;
        this.gpu = null;
        this.hasWifi = false;
    }

    @Override
    public String toString() {
        // TODO: Return a readable summary of this computer.
        return "";
    }

    static class Builder {
        private final String cpu;
        private int ram;
        private int storage;
        private String gpu;
        private boolean hasWifi;

        Builder(String cpu) {
            // TODO: Store the required CPU value.
            // TODO: Set sensible default values for optional fields.
            this.cpu = null;
        }

        Builder ram(int ram) {
            // TODO: Store RAM and return this builder.
            return null;
        }

        Builder storage(int storage) {
            // TODO: Store storage and return this builder.
            return null;
        }

        Builder gpu(String gpu) {
            // TODO: Store GPU and return this builder.
            return null;
        }

        Builder wifi(boolean hasWifi) {
            // TODO: Store Wi-Fi preference and return this builder.
            return null;
        }

        FluentComputer build() {
            // TODO: Create and return the final FluentComputer.
            return null;
        }
    }
}

public class FluentBuilderTemplate {
    public static void main(String[] args) {
        // TODO: Create one FluentComputer using chained builder calls.
        // Example shape:
        // new FluentComputer.Builder("required cpu").ram(...).storage(...).build();
        // TODO: Print the result.
    }
}
