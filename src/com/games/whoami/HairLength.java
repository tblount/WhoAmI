package com.games.whoami;

public enum HairLength {
    BALD, SHORT, MEDIUM, LONG;

    public static HairLength select(int selection){
        HairLength hairLength = null;
        switch (selection){
            case 1: hairLength = HairLength.SHORT;
                break;
            case 2: hairLength = HairLength.MEDIUM;
                break;
            case 3: hairLength = HairLength.LONG;
                break;
            case 4: hairLength = HairLength.BALD;
                break;
        }
        return hairLength;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 1a8f9c3cac1a31590deeb3257675f547cbddd814
