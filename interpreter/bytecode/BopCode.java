package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operator;

    public void init(ArrayList<String> args) {
        this.operator = args.get(0);
    }

    public void execute(VirtualMachine vm) {
        int op1 = vm.popRunTimeStack();
        int op2 = vm.popRunTimeStack();

        switch(operator) {
            case  "+"  :
                vm.pushRunTimeStack(op2 + op1); break;
            case  "-"  :
                vm.pushRunTimeStack(op2 - op1); break;
            case  "/"  :
                vm.pushRunTimeStack(op2 / op1); break;
            case  "*"  :
                vm.pushRunTimeStack(op2 * op1); break;
            case  "==" :
                if(op1 == op2) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
            case  "!=" :
                if(op1 != op2) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
            case  "<=" :
                if(op2 <= op1) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
            case  ">"  :
                if(op2 > op1) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
            case  ">=" :
                if(op2 >= op1) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
            case  "<"  :
                if(op2 < op1) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
            case  "|"  :
                if(op1 > 0 || op2 > 0) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
            case  "&"  :
                if(op1 > 0 && op2 > 0) {
                    vm.pushRunTimeStack(1);
                } else {
                    vm.pushRunTimeStack(0);
                } break;
        }

    }

    public String toString() {
        return "BOP " + operator;
    }
}
