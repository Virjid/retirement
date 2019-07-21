package io.virjid.retirement.dto;

import io.virjid.retirement.entity.CareEntity;
import io.virjid.retirement.entity.DoctorEntity;
import io.virjid.retirement.entity.NurseEntity;

public class OldmanContext extends AccountContext {
	private DoctorEntity doctor;
	private NurseEntity nurse;
	private CareEntity care;
	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}
	public NurseEntity getNurse() {
		return nurse;
	}
	public void setNurse(NurseEntity nurse) {
		this.nurse = nurse;
	}
	public CareEntity getCare() {
		return care;
	}
	public void setCare(CareEntity care) {
		this.care = care;
	}
}
