class Language {
    String name;
    int numSpeakers;
    String languageFamily;

    public void getInfo() {
        System.out.print("\nName: " + name);
        System.out.print("\nNumber Of Speakers: " + numSpeakers);
        System.out.print("\nLanguage Family: " + languageFamily);
        System.out.print("\n");
    }
}

class Mayan extends Language {

    Mayan() {
        super();
        name = "Mayan";
        numSpeakers = 6000000; // Note: Speaker data is AI-estimated as of 2026
        languageFamily = "Mayan";
    }
}

class Mandarin extends Language {

    Mandarin() {
        super();
        name = "Mandarin";
        numSpeakers = 920000000; // Note: Speaker data is AI-estimated as of 2026
        languageFamily = "Sino-Tibetan";
    }
}

class SinoTibetan extends Language {

    SinoTibetan() {
        super();
        name = "Sino-Tibetan";
        numSpeakers = 1200000000; // Note: Speaker data is AI-estimated as of 2026
        languageFamily = "Sino-Tibetan";
    }
}

public class LanguageFamilies {
    public static void main(String[] args) {

        Mayan mayan = new Mayan();
        mayan.getInfo();

        Mandarin mandarin = new Mandarin();
        mandarin.getInfo();

        SinoTibetan sinotibetan = new SinoTibetan();
        sinotibetan.getInfo();
    }
}