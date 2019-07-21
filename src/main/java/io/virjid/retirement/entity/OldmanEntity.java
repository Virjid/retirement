package io.virjid.retirement.entity;

public class OldmanEntity extends AccountEntity {
	private static final long serialVersionUID = -4244040264309532104L;
	
	private NurseEntity nurse;
	private DoctorEntity doctor;
	private CareEntity care;
	
	private String nurseId;
	private String doctorId;
	private String careId;
	public NurseEntity getNurse() {
		return nurse;
	}
	public void setNurse(NurseEntity nurse) {
		this.nurse = nurse;
	}
	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}
	public CareEntity getCare() {
		return care;
	}
	public void setCare(CareEntity care) {
		this.care = care;
	}
	public String getNurseId() {
		return nurseId;
	}
	public void setNurseId(String nurseId) {
		this.nurseId = nurseId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getCareId() {
		return careId;
	}
	public void setCareId(String careId) {
		this.careId = careId;
	}
}
