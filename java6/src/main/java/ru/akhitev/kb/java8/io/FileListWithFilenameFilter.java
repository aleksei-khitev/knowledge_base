package ru.akhitev.kb.java8.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileListWithFilenameFilter {
    public static void main(String[] args) {
        File homeDir = new File("/home/aleksei_khitev");
        String[] filteredNames = homeDir.list(new OnlyLogsFilenameFilter());
        System.out.println(Arrays.toString(filteredNames));
    }

    private static class OnlyLogsFilenameFilter implements FilenameFilter {

        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".log");
        }
    }
}
