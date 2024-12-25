import java.util.*;

public class Blockchain {
    private List<Block> chain;

    public Blockchain() {
        chain = new ArrayList<>();
        // Adding the genesis block (first block in the blockchain)
        addBlock("Genesis Block");
    }

    // Add a new block to the blockchain
    public void addBlock(String data) {
        Block previousBlock = chain.isEmpty() ? null : chain.get(chain.size() - 1);
        String previousHash = previousBlock != null ? previousBlock.getHash() : "0";
        Block newBlock = new Block(data, previousHash, System.currentTimeMillis());
        chain.add(newBlock);
    }

    // Display the blockchain
    public void displayChain() {
        for (int i = 0; i < chain.size(); i++) {
            Block block = chain.get(i);
            System.out.println("Block " + (i + 1) + ":");
            System.out.println("Data: " + block.getData());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Hash: " + block.getHash());
            System.out.println();
        }
    }
}
