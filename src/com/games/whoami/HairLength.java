package com.games.whoami;

public enum HairLength {
    BALD, SHORT, MEDIUM, LONG;

    // built method ordinal Hairlength.BOLD.ordinal() == 0;
    public static HairLength select(int selection) {
        HairLength hairLength = null;
        switch (selection) {
            case 1:
                hairLength = HairLength.SHORT;
                break;
            case 2:
                hairLength = HairLength.MEDIUM;
                break;
            case 3:
                hairLength = HairLength.LONG;
                break;
            case 4:
                hairLength = HairLength.BALD;
                break;
        }
        return hairLength;
    }
}