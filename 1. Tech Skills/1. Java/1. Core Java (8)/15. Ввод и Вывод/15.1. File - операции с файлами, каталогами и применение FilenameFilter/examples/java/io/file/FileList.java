package io.file;

import java.io.File;
import java.util.Arrays;

public class FileList {
    public static void main(String[] args) {
        File root = new File("/");
        if (root.exists() && root.isDirectory()) {
            System.out.println(Arrays.toString(root.list()));
        }
    }
}
