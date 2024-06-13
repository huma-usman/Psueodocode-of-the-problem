// Define constants
CONST MAX_CANDIDATES = 5          // Maximum number of candidates
CONST THRESHOLD_PERCENTAGE = 50   // Threshold percentage for majority

// Define lists and variables
LIST NAMES   // List to store candidate names
LIST VOTES   // List to store number of votes for each candidate

int TOTAL_VOTES     // Total number of votes cast
int MAX_VOTES1, MAX_VOTES2   // Variables to store highest and second highest votes
int INDEX1, INDEX2   // Index variables for candidates with MAX_VOTES1 and MAX_VOTES2

// Function to read input votes for each candidate
FUNCTION read_votes():
    TOTAL_VOTES = 0
    FOR i = 1 to MAX_CANDIDATES DO
        VOTES[i] = read_input()    // Read input votes for each candidate
        TOTAL_VOTES = TOTAL_VOTES + VOTES[i]   // Calculate total votes
    END FOR

// Function to determine winners
FUNCTION determine_winners():
    MAX_VOTES1 = -1
    MAX_VOTES2 = -1

    FOR i = 1 to MAX_CANDIDATES DO
        IF VOTES[i] > MAX_VOTES1 THEN
            MAX_VOTES2 = MAX_VOTES1   // Update second highest votes
            INDEX2 = INDEX1           // Update index of second highest
            MAX_VOTES1 = VOTES[i]     // Update highest votes
            INDEX1 = i               // Update index of highest
        ELSE IF VOTES[i] > MAX_VOTES2 THEN
            MAX_VOTES2 = VOTES[i]     // Update second highest votes
            INDEX2 = i               // Update index of second highest
        END IF
    END FOR

// Function to output the result
FUNCTION output_result():
    IF MAX_VOTES1 > TOTAL_VOTES / 2 THEN
        OUTPUT "Candidate ", NAMES[INDEX1], " is elected as president."
    ELSE
        OUTPUT "There will be a second round between candidates ", NAMES[INDEX1], " and ", NAMES[INDEX2], "."
    END IF

// Main program
FUNCTION main():
    // Step 1: Read votes
    read_votes()

    // Step 2: Determine winners
    determine_winners()

    // Step 3: Output result
    output_result()

END FUNCTION
