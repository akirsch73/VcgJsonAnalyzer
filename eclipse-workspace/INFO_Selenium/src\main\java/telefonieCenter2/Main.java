package telefonieCenter2;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		TestLogin testLogin = new TestLogin();
		testLogin.base();
		testLogin.testLogin();
		testLogin.navigate();
		testLogin.setBlackList();
		testLogin.setWhiteList();
		testLogin.getOverFlow();
		testLogin.exit();
	}

}
