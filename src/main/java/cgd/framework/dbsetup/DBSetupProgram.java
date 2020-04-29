/**
 * 
 */
package cgd.framework.dbsetup;

import java.io.File;
import java.sql.SQLException;

import morphis.framework.configuration.Config;
import morphis.framework.persistence.catalog.Catalog;
import morphis.framework.persistence.relational.BaseTableHandler;
import morphis.framework.persistence.relational.ConnectionManager;
import morphis.framework.utils.ReflectionUtils;

/**
 * @author joao.goncalves
 *
 */
public class DBSetupProgram {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 2) {
			String fileName = args[0]; 
			String tableName = args[1];

			DBSetupProgram DBSetupProgram = new DBSetupProgram();
			DBSetupProgram.load(fileName, tableName);
		}else {
			throw new RuntimeException("Wrong number of arguments, Should be File Name and TableName." );
		}
	}

	@SuppressWarnings("unchecked")
	public void dump(String fileName, String tableName) {
			try {
				BaseTableHandler handler = findHandler(tableName);
				if(handler != null) {
					handler.dump(fileName);
				}else {
					throw new RuntimeException("Table: " + tableName + " does not exist.");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} 
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void load(String fileName, String tableName) {
			try {
				File f = Catalog.get().resolveExisting(fileName);
				if (f != null) {
					BaseTableHandler handler = findHandler(tableName);
					if(handler != null) {
						handler.deleteAll();
						handler.load(fileName);
						
						ConnectionManager.commit();
					}else {
						throw new RuntimeException("Table: " + tableName + " does not exist.");
					}
				}
				else {
					throw new RuntimeException("File: " + fileName + " does not exist.");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} 
		
	}
	
	public BaseTableHandler findHandler(String tableName) {
			String className = "";
			String[] tablePartNames = tableName.split("\\_+"); 
			for (String tablePartName : tablePartNames) {
				tableName = tablePartName.substring(0, 1).toUpperCase() + tablePartName.substring(1).toLowerCase();
				className += tableName; 
			}
			for (String tablePackage : Config.tablePackages) {
				try {
					return  (BaseTableHandler) ReflectionUtils.newInstance(ReflectionUtils.findClass(tablePackage + "." + className));
				} catch (Exception e) {
					// ignore
				}
			}
			return null;
		}
}
