package org.example.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpReader {
    private HelpReader(){}
    private static BufferedReader reader;
    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String readLine() throws IOException {
        return reader.readLine();
    }

}
