package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[12]; 
			/*obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); */ // from Start
			
			obj [0]=temp.getFirstname();
			obj [1]=temp.getLastname();
			obj [2] =temp.getEmail();
			obj [3]=temp.getTelephone();
			obj [4]=temp.getAddress1();
			obj [5]=temp.getAddress2();
			obj [6]=temp.getCity();
			obj [7]=temp.getPostCode();
			obj [8]=temp.getCountry();
			obj [9] =temp.getRegion();
			obj [10]=temp.getPassword();
			obj [11]=temp.getpasswordconfirm();
					
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")   // use this apache poi for Complex TC
	public Object[][] getExcelData(){
		//String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx";   //you have to change the path 2nd one 
		String fileName ="C:\\Users\\SayantanChatterjee\\Desktop\\DataSheet_ATS\\TC_62.xlsx";
		String sheetname="Sheet 1"; //added 25032019
		//String fileName= "C:\\Users\\SayantanChatterjee\\Desktop\\DataSheet_ATS\\TC_MS.xlsx";
		//return new ApachePOIExcelRead().getExcelContent(fileName);  //previous
		return new ApachePOIExcelRead().getExcelContent(fileName ,sheetname);
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
