package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dumpState = true;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while(isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(dumpState) {
                System.out.println(code);
                runStack.dump();


            }
            pc++;
        }

    }

    public void stopProgram() {
        this.isRunning = false;
    }

    public void addFrame(int offset) {
        this.runStack.newFrameAt(offset);
    }

    public void pushRunTimeStack(int value) {
        this.runStack.push(value);
    }

    public int popRetAddrs() {
        if(!this.returnAddrs.isEmpty())
            return this.returnAddrs.pop();
        return 0;
    }

    public int popRunTimeStack() {
        return this.runStack.pop();
    }

    public int getPC() {
        return this.pc;
    }

    public void setPC(int setPC) {
        this.pc = setPC;
    }

    public void pushRetAddrs(int pc) {
        this.returnAddrs.push(pc);
    }

    public void dumpOn() {
        this.dumpState = true;
    }

    public void dumpOff() {
        this.dumpState = false;
    }

    public void loadRunTimeStack (int offset) {
        this.runStack.load(offset);
    }

    public void popFramePointer() {
        this.runStack.popFrame();
    }

    public void store(int offset) {
        this.runStack.store(offset);
    }

    public void writeToScreen() {
        System.out.println(this.runStack.peek());
    }


}
