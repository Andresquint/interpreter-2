package interpreter;

import java.util.ArrayList;
import java.util.HashMap;

import interpreter.bytecode.*;

public class Program {

    private ArrayList<ByteCode> program;

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }

    public void addByteCode(ByteCode bc) {
        this.program.add(bc);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void resolveAddrs() {
        HashMap<String, Integer> labelAddresses = new HashMap();

        // Loop through finding all instances Label storing symbolicAddress as key and literalAddress as value
        for(ByteCode it: program) {
            if (it instanceof LabelCode) {
                labelAddresses.put(((LabelCode) it).getSymbolicAddress(), program.indexOf(it));
            }
        }

        // Abstraction for jump code

        // Loop through finding GOTO, FALSEBRANCH, CALL replacing symbolicAddress
        for (ByteCode it: program) {
            if (it instanceof GotoCode) {
                ((GotoCode) it).setResolvedAddress(labelAddresses.get(((GotoCode) it).getSymbolicAddress()));
            } else if (it instanceof FalseBranchCode) {
                ((FalseBranchCode)it).setResolvedAddress(labelAddresses.get(((FalseBranchCode) it).getSymbolicAddress()));
            } else if (it instanceof CallCode) {
                ((CallCode)it).setResolvedAddress(labelAddresses.get(((CallCode) it).getSymbolicAddress()));
            }
        }
    }
}
