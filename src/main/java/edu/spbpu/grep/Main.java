package edu.spbpu.grep;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class Main {
    @Option(name = "-v", usage = "verse")
    private boolean v;

    @Option(name = "-i", usage = "ignoreCase")
    private boolean i;

    @Option(name = "-r", usage = "regex")
    private boolean r;

    @Argument(required = true, usage = "Input file name", index = 1)
    private String inputFile;

    @Argument(required = true, usage = "word")
    private String word;

    public static void main(String[] args) {
        new Main().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar grep.jar [-v] [-i] [-r] word inputName.txt");
            parser.printUsage(System.err);
            return;
        }

        try {
           System.out.println(Grep.lines(r, v, i, word, inputFile));
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}


