package DesignPatterns.Creational.Builder;

class ComputerImproved {
    private String cpu;
    private int ram;
    private int storage;
    private String gpu;
    private Boolean hasWifi;

    void setCpu(String cpu){ this.cpu = cpu; }
    void setRam(int ram){ this.ram = ram; }
    void setStorage(int storage){ this.storage = storage; }
    void setGpu(String gpu){ this.gpu = gpu; }
    void setWifi(Boolean hasWifi){ this.hasWifi = hasWifi; }

    public String toString(){
        return "Computer [ cpu=" + cpu + ", RAM=" + ram + "GB, Storage=" + storage + "GB, GPU=" + gpu + ", Wifi=" + hasWifi + "]";
    }

}

interface IComputerBuilder {
  void buildCpu();
  void buildRam();
  void buildStorage();
  void buildGpu();
  void buildWifi();
  ComputerImproved getResult();
    
}

class GamingComputerBuilder implements IComputerBuilder{
  private final ComputerImproved computer = new ComputerImproved();

  @Override
  public void buildCpu(){ computer.setCpu("Intel i9"); }

  @Override
  public void buildRam(){ computer.setRam(32); }

  @Override
  public void buildStorage(){ computer.setStorage(1000); }

  @Override
  public void buildGpu(){ computer.setGpu("RTX 4090"); }

  @Override
  public void buildWifi(){ computer.setWifi(true); }

  @Override
  public ComputerImproved getResult(){
    return computer;
  }
}

class OfficeComputerBuilder implements IComputerBuilder{
    private final ComputerImproved computer = new ComputerImproved();

  @Override
  public void buildCpu(){ computer.setCpu("Intel i5"); }

  @Override
  public void buildRam(){ computer.setRam(8); }

  @Override
  public void buildStorage(){ computer.setStorage(256); }

  @Override
  public void buildGpu(){ computer.setGpu("Integrated"); }

  @Override
  public void buildWifi(){ computer.setWifi(false); }

  @Override
  public ComputerImproved getResult(){
    return computer;
  }
}

// Director knows the assembly recipe

class ComputerDirector{
    void construct(IComputerBuilder builder){
        builder.buildCpu();
        builder.buildGpu();
        builder.buildRam();
        builder.buildStorage();
        builder.buildWifi();
    }
}


// USAGE
class ComputerBuilderDemo {
    public static void main(String[] args) {
        // Director orchestrates the construction
        ComputerDirector director = new ComputerDirector();
        
        // Building a Gaming Computer
        System.out.println("--- Building Gaming Computer ---");
        IComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.construct(gamingBuilder);
        System.out.println(gamingBuilder.getResult());
        // ComputerImproved gamingComputer = gamingBuilder.getResult();
        // System.out.println(gamingComputer);
        
        // Building an Office Computer
        System.out.println("\n--- Building Office Computer ---");
        IComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.construct(officeBuilder);
        System.out.println(officeBuilder.getResult());
        // ComputerImproved officeComputer = officeBuilder.getResult();
        // System.out.println(officeComputer);
        
        // Director ensures consistent building process for different types
        // Each builder handles its own specific configurations
    }
}

//Why the industry mostly dropped the Director

// The Director made sense in the original GoF book because it modeled fixed, reusable assembly recipes — useful when
// the same exact sequence gets built repeatedly across an app. In practice, most Java code doesn't need that 
// extra layer: the fluent builder is simpler, reads better at the call site, and callers naturally just call 
// whichever chained methods they need in whatever order suits them. You'll still encounter the classic four-role 
// structure in some frameworks and in interview questions (worth knowing), but day-to-day, "Builder pattern" 
// in Java almost always means the fluent inner-class version.