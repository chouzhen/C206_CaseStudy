import java.util.ArrayList;

public class C206_CaseStudy {
	private static final int OPTION_QUIT = 3;

	public static void main(String[] args) {
		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(new Account("admin", "admin", "admin"));

		int option = 0;
		C206_CaseStudy.menu();
		while (option != OPTION_QUIT) { // this is similar to saying (option != 3)

			option = Helper.readInt("Enter an option > "); // prompt user to input an option

			if (option == 1) { // create an account
				C206_CaseStudy.createAccount(accountList);

			} else if (option == 2) { // create login
				C206_CaseStudy.login(accountList);
			} else { // to quit the program
				System.out.println("Bye!");
			}

		}
	}

	public static void menu() {
		C206_CaseStudy.setHeader("WELCOME TO SCHOOL LUNCH BOX MENU ORDERING APP");
		System.out.println("1. Create new account");
		System.out.println("2. Login");
		System.out.println("3. Quit");

	}

	public static void parentMenu() {
		C206_CaseStudy.setHeader("WELCOME TO SCHOOL LUNCH BOX MENU ORDERING APP");
		System.out.println("1. View monthly menu");
		System.out.println("2. Place lunchbox order");
		System.out.println("3. View lunchbox order");
		System.out.println("4. View order bill");
		System.out.println("5. Make payment");
	}

	public static void adminMenu() {
		C206_CaseStudy.setHeader("WELCOME TO SCHOOL LUNCH BOX MENU ORDERING APP");
		System.out.println("1. Add user account");
		System.out.println("2. View user account");
		System.out.println("3. Delete user account");
		System.out.println("4. Add menu items");
		System.out.println("5. View menu items");
		System.out.println("6. Delete menu items");
		System.out.println("7. Create monthly menu");
		System.out.println("8. View monthly menu");
		System.out.println("9. Delete monthly menu");
		System.out.println("10. Delete/cancel lunch box order");
		System.out.println("11. Create order bill");
		System.out.println("12. View order bill");
	}

	public static void studentMenu() {
		C206_CaseStudy.setHeader("WELCOME TO SCHOOL LUNCH BOX MENU ORDERING APP");
		System.out.println("1. View monthly menu");
		System.out.println("2. Place lunchbox order");
		System.out.println("3. View lunchbox order");
		System.out.println("4. View order bill");
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


	public static void viewAllAccount(ArrayList<Account> accountList) {
		C206_CaseStudy.setHeader("VIEW USER ACCOUNT");
		String output = String.format("%-25s %-10s %-10s\n", "USERNAME", "PASSWORD", "ROLE");
		output += retrieveAllUserAccount(accountList);
		System.out.println(output);
	}

	public static void deleteAccount(ArrayList<Account> accountList) {

		String username = Helper.readString("Enter username to delete > ");
		String password = Helper.readString("Enter password to delete > ");

		for (int i = 0; i < accountList.size(); i++) {
			if (username.equals(accountList.get(i).getUsername())) {
				if (password.equals(accountList.get(i).getPassword()))

					accountList.remove(i);
			}
		}

	}

	// test cases
	
	public static String retrieveAllUserAccount(ArrayList<Account> accountList) {
		String output="";
        for (int i= 0; i < accountList.size();i++) {
          output += String.format("%-25s %-10s %-10s\n", accountList.get(i).getUsername(), accountList.get(i).getPassword(),accountList.get(i).getRole());
        }
        
        return output;
	}
	
	public static Account inputAccount() {
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		String role = Helper.readString("Enter role > ");

		Account acc = new Account(username, password, role);
		return acc;
		
	}	
	public static void addAccount(ArrayList<Account> accountList, Account acc) {

		accountList.add(acc);
		
	}

	public static boolean doDeleteAccount(ArrayList<Account> accountList, String username, String password) {

		boolean isDeleted = false;

		for (int i = 0; i < accountList.size(); i++) {

			String Username = accountList.get(i).getUsername();
			String Password = accountList.get(i).getPassword();

			if (username.equals(Username) && accountList.get(i).getIsAvailable() == true) {
				if (password.equals(Password) && accountList.get(i).getIsAvailable() == true) {

					accountList.get(i).setIsAvailable(false);
					isDeleted = true;

				}
			
			}

		}
		
		return isDeleted;
	}

	public static void createAccount(ArrayList<Account> accountList) {
		// prompt user to enter username/password/role
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");
		String role = Helper.readString("Enter role (Admin/Parent/Student) > ");

		accountList.add(new Account(username, password, role)); // add into the arrayList

		if (accountList.isEmpty() != true) { // if accountList is empty, it will print "successful"
			System.out.println("successful");
		} else { // if accountList is not empty, it will print "failed"
			System.out.println("failed");
		}
	}

	public static void login(ArrayList<Account> accountList) {
		// prompt user to enter username/password
		String username = Helper.readString("Enter username > ");
		String password = Helper.readString("Enter password > ");

		// enhanced for loop
		for (Account i : accountList) {
			if (username.equals(i.getUsername()) && password.equals(i.getPassword())
					&& i.getRole().equalsIgnoreCase("Admin")) {
				adminMenu();

			} else if (username.equals(i.getUsername()) && password.equals(i.getPassword())
					&& i.getRole().equalsIgnoreCase("Parent")) {
				parentMenu();

			} else if (username.equals(i.getUsername()) && password.equals(i.getPassword())
					&& i.getRole().equalsIgnoreCase("Student")) {
				studentMenu();

			}

		}

	}

}
