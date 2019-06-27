package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int value;
    private String variableName = "";

    public void init(ArrayList<String> args) {
        if (args.size() == 1)
            value = Integer.parseInt(args.get(0));
        else {
            value = Integer.parseInt(args.get(0));
            variableName = args.get(1);
        }
    }
    public void execute(VirtualMachine vm) {
        if(variableName == null)
            vm.pushRunTimeStack(0);
        else
            vm.pushRunTimeStack(value);
    }

    public String toString() {
        return "LIT " + value + " " + variableName;
    }

    public int getValue() {
        return this.value;
    }

    public String getVariableName() {
        return variableName;
    }
}
