package com.jdbc.ActionUtil;

import com.jdbc.DBContext.*;
import com.jdbc.DAOUtil.*;
import java.util.*;
import java.sql.*;


public class BillAction{

	public ContextClass dbContext = null;
	
	public BillAction(ContextClass dbContext){
		this.dbContext=dbContext;
	}


	public List<Bill> getAllBills(Timestamp from, Timestamp to){
		try{
			return dbContext.getAllBills(from,to);
		}catch(SQLException exp){
			System.out.println(exp.toString());
		}
		return null;
	}

	public List<Bill> getBillsFromCache(){
		return dbContext.getBillsFromCache();
	}
}