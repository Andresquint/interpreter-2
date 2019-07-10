package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class CallCode extends ByteCode {
    private String symbolicAddress;
    private int resolvedAddress;
    public void init(ArrayList<String> args) {
        symbolicAddress = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        vm.pushRetAddrs(vm.getPC());
        vm.setPC(resolvedAddress - 1);

    }

    public String toString() {
        return "CALL " + this.symbolicAddress + " " + this.resolvedAddress;
    }

    public String getSymbolicAddress() {
        return symbolicAddress;
    }
    public void setSymbolicAddress (String symbolicAddress) {
        this.symbolicAddress = symbolicAddress;
    }
    public int getResolvedAddresss() {
        return this.resolvedAddress;
    }
    public void setResolvedAddress(int resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }
}
