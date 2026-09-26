package DesignPatterns.Structural.Proxy_DP;


interface Document{
    void view();
    void edit(String newContent);
}

class RealDocument implements Document{
    private String content = "Original Content";

    public void view(){
        System.out.println("Viewing: " + content);
    }

    public void edit(String newContent){
        content = newContent;
        System.out.println("Document updated");
    }
}

class ProtectedDocumentProxy implements Document{
    private RealDocument document = new RealDocument();
    private String userRole;

    ProtectedDocumentProxy(String userRole){
        this.userRole = userRole;
    }

    public void view(){
        document.view();   // viewing is always allowed
    }

    public void edit(String newContent){
        if(userRole.equals("ADMIN")){
            document.edit(newContent);
        }
        else{
            System.out.println("Access denied: only ADMIN can edit");
        }
    }
}
public class ProtectionProxy {
    public static void main(String[] args) {
        Document doc = new ProtectedDocumentProxy("VIEWER");

        doc.view();
        doc.edit("Adding corrupted data because user is a bad boii. ");   // Access denied: only ADMIN can edit

        Document adminDoc = new ProtectedDocumentProxy("ADMIN");

        adminDoc.view();
        adminDoc.edit("Content is changed by Admin");


    }
}
