package com.inturn.biz.users.vo;

public class JobVO {
	private int job_num;
	private String position;
	private String kinds;
	private String duty;
	private String id;

	public JobVO() {
	}
	public JobVO(int job_num, String position, String kinds, String duty, String id) {
		this.job_num = job_num;
		this.position = position;
		this.kinds = kinds;
		this.duty = duty;
		this.id = id;
	}
	public int getJob_num() {
		return job_num;
	}
	public void setJob_num(int job_num) {
		this.job_num = job_num;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "JobVO [job_num=" + job_num + ", position=" + position + ", kinds=" + kinds + ", duty=" + duty + ", id="
				+ id + "]";
	}
}
