import java.util.*;

public class VotingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Blockchain blockchain = new Blockchain();

        // Taking candidate list input from the user
        System.out.println("Enter the number of candidates:");
        int numCandidates = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        String[] candidates = new String[numCandidates];
        System.out.println("Enter the names of the candidates:");
        for (int i = 0; i < numCandidates; i++) {
            candidates[i] = scanner.nextLine();
        }

        // Taking votes from the user
        boolean votingOpen = true;
        while (votingOpen) {
            System.out.println("Enter your vote by typing the candidate's name:");
            for (int i = 0; i < candidates.length; i++) {
                System.out.println((i + 1) + ". " + candidates[i]);
            }

            String vote = scanner.nextLine();

            // Validate the vote
            boolean validVote = false;
            for (String candidate : candidates) {
                if (vote.equalsIgnoreCase(candidate)) {
                    validVote = true;
                    break;
                }
            }

            if (validVote) {
                blockchain.addBlock(vote + " voted for " + vote);
                System.out.println("Vote for " + vote + " added successfully.");
            } else {
                System.out.println("Invalid vote. Please select a valid candidate.");
            }

            // Ask if the user wants to continue voting
            System.out.println("Do you want to vote again? (yes/no)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                votingOpen = false;
            }
        }

        // Display the blockchain after voting ends
        System.out.println("\nVoting has ended. Blockchain state:");
        blockchain.displayChain();

        scanner.close();
    }
}
