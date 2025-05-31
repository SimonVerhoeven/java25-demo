package dev.simonverhoeven.java25demo.preview;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.PEMEncoder;
import java.security.PEMDecoder;

/// JEP 470: PEM Encodings of Cryptographic Objects (Preview)

public class PEMEncoding {
    public static void main() throws NoSuchAlgorithmException {
        // Enable preview features: --enable-preview --release 25

        // 1. Generate an EC key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 2. Encode public key to PEM
        String publicKeyPEM = PEMEncoder.of()
                .encodeToString(keyPair.getPublic());
        System.out.println("Public Key PEM:\n" + publicKeyPEM);

        // 3. Encode a private key to encrypted PEM
        char[] password = "secret".toCharArray();
        String privateKeyPEM = PEMEncoder.of()
                .withEncryption(password)
                .encodeToString(keyPair.getPrivate());
        System.out.println("Encrypted Private Key PEM:\n" + privateKeyPEM);

        // 4. Decode a public key
        PublicKey decodedPubKey = PEMDecoder.of()
                .decode(publicKeyPEM, PublicKey.class);
        System.out.println("Decoded Public Key Algo: " + decodedPubKey.getAlgorithm());

        // 5. Decode encrypted private key
        PrivateKey decodedPrivateKey = PEMDecoder.of()
                .withDecryption(password)
                .decode(privateKeyPEM, PrivateKey.class);
        System.out.println("Decoded Private Key Algo: " + decodedPrivateKey.getAlgorithm());
    }
}
