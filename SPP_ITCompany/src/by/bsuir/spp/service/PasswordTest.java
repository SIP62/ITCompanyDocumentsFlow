package by.bsuir.spp.service;

public class PasswordTest {

	public static void main(String[] args) {
		String password = "vasya";
		PassScrambler ps = new PassScrambler();
		PassDecoder pd = new PassDecoder();
		String pass = ps.scramble(password);
		System.out.println("Scrambled password = " + pass);
		pass = pd.decode(pass);
		System.out.println("Decoded password = " + pass);

	}

}
