package defaultPackage;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;



//we use recursion to navigate, this is just a simple tree
public class Eval {
    public static class Node {
    	 ScriptEngineManager manager = new ScriptEngineManager();
    	 ScriptEngine engine = manager.getEngineByName("JavaScript");
    	 
    	 String data;
    	 Node left, right;
    	 Node(String data) {
    		 this.data = data;
    		 left = null;
    		 right = null;
        }
    }

}
