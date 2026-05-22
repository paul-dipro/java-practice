public class DNASequencing {
    public static void main(String[] args) {

        String DNA = "ATGCGATACGCTTGA";

        int start = DNA.indexOf("ATG");
        int end = DNA.indexOf("TGA");

        // --- DNA START & END POSITIONS ---
        System.out.println("DNA Start Position: " + start);
        System.out.println("DNA End Position: " + end);

        // --- EXTRACTED DNA SEQUENCE ---
        System.out.println("Extracted Sequence: " + DNA.substring(start, end));

        // --- EXTRACTED SEQUENCE LENGTH ---
        String extractedSequence = DNA.substring(start, end);
        System.out.println("Sequence Length: " + extractedSequence.length());
    }
}