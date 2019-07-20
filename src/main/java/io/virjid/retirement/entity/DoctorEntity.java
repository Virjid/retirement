package io.virjid.retirement.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class DoctorEntity extends AbstractStaffEntity {
	private static final long serialVersionUID = 5669005771852142879L;
	
	private List<OldmanEntity> oldmans;
}