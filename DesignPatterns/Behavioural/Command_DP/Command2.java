package DesignPatterns.Behavioural.Command_DP;

import java.util.ArrayDeque;
import java.util.Deque;

interface TextCommand{
    void execute();
    void undo();
}

class TextDocument{
    private final StringBuilder content = new StringBuilder();

    void insert(int position, String text){
        content.insert(position, text);
    }

    void delete(int position, int length){
        content.delete(position, position + length);
    }

    public String toString(){ return content.toString();}
}

// ONE command class handles BOTH insert and delete via parameterization
class TextEditCommand implements TextCommand{
    private final TextDocument document;
    private final int position;
    private final String text;
    private final boolean isInsert;

      // Factory methods make call sites read clearly, without two separate classes
      static TextEditCommand insert(TextDocument doc, int position, String text){
            return new TextEditCommand(doc, position, text, true);
      }

      static TextEditCommand delete(TextDocument doc, int position, String text){
            return new TextEditCommand(doc, position, text, false);
      }

      private TextEditCommand(TextDocument doc, int position, String text, boolean isInsert){
        this.document = doc;
        this.position = position;
        this.text = text;
        this.isInsert = isInsert;
      }

      public void execute(){
        if(isInsert) document.insert(position, text);
        else document.delete(position, text.length());
      }

      public void undo(){
        if(isInsert) document.delete(position, text.length());
        else document.insert(position, text);
      }
}

class EditorHistory {
    private final Deque<TextCommand> undoStack = new ArrayDeque<>();
    private final Deque<TextCommand> redoStack = new ArrayDeque<>();

    void executeCommand(TextCommand command){
        command.execute();
        undoStack.push(command);
        redoStack.clear();  // new action invalidates redo history
    }

    void undo(){
        if(!undoStack.isEmpty()){
            TextCommand command = undoStack.pop();
            command.undo();
            redoStack.push(command);
        }    
    }
    void redo(){
        if(!redoStack.isEmpty()){
            TextCommand command = redoStack.pop();
            command.execute();
            undoStack.push(command);
        }    
    }
}

//usage 
public class Command2 {
    public static void main(String[] args) {
        TextDocument doc = new TextDocument();
        EditorHistory editor = new EditorHistory();

        editor.executeCommand(TextEditCommand.insert(doc,0, "Hello World! "));

        editor.executeCommand(TextEditCommand.insert(doc,13, "Life is awesome "));
        System.out.println(doc);

        editor.undo();
        System.out.println(doc);

        editor.redo();
        System.out.println(doc);

    }
}
