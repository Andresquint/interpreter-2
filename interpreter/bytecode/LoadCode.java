package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int value;
    private String id = null;
    public void init(ArrayList<String> args) {
        this.value = Integer.parseInt(args.get(0));
        if(args.size() > 1)
            id = args.get(1);

    }
    public void execute(VirtualMachine vm) {
        vm.loadRunTimeStack(value);
    }
    public String toString() {
        return "LOAD " + value + " " + id;
    }
}
