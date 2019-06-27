package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String dumpAction;
    public void init(ArrayList<String> args) {
        dumpAction = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        if (dumpAction.equals("ON"))
            vm.dumpOn();
        else
            vm.dumpOff();

    }

    public String toString() {
        return "DUMP " + dumpAction;
    }
}
