package DesignPatterns.Creational.Builder;

class ComputerFluent {
    private final String cpu;
    private final int ram;
    private final int storage;
    private final String gpu;
    private final Boolean hasWifi;

    private ComputerFluent(Builder builder){
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.hasWifi = builder.hasWifi;
    }

    public String toString() {
        return "Computer [cpu=" + cpu + ", ram=" + ram + "GB, storage=" + storage
                + "GB, gpu=" + gpu + ", wifi=" + hasWifi + "]";
    }

    public static class Builder {
        private final String cpu;     // required
        private int ram = 8; //sensible default
        private int storage = 256;
        private String gpu = "Integrated";
        private boolean hasWifi = true;

        public Builder (String cpu){     //mandatory field forced via constructor
            this.cpu = cpu;
        }

        public Builder ram(int ram){ this.ram = ram; return this;}
        public Builder storage(int storage){ this.storage = storage; return this;}
        public Builder gpu(String gpu){ this.gpu = gpu; return this;}
        public Builder wifi(Boolean hasWifi){ this.hasWifi = hasWifi; return this;}

        public ComputerFluent build(){
            return new ComputerFluent(this);
        }
    }
    
}

class ComputerFluentDemo{
    public static void main(String[] args) {
        ComputerFluent gamingComputer = new ComputerFluent.Builder("Intel i9")
                       .ram(32)
                       .storage(1024)
                       .gpu("RTX 4090")
                       .wifi(true)
                       .build();
                       
        System.out.println(gamingComputer);               
    }
}
