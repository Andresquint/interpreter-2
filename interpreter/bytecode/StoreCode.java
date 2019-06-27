package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset;
    private String id = "";

    public void init(ArrayList<String> args) {
        this.offset = Integer.parseInt(args.get(0));
        if(args.size() > 1)
            id = args.get(1);


    }
    public void execute(VirtualMachine vm) {
        vm.store(this.offset);
    }
    public String toString() {
        return "STORE " + offset + " " + id;
    }
}
