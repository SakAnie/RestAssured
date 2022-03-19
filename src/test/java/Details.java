// SubJson within the master request JSON  body is defined as a Separate class

public class Details {

	//class variables
	String companyName;
	String emailID;
	
	
	//constructor
	public Details(String companyName, String emailID) {
		this.companyName=companyName;
		this.emailID=emailID;
	}

	
	//Getter Setter methods
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	
}
