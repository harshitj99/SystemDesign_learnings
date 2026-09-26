package DesignPatterns.Structural.Proxy_DP;


// The problem: sometimes you need to control access to an object, not just add features

//Imagine an app that displays high-resolution images — but loading each image from disk is slow, 
//and you don't want to pay that cost until the user actually needs to see it. Or imagine a system
// where only certain users should be allowed to call a particular method. Direct access to the 
// real object doesn't give you a place to intervene:
class RealImage {
    private String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();   // expensive — happens immediately, whether or not it's ever displayed
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename + " from disk...");
    }

    void display() {
        System.out.println("Displaying " + filename);
    }
}

// What's wrong here: the moment you create a RealImage, it eagerly loads from disk — even if the user never 
// scrolls down to actually see it. There's also no natural place to add access checks, logging, or caching 
// without cluttering RealImage itself with concerns that aren't really about "being an image."
public class BrokenProxy {
    
}
