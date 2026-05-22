public class DNASequencing {
    public static void main(String[] args) {

        String DNA = "ATGCGATACGCTTGA";

        int start = DNA.indexOf("ATG");
        int end = DNA.indexOf("TGA");

        // --- DNA START & END POSITIONS ---
        System.out.println(start);
        System.out.println(end);

        // --- EXTRACTED DNA SEQUENCE ---
        System.out.println(DNA.substring(start, end));

        // --- EXTRACTED SEQUENCE LENGTH ---
        String extractedSequence = DNA.substring(start, end);
        System.out.println(extractedSequence.length());
    }
}