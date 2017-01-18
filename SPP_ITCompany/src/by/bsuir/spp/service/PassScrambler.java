package by.bsuir.spp.service;

public class PassScrambler {
	
	private int charshift = 3;
	private String scrambledPass = new String("");
	
	public String scramble(String password) {
		char[] chArray = new char[password.length()];
		chArray = password.toCharArray();
		for (int i = 0; i < password.length(); i++){
			if (chArray[i] >= 48 && chArray[i] <= 57) {
				if(chArray[i] <= 57 - charshift)chArray[i] = (char) (chArray[i] + charshift);
				else chArray[i] = (char) (chArray[i] + charshift - 10);
			}
			if (chArray[i] >= 65 && chArray[i] <= 90) {
				if(chArray[i] <= 90 - charshift)chArray[i] = (char) (chArray[i] + charshift);
				else chArray[i] = (char) (chArray[i] + charshift - 26);
			}
			if (chArray[i] >= 97 && chArray[i] <= 122) {
				if(chArray[i] <= 122 - charshift)chArray[i] = (char) (chArray[i] + charshift);
				else chArray[i] = (char) (chArray[i] + charshift - 26);
			}
			if (chArray[i] >= 1040 && chArray[i] <= 1071) {
				if(chArray[i] <= 1071 - charshift)chArray[i] = (char) (chArray[i] + charshift);
				else chArray[i] = (char) (chArray[i] + charshift - 32);
			}
			if (chArray[i] >= 1072 && chArray[i] <= 1103) {
				if(chArray[i] <= 1103 - charshift)chArray[i] = (char) (chArray[i] + charshift);
				else chArray[i] = (char) (chArray[i] + charshift - 32);
			}
			scrambledPass = scrambledPass + chArray[i];
			
		}
		return scrambledPass;
	}
	
	
	

}
