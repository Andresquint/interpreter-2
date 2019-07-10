package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    private String symbolicAddress;
    private int resolvedAddress;

    public void init(ArrayList<String> args) {
        this.symbolicAddress = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        if(vm.popRunTimeStack() == 0) {
            vm.setPC(resolvedAddress - 1 );
        }
    }

    public String toString() {
        return "FALSEBRANCH " + this.symbolicAddress + " " + this.resolvedAddress;
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
