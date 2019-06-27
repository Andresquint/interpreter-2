package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int offset;

    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm) {
        vm.addFrame(offset);
    }

   public String toString() {
        return "ARGS " + offset;
    }
}


