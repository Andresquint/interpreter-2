package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    public void init(ArrayList<String> args) {

    }
    public void execute(VirtualMachine vm) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Please ENTER an integer: ");
            String input = sc.next();
            try {
                int userInput = Integer.parseInt(input);
                vm.pushRunTimeStack(userInput);
                break;
            } catch (NumberFormatException ne) {

            }
        }


    }
    public String toString() {
        return "READ";
    }
}
