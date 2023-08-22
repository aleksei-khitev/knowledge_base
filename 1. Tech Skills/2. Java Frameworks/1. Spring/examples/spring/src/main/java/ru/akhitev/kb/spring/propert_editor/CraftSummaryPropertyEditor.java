package ru.akhitev.kb.spring.propert_editor;

import java.beans.PropertyEditorSupport;

public class CraftSummaryPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        boolean isGuild = text.length() > 6;
        String name = findByShortCut(text.substring(0, 1)).name;
        int level = Integer.parseInt(text.substring(3, 4));
        int mastery = Integer.parseInt(text.substring(5, 6));
        setValue(new CraftSummary(name, level, mastery, isGuild));
    }


    private CraftName findByShortCut(String shortCut) {
        for (CraftName craftName : CraftName.values()) {
            if (craftName.shortCut.endsWith(shortCut)) {
                return craftName;
            }
        }
        throw new IllegalArgumentException("Ничего по этому сокращению не найдено");
    }

    enum CraftName {
        Prospector("Рудакоп", "р"),
        Metalsmith("Кузнец", "к"),
        Weaponsmith("Оружейник", "о"),
        Jeweller("Ювелир", "ю"),
        Forester("Лесник", "л"),
        Woodworker("Деревообработчик", "д"),
        Tailor("Портной", "пор"),
        Farmer("Фермер", "ф"),
        Cook("Повар", "пов"),
        Historian("Историк", "и");

        private String name;
        private String shortCut;

        CraftName(String name, String shortCut) {
            this.name = name;
            this.shortCut = shortCut;
        }
    }
}
