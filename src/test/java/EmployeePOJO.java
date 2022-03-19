
public class EmployeePOJO {
	/* what is a POJO? Rule?
	 * Plain Old Java Object
	 * Rules:
	 * Class variables/properties MUST be private
	 * Class must be public
	 * Must have public default contructor
	 * can have optional argyment contructor
	 * must have public getters and setters for all the properties
	 */
	/*
	 * { “name”:”sakshi”, 
	 * “JobRole”:”SDET” ,
	 * “skills”:[“Java”,”Python”],
	 *  “details”:{
	 * “companyName”:”XYZ”, “EmailID”:”Ssakshi@XYZ.com” } 
	 * }
	 */
	
	//class variables

	private String name;
	private String JobRole;
	private String[] skills;
	private Details details;
	
	//constructor
	public EmployeePOJO(String name,String JobRole, String[] skills,String companyName,String emailID) {
		this.name=name;
		this.JobRole=JobRole;
		this.skills=skills;
		this.details=new Details(companyName,emailID);
	}

	//Getters & Setters Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobRole() {
		return JobRole;
	}

	public void setJobRole(String jobRole) {
		JobRole = jobRole;
	}

	public String[] getSkills() {
		return skills;
	}

	public void setSkills(String[] skills) {
		this.skills = skills;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}
	

	
}
