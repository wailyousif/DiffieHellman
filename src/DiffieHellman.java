import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by wailm.yousif on 2/17/18.
 */
public class DiffieHellman
{
    private final static int PRIME_BIT_LENGTH = 512;
    private final static int EXPONENT_BIT_LENGTH = 512;

    public static void main(String[] args)
    {
        SecureRandom secureRandom = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(PRIME_BIT_LENGTH, secureRandom);
        BigInteger g = BigInteger.probablePrime(PRIME_BIT_LENGTH, secureRandom);

        System.out.println("p=" + p);
        System.out.println("g=" + g);

        Random random = new Random();
        BigInteger a = new BigInteger(EXPONENT_BIT_LENGTH, random);
        BigInteger b = new BigInteger(EXPONENT_BIT_LENGTH, random);

        System.out.println("a=" + a);
        System.out.println("b=" + b);

        //A sequence
        BigInteger A = g.modPow(a, p);

        //B sequence
        BigInteger B = g.modPow(b, p);
        BigInteger RB = A.modPow(b, p);

        //A sequence
        BigInteger RA = B.modPow(a, p);

        System.out.println("RA=" + RA);
        System.out.println("RB=" + RB);

        if (RA.compareTo(RB) == 0)
        {
            System.out.println("DH worked successfully. Key length = " + RA.bitLength());
        }
        else
            System.out.println("DH Failed");
    }
}
