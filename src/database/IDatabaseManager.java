package database;

import java.util.ArrayList;

public interface IDatabaseManager {
	public boolean createDataBase(String dbName);

	public boolean dropDatabase(String dbName);

	public boolean createCollection(String dbName, String collectionName);

	public boolean dropCollection(String dbName, String collectionName);

	public boolean createDocument(String dbName, String collectionName, Object object);

	public boolean createDocument(String dbName, String collectionName, ArrayList<?> objects);

	public ArrayList<String> executeQuery(String dbName, String query);
}
