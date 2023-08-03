package dev.shvetsova.tools;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HelpReader {

    private static final BufferedReader reader;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String readLine() throws IOException {
        return reader.readLine();
    }
}
