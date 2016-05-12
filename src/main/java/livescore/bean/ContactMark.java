package livescore.bean;
/**
 * File ContactMark.java
 * Created on 5/11/2016, 5:25 PM.
 */

/**
 * TODO: Document me
 *
 * @author Adrian Iasinschi (adrian.iasinschi@kepler-rominfo.com)
 */
public class ContactMark {
	private String firstName;
	private String lastName;
	private String nickName;
	private String marks;

	public ContactMark(String firstName, String lastName, String nickName, String marks) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.marks = marks;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}
}
