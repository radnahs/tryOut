/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.sapient </p>
 * <p>File Name: CabDAO.java</p>
 * <p>Create Date: Jul 27, 2015 </p>
 * <p>Create Time: 5:29:57 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2012</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.sapient;

/**
 * @author Shantanu Sikdar 
 *
 */
public class CabDAO {
	private String cabNumber;
	private String cabStatus;
	private Integer currentAreaCode;
	
	public String getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}
	public String getCabStatus() {
		return cabStatus;
	}
	public void setCabStatus(String cabStatus) {
		this.cabStatus = cabStatus;
	}
	public Integer getCurrentAreaCode() {
		return currentAreaCode;
	}
	public void setCurrentAreaCode(Integer currentAreaCode) {
		this.currentAreaCode = currentAreaCode;
	}
}
