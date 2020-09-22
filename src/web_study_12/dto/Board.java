package web_study_12.dto;

import java.util.Date;

public class Board {
	private int num;
	private String name;
	private String email;
	private String pass;
	private String title;
	private String content;
	private int readCount;
	private Date writeDate;

	public Board() {}

	public Board(int num) {
		this.num = num;
	}
	

	public Board(int num, String pass) {
		this.num = num;
		this.pass = pass;
	}

	public Board(int num, String name, String email, String pass, String title, String content, int readCount,
			Date writeDate) {
		
		this.num = num;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.title = title;
		this.content = content;
		this.readCount = readCount;
		this.writeDate = writeDate;
	}
	
	public Board(String name, String email, String pass, String title, String content) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.title = title;
		this.content = content;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return String.format(
				"Board [num=%s, name=%s, email=%s, pass=%s, title=%s, content=%s, readCount=%s, writeDate=%s]", num,
				name, email, pass, title, content, readCount, writeDate);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (num != other.num)
			return false;
		return true;
	}

	
}
