package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String symbolicAddress;

    public void init(ArrayList<String> args) {
        this.symbolicAddress = args.get(0);
    }

    public void execute(VirtualMachine vm) {

    }
    public String toString() {
        return "LABEL " + this.symbolicAddress;
    }
    public String getSymbolicAddress() {
        return this.symbolicAddress;
    }
}
