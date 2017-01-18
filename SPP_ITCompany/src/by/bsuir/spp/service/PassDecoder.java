package by.bsuir.spp.service;

public class PassDecoder {
	
	private int charshift = 3;
	private String decodedPass = new String("");

	public String decode(String password) {
		char[] chArray = new char[password.length()];
		chArray = password.toCharArray();
		for (int i = 0; i < password.length(); i++){
			if (chArray[i] >= 48 && chArray[i] <= 57) {
				if(chArray[i] >= 48 + charshift)chArray[i] = (char) (chArray[i] - charshift);
				else chArray[i] = (char) (chArray[i] - charshift + 10);
			}
			if (chArray[i] >= 65 && chArray[i] <= 90) {
				if(chArray[i] >= 65 + charshift)chArray[i] = (char) (chArray[i] - charshift);
				else chArray[i] = (char) (chArray[i] - charshift + 26);
			}
			if (chArray[i] >= 97 && chArray[i] <= 122) {
				if(chArray[i] >= 97 + charshift)chArray[i] = (char) (chArray[i] - charshift);
				else chArray[i] = (char) (chArray[i] - charshift + 26);
			}
			if (chArray[i] >= 1040 && chArray[i] <= 1071) {
				if(chArray[i] >= 1040 + charshift)chArray[i] = (char) (chArray[i] - charshift);
				else chArray[i] = (char) (chArray[i] - charshift + 32);
			}
			if (chArray[i] >= 1072 && chArray[i] <= 1103) {
				if(chArray[i] >= 1072 + charshift)chArray[i] = (char) (chArray[i] - charshift);
				else chArray[i] = (char) (chArray[i] - charshift + 32);
			}
			decodedPass = decodedPass + chArray[i];
			
		}
		return decodedPass;
	}

}
