package io.virjid.retirement.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class NurseEntity extends AbstractStaffEntity {
	private static final long serialVersionUID = -7066957057580276326L;
	
	private List<OldmanEntity> oldmans;
}
