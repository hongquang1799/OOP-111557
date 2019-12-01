/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import benchmark.*;
import data.*;
import database.*;
import java.util.ArrayList;

import java.time.Clock;;

public class App {
	
	static final int entityTotalCount = 60000;
	static final int entityBatchCount = 50;
	static final int factTotalCount = 80000;
	static final int factBatchCount = 50;
	
	static final String[] NORMAL_QUERRIES = {
				"FOR u IN entities FILTER u._key == \"PERSON1000\" RETURN u.description",
				"FOR u IN entities FILTER u._key == \"PERSON1000\" RETURN u.nationality",
				"FOR u IN entities FILTER u._key == \"PERSON367\" RETURN u.dateOfBirth",
				"FOR u IN entities FILTER u._key == \"PERSON446\" RETURN u.name", 
				"FOR u IN entities FILTER u._key == \"ORGANIZATION1\" RETURN u.description",
				
				"FOR u IN entities FILTER u._key == \"ORGANIZATION2\" RETURN u.description",
				"FOR u IN entities FILTER u._key == \"ORGANIZATION3\" RETURN u.description",
				"FOR u IN entities FILTER u._key == \"EVENT1\" RETURN u.description",
				"FOR u IN facts FILTER u.relationship == \"DIEN_RA_TAI\" && u.objectID == \"CITY3\" RETURN u.subjectID",
				"FOR u IN facts FILTER u._key == \"FACT25\" RETURN u.subjectID"
			};
	
	static final String[] ADVANCED_QUERRIES = {
			"FOR u IN facts FILTER u.relationship == \"DIEN_RA_TAI\" && u.objectID = \"CITY1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"GAP_GO\" && u.objectID = \"PERSON1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"TO_CHUC\" && u.objectID = \"CITY1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"KY_THOA_THUAN\" && u.objectID = \"ORGANIZATION1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"PHAN_DOI\" && u.subjectID = \"ORGANIZATION1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"THAM_GIA\" && u.subjectID = \"EVENT1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"UNG_HO\" && u.objectID = \"ORGANIZATION1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"PHAT_BIEU_TAI\" && u.objectID = \"CITY1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"HUY_BO\" && u.objectID = \"ORGANIZATION1000\" RETURN u.description",
			"FOR u IN facts FILTER u.relationship == \"HUY_BO\" && u.objectID = \"ORGANIZATION1000\" RETURN u.description",
		};
	

	public App() {
		ElapsedTime time = new ElapsedTime();
		time.begin();
		time.end();
		
		String username = "root";
		String password = "12345";
		ArangoDataBase db = new ArangoDataBase(username, password);
		String dbName = "mydb";
		String entityCollectionName = "entities";
		String factCollectionName = "facts";

		db.createDataBase(dbName);
		db.dropCollection(dbName, entityCollectionName);
		db.dropCollection(dbName, factCollectionName);
		db.createCollection(dbName, entityCollectionName);
		db.createCollection(dbName, factCollectionName);

		System.out.println("     SDL	TVCB1	TVCB2	TVCB3	TVCB4	TVCB5	TVCB6	TVCB7	TVCB8	TVCB9	TVCB10");
		
		time.begin();
		DataGenerator.Generate(entityTotalCount, entityBatchCount, factTotalCount, factBatchCount, db, dbName, entityCollectionName, factCollectionName);
		time.end();
		System.out.print(String.format("%8.1f    ", time.get()));
		
			
		for (int i = 0; i < ADVANCED_QUERRIES.length; i++) {
			time.begin();
			ArrayList<String> result = db.executeQuery(dbName, NORMAL_QUERRIES[i]);
			time.end();
			System.out.print(String.format("%8.1f", time.get()));
			//result.forEach(s -> System.out.println(s));
		}
		
	}
	
	public static void main(String[] args) {
		new App();
	}
}
