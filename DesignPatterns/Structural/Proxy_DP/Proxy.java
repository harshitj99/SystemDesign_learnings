package DesignPatterns.Structural.Proxy_DP;

// Real-world scenario 1: Virtual Proxy — lazy loading

//Context:Exactly the image-gallery problem —very common in real apps(image galleries, video thumbnails, large documents)

interface Image{
    void display();
}

// The real, expensive object

class RealImages implements Image{
    private String filename;
    RealImages(String filename){
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk...");
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }

}

// The proxy — same interface, but delays creating the real object

class ProxyImage implements Image{
    private String filename;
    private RealImages image;
    ProxyImage(String filename){
        this.filename = filename;
    }

    public void display(){
        if(image == null){
            image = new RealImages(filename);  // only NOW does the expensive load happen
        }
        image.display();
    }
}
public class Proxy {

    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("vacation_photo.jpg");
        System.out.println("Image object created, but nothing loaded yet");

        image.display();  // Loading vacation_photo.jpg from disk...  /  Displaying vacation_photo.jpg
        image.display();  // Displaying vacation_photo.jpg   ← no reload, realImage already exists
    }
    
}
