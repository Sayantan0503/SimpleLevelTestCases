package com.training.bean;

public class LoginBean {
	//private String userName;  //from begin
	//private String password;
    /////////////input by Sayan//////////
	private String firstname;
	private String lastname ;
	private String email ;
	private String telephone ;
	private String address1;
	private String address2;
	private String city ;
	private String postcode ;
	private String country;
	private String region ;
	private String password;
	private String passwordconfirm;
	
	
	
	public LoginBean() {
	}

	//public LoginBean(String userName, String password) {
		
	public LoginBean(String firstname, String lastname ,String email ,String telephone  ,String address1 ,String address2 , String city, String postalcode, String country , String region , String password , String confirmpassword) {
		super();
	
	  // super();
		//this.userName = userName;
		//this.password = password;
		this.firstname = firstname;
		//this.password = password;
	    this.lastname =lastname;
	    this.email =email;
	    this.telephone=telephone;
	    this.address1=address1;
	    this.address2=address2;
	    this.city=city;
	    this.postcode=postcode;
	    this.country=country;
	    this.region=region;
	    this.password=password;
	    this.passwordconfirm=passwordconfirm;

	
	}

	/*public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [userName=" + userName + ", password=" + password + "]";
	} */

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
	
	public String getPostCode() {
		return postcode;
	}
	
	public void setPostcode (String postcode) {
		this.postcode=postcode;
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
	
	public String getpasswordconfirm() {
		return passwordconfirm;
	}
	
	public void setpasswordconfirm (String passwordconfirm) {
		this.passwordconfirm=passwordconfirm;
	}
	
	@Override
	public String toString() {
		return "LoginBean [firstname=" + firstname + ", lastname=" + lastname + ",email="+email+",telephone="+telephone+",address1="+address1+" ,address2="+address2+",city="+city+",postcode="+postcode+", country="+country+" ,region="+region+",password="+password+" ,confirmpassword="+passwordconfirm+"]";
	}

	
	
}
