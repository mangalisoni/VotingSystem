import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

public class Block {
    private String data;
    private String previousHash;
    private long timestamp;
    private String hash;

    public Block(String data, String previousHash, long timestamp) {
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.hash = calculateHash();
    }

    // Calculate the hash of the block
    private String calculateHash() {
        String input = data + previousHash + Long.toString(timestamp);
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            BigInteger bigInt = new BigInteger(1, hashBytes);
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }
}
