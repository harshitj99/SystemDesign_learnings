//violation of single responsibility principle

class invoice{

    public double calculateTotal() {
        return 0.0;
    }

   void saveToDatabase() {
        // code to save invoice to database
    }

    void printInvoice() {
        // code to print invoice
    }
    
}

// Single Responsibility Principle

class Invoice {
    
    public double calculateTotal() {
        return 0.0;
    }
}

class InvoiceRepository {
    
    void saveToDatabase(Invoice invoice) {
        // code to save invoice to database
    }
}
class InvoicePrinter {
    
    void printInvoice(Invoice invoice) {
        // code to print invoice
    }
}
