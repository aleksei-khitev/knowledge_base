package ru.akhitev.kb.java6.io;

import java.io.File;
import java.io.IOException;
import static java.lang.System.out;

public class MethodsOfFile {
    public static void main(String[] args) throws IOException {
        printFileInfo();
        creatDeleteRenameOperations();
        createDeleteDir();
    }

    private static void printFileInfo() {
        File testFile = new File("/home/aleksei_khitev/test.txt");
        out.println(testFile.canRead());
        out.println(testFile.canWrite());
        out.println(testFile.getName());
        out.println(testFile.getParent());
        out.println(testFile.getPath());
        out.println(testFile.getAbsolutePath());
        out.println(testFile.length());
        out.println(testFile.isFile());
        out.println(testFile.isDirectory());
    }

    private static void creatDeleteRenameOperations() throws IOException {
        String testFile_1 = "/home/aleksei_khitev/test_1.txt";
        String testFile_2 = "/home/aleksei_khitev/test_2.txt";
        File testFile = new File(testFile_1);
        out.println("testFile.exists before creation: " + testFile.exists());
        out.println("testFile.createNewFile: " + testFile.createNewFile());
        out.println("testFile.exists after creation: " + testFile.exists());
        out.println("testFile.renameTo: " + testFile.renameTo(new File(testFile_2)));
        out.println("testFile.getName after renaming: " + testFile.getName()); // Внимание, смотри что дальше
        out.println("is exists test_1.txt: " + new File(testFile_1).exists());
        out.println("is exists test_2.txt: " + new File(testFile_2).exists());
        out.println("testFile.delete: " + testFile.delete());
        out.println("is exists test_1.txt: " + new File(testFile_1).exists());
        out.println("is exists test_2.txt: " + new File(testFile_2).exists());
        out.println("testFile.delete: " + new File(testFile_2).delete());
        out.println("is exists test_1.txt: " + new File(testFile_1).exists());
        out.println("is exists test_2.txt: " + new File(testFile_2).exists());
    }

    private static void createDeleteDir() {
        File testDir = new File("/home/aleksei_khitev/test_dir");
        out.println("testFile.exists before creation: " + testDir.exists());
        out.println("testFile.mkdir: " + testDir.mkdir());
        out.println("testFile.exists after creation: " + testDir.exists());
        out.println("testDir.isDirectory: " + testDir.isDirectory());
        out.println(testDir.delete());
        out.println("testFile.exists after remove: " + testDir.exists());
        File testSubDir = new File("/home/aleksei_khitev/test_dir/sub_dir");
        out.println("testSubDir.exists before creation: " + testSubDir.exists());
        out.println("testSubDir.mkDirS: " + testSubDir.mkdirs()); // Внимание, смотри что дальше
        out.println("testSubDir.exists before creation: " + testSubDir.exists());
        out.println("testSubDir.getAbsolutePath: " + testSubDir.getAbsolutePath());
        out.println("testFile.exists after mkdirs and before deletion: " + testDir.exists());
        out.println("testDir.delete with subdir inside: " + testDir.delete()); // Внимание, смотри что дальше
        out.println("testFile.exists after deletion: " + testDir.exists());
        out.println("testSubDir.exists after parent deletion: " + testSubDir.exists());
        out.println("testSubDir.delete: " + testSubDir.delete());
        out.println("testDir.delete without anything inside: " + testDir.delete());
        out.println("testFile.exists after deletion: " + testDir.exists());
        out.println("testSubDir.exists after parent deletion: " + testSubDir.exists());
    }
}
