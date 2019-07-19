package io.virjid.retirement.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
public class OldmanFamilyEntity extends AbstractAccountEntity {
	private static final long serialVersionUID = -5819311386742961161L;
	
	private List<OldmanEntity> oldmans;
}
