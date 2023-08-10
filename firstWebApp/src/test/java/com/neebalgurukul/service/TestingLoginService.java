//package com.neebalgurukul.service;
//
//import static org.junit.Assert.assertTrue;
//
//
//import org.junit.Test;
////import static org.junit.Assert.assertThrows;
////import org.junit.*;
//public class TestingLoginService {
//	
//	@Test(expected = AssertionError.class)
//	public void TestIsValidUserFail() throws Exception {
//		String username="Adisdsd";
//		String password = "pw12";
//		LoginService ls = new LoginService();
//		boolean actualOutput;
//
//			actualOutput = ls.isValidUser(username,password);
//			assertTrue(actualOutput);
//
//		
//		
//	}
//	
//	@Test
//	public void TestIsValidUserPass(){
//		String username="Adi";
//		String password = "pw12";
//		LoginService ls = new LoginService();
//		boolean actualOutput=false;
//
//			try {
//				actualOutput = ls.isValidUser(username,password);
//				assertTrue(actualOutput);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				System.out.println("some error");
//			}
//		
//		
//	}
//}
