package com.sails.interview.builder.tiojava;


import com.sails.interview.builder.tiojava.model.TioRequest;
import com.sails.interview.builder.tiojava.model.TioResult;
import com.sails.interview.builder.tiojava.service.TioService;

public class QuickTest {

    public static void main(String[] args) {
        runJavaProgram();
        runPythonProgram();
    }

    public static void runPythonProgram() {
        String program = "print(\"Hello, World! Python\")";
        runProgram(program, "python3");
    }

    public static void runJavaProgram() {
        String program = "public class Main {\n" +
                "\n" +
                "    public static void main(String[] args) {\n" +
                "        System.out.println(\"Hello world! Java\");\n" +
                "    }\n" +
                "    \n" +
                "}\n";
        runProgram(program, "java-openjdk");
    }

    public static void runProgram(String program, String language) {
        TioResult result = getResult(program, language);

        System.out.println(result.get(TioResult.Field.OUTPUT));
        System.out.println(result.get(TioResult.Field.DEBUG));
    }

    public static TioResult getResult(String program, String language) {
        TioRequest request = TioService.newRequest()
                .setCode(program)
                .setLang(language);

        TioService tio = TioService.MAIN;
        return tio.send(request).get().getResult().get();
    }

}
