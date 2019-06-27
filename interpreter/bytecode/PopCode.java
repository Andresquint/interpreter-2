package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode {
    int numberOfPops;
    public void init(ArrayList<String> args) {
        this.numberOfPops = Integer.parseInt(args.get(0));
    }
    public void execute(VirtualMachine vm) {
        for(int i = 0; i < numberOfPops; i++)
            vm.popRunTimeStack();
    }
    public String toString() {
        return "POP " + this.numberOfPops;
    }
}
