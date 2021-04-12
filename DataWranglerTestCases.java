// --== CS400 File Header Information ==--
// Name: Brendan Boyle
// Email: bwboyle@wisc.edu
// Team: DD
// Role: Data Wrangler
// TA: Dan
// Lecturer: Gary
// Notes to Grader: N/A

public class DataWranglerTestCases {
    
    public static void main(String[] args) {
        Airport a1 = new Airport("ANC", "Anchorage", 61.17432028, -149.9961856);
        Airport a2 = new Airport("ATL", "Atlanta", 33.64044444, -84.42694444);

        System.out.println(a1.findDistance(a2));
    }
}
