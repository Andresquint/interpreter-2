package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String returnLabel = "";

    public void init(ArrayList<String> args) {
        if(args.size() == 1)
            this.returnLabel = args.get(0);
    }
    public void execute(VirtualMachine vm) {
        vm.setPC(vm.popRetAddrs());
        vm.popFramePointer();
    }
    public String toString() {
        return "RETURN " + returnLabel;
    }
}
