package com.inturn.biz.users.vo;

public class MailVO {	
	private String m_num;        	  //VARCHAR(2)   NOT NULL COMMENT 'm_num', -- m_num
	private String from_addr;    	  //VARCHAR(40)  NULL     COMMENT 'from_addr', -- from_addr
	private String fromname;     	  //VARCHAR(40)  NULL     COMMENT 'fromname', -- fromname
	private String smtp_username;	  //VARCHAR(100) NULL     COMMENT 'smtp_username', -- smtp_username
	private String smtp_userpassword; //VARCHAR(200) NULL     COMMENT 'smtp_userpassword', -- smtp_userpassword
	private String host;              //VARCHAR(100) NULL     COMMENT 'host', -- host
	private int port;                 //INT          NULL     COMMENT 'port' -- port
	
	public MailVO() {	}

	public MailVO(String m_num, String from_addr, String fromname, String smtp_username, String smtp_userpassword,
			String host, int port) {
		this.m_num = m_num;
		this.from_addr = from_addr;
		this.fromname = fromname;
		this.smtp_username = smtp_username;
		this.smtp_userpassword = smtp_userpassword;
		this.host = host;
		this.port = port;
	}

	public String getM_num() {
		return m_num;
	}

	public void setM_num(String m_num) {
		this.m_num = m_num;
	}

	public String getFrom_addr() {
		return from_addr;
	}

	public void setFrom_addr(String from_addr) {
		this.from_addr = from_addr;
	}

	public String getFromname() {
		return fromname;
	}

	public void setFromname(String fromname) {
		this.fromname = fromname;
	}

	public String getSmtp_username() {
		return smtp_username;
	}

	public void setSmtp_username(String smtp_username) {
		this.smtp_username = smtp_username;
	}

	public String getSmtp_userpassword() {
		return smtp_userpassword;
	}

	public void setSmtp_userpassword(String smtp_userpassword) {
		this.smtp_userpassword = smtp_userpassword;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "MailVO [m_num=" + m_num + ", from_addr=" + from_addr + ", fromname=" + fromname + ", smtp_username="
				+ smtp_username + ", smtp_userpassword=" + smtp_userpassword + ", host=" + host + ", port=" + port
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from_addr == null) ? 0 : from_addr.hashCode());
		result = prime * result + ((fromname == null) ? 0 : fromname.hashCode());
		result = prime * result + ((host == null) ? 0 : host.hashCode());
		result = prime * result + ((m_num == null) ? 0 : m_num.hashCode());
		result = prime * result + port;
		result = prime * result + ((smtp_username == null) ? 0 : smtp_username.hashCode());
		result = prime * result + ((smtp_userpassword == null) ? 0 : smtp_userpassword.hashCode());
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
		MailVO other = (MailVO) obj;
		if (from_addr == null) {
			if (other.from_addr != null)
				return false;
		} else if (!from_addr.equals(other.from_addr))
			return false;
		if (fromname == null) {
			if (other.fromname != null)
				return false;
		} else if (!fromname.equals(other.fromname))
			return false;
		if (host == null) {
			if (other.host != null)
				return false;
		} else if (!host.equals(other.host))
			return false;
		if (m_num == null) {
			if (other.m_num != null)
				return false;
		} else if (!m_num.equals(other.m_num))
			return false;
		if (port != other.port)
			return false;
		if (smtp_username == null) {
			if (other.smtp_username != null)
				return false;
		} else if (!smtp_username.equals(other.smtp_username))
			return false;
		if (smtp_userpassword == null) {
			if (other.smtp_userpassword != null)
				return false;
		} else if (!smtp_userpassword.equals(other.smtp_userpassword))
			return false;
		return true;
	}
	
	
}
