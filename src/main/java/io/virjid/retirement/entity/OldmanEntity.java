package io.virjid.retirement.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class OldmanEntity extends AbstractAccountEntity {
	private static final long serialVersionUID = -4244040264309532104L;
	
	private List<OldmanFamilyEntity> families;
	
	private NurseEntity nurse;
	private DoctorEntity doctor;
	private CareEntity care;
}
