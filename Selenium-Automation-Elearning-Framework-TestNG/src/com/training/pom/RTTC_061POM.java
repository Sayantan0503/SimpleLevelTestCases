package com.training.pom;

public class RTTC_061POM {
	//private String userName;
	//private String password;
	private String firstname;
	private String lastname ;
	private String email ;
	private String telephone ;
	private String address1;
	private String address2;
	private String city ;
	private String postalcode ;
	private String country;
	private String region ;
	private String password;
	private String confirmpassword;
	
	
	

	public RTTC_061POM() {
	}

	
		public RTTC_061POM	(String firstname, String lastname ,String email ,String telephone  ,String address1 ,String address2 , String city, String postalcode, String country , String region , String password , String confirmpassword) {
		super();
		this.firstname = firstname;
		//this.password = password;
	    this.lastname =lastname;
	    this.email =email;
	    this.telephone=telephone;
	    this.address1=address1;
	    this.address2=address2;
	    this.city=city;
	    this.postalcode=postalcode;
	    this.country=country;
	    this.region=region;
	    this.password=password;
	    this.confirmpassword=confirmpassword;
	    
		
		}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setlastname(String lastname) {
		this.lastname =lastname;
	}
   
	public String getEmail() {
		return email;
	}
	
	public void setemail(String email) {
		this.email=email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone=telephone;
	}
	
	public String getAddress1() {
		 return address1 ;
	}
	
	public void setAddress1(String address1) {
		this.address1=address1;
	}
	
	public String getAddress2() {
		 return address2 ;
	}
	
	public void setAddress2(String address2) {
		this.address2=address2;
	}
	
	public String getCity() {
		 return city;
	}
	
	public void setCity(String city) {
		this.city=city;
	}
	
	public String getPostalCode() {
		return postalcode;
	}
	
	public void setPostalcode (String postalcode) {
		this.postalcode=postalcode;
	}
	
	public String getCountry () {
		return country;
	}
	
	public void setCountry(String country) {
		this.country=country;
	}
	
	public String getRegion () {
		return region ;
	}
	
	public void setRegion(String region) {
		this.region=region;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getconfirmpassword() {
		return confirmpassword;
	}
	
	public void setconfirmpassword (String confirmpassword) {
		this.confirmpassword=confirmpassword;
	}
	
	@Override
	public String toString() {
		return "RTTC_061POM [firstname=" + firstname + ", lastname=" + lastname + ",email="+email+",telephone="+telephone+",address1="+address1+" ,address2="+address2+",city="+city+",postalcode="+postalcode+", country="+country+" ,region="+region+",password="+password+" ,confirmpassword="+confirmpassword+"]";
	}

}
