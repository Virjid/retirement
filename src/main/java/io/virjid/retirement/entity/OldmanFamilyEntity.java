package io.virjid.retirement.entity;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

public class OldmanFamilyEntity extends AccountEntity {
	private static final long serialVersionUID = -5819311386742961161L;
	
	private List<OldmanEntity> oldmans;
}
