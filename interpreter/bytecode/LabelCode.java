package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends ByteCode {
    public String symbolicAddress;

    public void init(ArrayList<String> args) {
        this.symbolicAddress = args.get(0);
    }

    public void execute(VirtualMachine vm) {

    }

    public String toString() {
        return "LABEL " + this.symbolicAddress;
    }
}
