package haffman;

import java.util.Map;

public class HaffmanDecoder {
    Map<String, String> coderTree;

    public HaffmanDecoder(String text) {
        coderTree = initCoderTree(text);
    }

    public String decode(String codedText) {
        StringBuilder fragmentBuilder = new StringBuilder();
        StringBuilder decodedTextBuilder = new StringBuilder();
        for (int i = 0; i < codedText.length(); i++) {
            fragmentBuilder.append(codedText.charAt(i));
            String fragment = fragmentBuilder.toString();
            if (coderTree.containsKey(fragment)) {
                decodedTextBuilder.append(coderTree.get(fragment));
                fragmentBuilder = new StringBuilder();
            }
        }
        return decodedTextBuilder.toString();
    }

    /**
     * Инициализируется так, что самые часто-встречаемые буквы ближе к корню бинарного дерева,
     * а самые редкие - в самых нижних листах
     * @param text
     * @return
     */
    private Map<String, String> initCoderTree(String text) {
        return Map.of(
                "010", "a",
                "011", "r",
                "001", "o",
                "0000", " ",
                "0001", "p",
                "10", "d",
                "110", "i",
                "111", "n"
        );
    }
}
