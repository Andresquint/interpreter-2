package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class CallCode extends ByteCode {
    public String symbolicAddress;
    public int resolvedAddress;
    public void init(ArrayList<String> args) {
        symbolicAddress = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        vm.pushRetAddrs(vm.getPC());
        vm.setPC(resolvedAddress );

    }

    public String toString() {
        return "CALL " + this.resolvedAddress;
    }
}
