package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump() {
        // Loop through framePointer then rts
        // StringJoiner

        for(int value: this.runTimeStack)
            System.out.print(value + " ");
        System.out.println();
        for(int frame: this.framePointer)
            System.out.print(frame + " ");
        System.out.println();


        for (int currentFrame = 0; currentFrame < this.framePointer.size(); currentFrame++) {
            System.out.print(this.framePointer.get(currentFrame) + " ");

        }
        System.out.println();




    }

    // returns the top of the stack without removing the item
    public int peek() {
        if(!runTimeStack.isEmpty())
            return runTimeStack.get(runTimeStack.size() - 1);
        return 0;
    }

    // removes an item from the top of the stack and returns it
    public int pop() {
        if(runTimeStack.isEmpty())
            return 0;

        int topOfRTS = this.peek();
        this.runTimeStack.remove(runTimeStack.size() - 1);
        return topOfRTS;
    }

    // creates a new frame in the runtime stack class. The parameter offset is used
    // to denote how many slots down from the top of runtime stack for starting a new fram.
    public void newFrameAt(int offset) {
        this.framePointer.push(this.runTimeStack.size() - offset);
    }

    // Pop the top frame when we return from a function.
    public void popFrame() {
        int returnValue = this.pop();
        int topStackFrame = this.framePointer.pop();
        while(this.runTimeStack.size() - 1 >= topStackFrame) {
            if(!runTimeStack.isEmpty())
                this.pop();
        }
        this.push(returnValue);
    }

    // Used to store values into variables. Store will pop the top value of the stack and
    // replace the value at the given offset in the current frame. The value stored is returned.
    public int store(int offset) {
        int topValueStack = this.pop();
        this.runTimeStack.set(this.framePointer.peek() + offset, topValueStack);
        return topValueStack;
    }

    // Used to load variables onto the rts from a given offset within the current frame.
    // This means we will go to the offset in the current frame, copy the value and push it to the top of the stack.
    // No values should be removed with load.
    public int load(int offset) {
        int value = this.runTimeStack.get(this.framePointer.peek() + offset);
        this.push(value);
        return value;
    }

    // Used to load literal values onto the rts. For example lit 5 will call push with val
    // being 5
    public Integer push(Integer val) {
        this.runTimeStack.add(val);
        return val;
    }

    public boolean isFrame(int currentPosition) {
        return this.framePointer.contains(currentPosition);
    }
}
