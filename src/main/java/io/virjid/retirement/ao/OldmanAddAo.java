package io.virjid.retirement.ao;

public class OldmanAddAo extends AccountAddAo {
	private String doctorId;
	private String nurseId;
	private String careId;
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getNurseId() {
		return nurseId;
	}
	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}
	public String getCareId() {
		return careId;
	}
	public void setCareId(String careId) {
		this.careId = careId;
	}
}
