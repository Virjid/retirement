package io.virjid.retirement.entity;

import java.util.List;

public class OldmanEntity extends AccountEntity {
	private static final long serialVersionUID = -4244040264309532104L;
	
	private List<OldmanFamilyEntity> families;
	
	private NurseEntity nurse;
	private DoctorEntity doctor;
	private CareEntity care;
}
