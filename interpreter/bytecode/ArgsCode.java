package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    int numberOfArgs;

    public void init(ArrayList<String> args) {
        this.numberOfArgs = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm) {

    }

   public String toString() {
        return "ARGS " + numberOfArgs;
    }
}


