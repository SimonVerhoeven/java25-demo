package dev.simonverhoeven.java25demo.finalized.security;

import javax.crypto.KDF;
import javax.crypto.SecretKey;
import javax.crypto.spec.HKDFParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

///  JEP 510: Key Derivation Function API

public class KeyDerivedFunction {

    public SecretKey generateDerivedKey(SecretKey secretKey, byte[] salt, byte[] information) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KDF hkdf = KDF.getInstance("HKDF-SHA256");

        AlgorithmParameterSpec params =
                HKDFParameterSpec.ofExtract()
                        .addIKM(secretKey)
                        .addSalt(salt).thenExpand(information, 32);

        return hkdf.deriveKey("AES", params);
    }

    public Object generateEntropicData(AlgorithmParameterSpec parameterSpec) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException {
        KDF hkdf = KDF.getInstance("HKDF-SHA256");
        return hkdf.deriveData(parameterSpec);
    }

}
