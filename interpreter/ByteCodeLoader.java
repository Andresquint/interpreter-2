
package interpreter;

import interpreter.bytecode.ByteCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program loadedProgram = new Program();
        try {
            String currentLine;
            while ((currentLine = this.byteSource.readLine()) != null) {
                String currentByteCode;
                ArrayList<String> args = new ArrayList<>();
                StringTokenizer token;
                // I used this from project 1
                token = new StringTokenizer(currentLine);
                // The first token of each line is always the current ByteCode
                currentByteCode = token.nextToken();
                Class c = Class.forName("interpreter.bytecode." + CodeTable.getClassName(currentByteCode));
                ByteCode bc = (ByteCode) c.getDeclaredConstructor().newInstance(); // how
                while(token.hasMoreTokens()){
                    args.add(token.nextToken());
                }
                bc.init(args);
                loadedProgram.addByteCode(bc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }



        loadedProgram.resolveAddrs();
        return loadedProgram;
    }
}
