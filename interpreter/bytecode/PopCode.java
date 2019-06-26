package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode {
    int numberOfPops;
    public void init(ArrayList<String> args) {
        numberOfPops = Integer.parseInt(args.get(0));
    }
    public void execute(VirtualMachine vm) {

    }
    public String toString() {
        return "POP";
    }
}
