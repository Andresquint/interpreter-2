package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class FalseBranchCode extends ByteCode {
    public String symbolicAddress;
    public int resolvedAddress;

    public void init(ArrayList<String> args) {
        this.symbolicAddress = args.get(0);
    }

    public void execute(VirtualMachine vm) {

    }

    public String toString() {
        return "FALSEBRANCH " + this.resolvedAddress;
    }
}
