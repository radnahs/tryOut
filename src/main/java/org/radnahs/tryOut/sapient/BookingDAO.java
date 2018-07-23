/**
 *
 * <p>Project: rytry_trunk </p>
 * <p>Package Name: com.webtual.rytry.utils.tests.sapient </p>
 * <p>File Name: BookingDAO.java</p>
 * <p>Create Date: Oct 10, 2015 </p>
 * <p>Create Time: 5:29:15 PM </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company:  </p>
 * @author Shantanu Sikdar
 * @version 1.0
 */
package org.radnahs.tryOut.sapient;

import java.util.Date;

/**
 * @author Shantanu Sikdar 
 *
 */
public class BookingDAO {
	
	private Integer pickUpAreaCode;
	private Integer dropAreaCode;
	private Date pickUpTime;
	private String orderStatus;
	private CabDAO cabDAO;
	
	public Integer getPickUpAreaCode() {
		return pickUpAreaCode;
	}
	public void setPickUpAreaCode(Integer pickUpAreaCode) {
		this.pickUpAreaCode = pickUpAreaCode;
	}
	public Integer getDropAreaCode() {
		return dropAreaCode;
	}
	public void setDropAreaCode(Integer dropAreaCode) {
		this.dropAreaCode = dropAreaCode;
	}
	public Date getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(Date pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public CabDAO getCabDAO() {
		return cabDAO;
	}
	public void setCabDAO(CabDAO cabDAO) {
		this.cabDAO = cabDAO;
	}
	
	
}
