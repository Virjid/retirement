package io.virjid.retirement.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class CareEntity extends AbstractStaffEntity {
	private static final long serialVersionUID = 1328332088526166466L;
	
	private List<OldmanEntity> oldmans;
}
