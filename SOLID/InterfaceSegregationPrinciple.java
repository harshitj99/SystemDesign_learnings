// ❌ VIOLATION of Interface Segregation Principle
// The Machine interface is too fat/bloated
// BasicPrinter is forced to implement print, scan, and fax
// But BasicPrinter only supports printing - it must throw exceptions for others
// Clients using BasicPrinter are forced to depend on methods they can't use

interface Machine {
    // PROBLEM: One interface with too many unrelated methods
    void print();
    void scan();
    void fax();
}

class BasicPrinter implements Machine {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        // ❌ VIOLATION: Forced to implement, but not supported
        throw new UnsupportedOperationException("Scan not supported");
    }

    @Override
    public void fax() {
        // ❌ VIOLATION: Forced to implement, but not supported
        throw new UnsupportedOperationException("Fax not supported");
    }
}

// ✅ INTERFACE SEGREGATION PRINCIPLE - CORRECT APPROACH
// Create small, focused interfaces
// A class implements ONLY the interfaces it actually supports

// Segregated, focused interfaces
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

// ✅ BasicPrinterV2 only implements what it supports
class BasicPrinterV2 implements Printer {
    @Override
    public void print() {
        // Can safely print
        System.out.println("Printing...");
    }
    // No forced exceptions!
}

// ✅ MultiFunctionPrinter implements multiple segregated interfaces
class MultiFunctionPrinter implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
    // Does NOT implement Fax - because it can't fax
}

// ✅ FaxMachine implements only what it needs
class FaxMachine implements Fax {
    @Override
    public void fax() {
        System.out.println("Faxing...");
    }
}

// ✅ NEW: Complete office device that can do everything
class CompleteOfficeDevice implements Printer, Scanner, Fax {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }

    @Override
    public void fax() {
        System.out.println("Faxing...");
    }
}

// ✅ PUBLIC CLASS: Main principle demonstration
public class InterfaceSegregationPrinciple {
    // Benefit: Clients use only the interfaces they need
    // Example usage:
    public void executePrintJob(Printer printer) {
        // Only depends on Printer interface - doesn't care about scan or fax
        printer.print();
    }
}

