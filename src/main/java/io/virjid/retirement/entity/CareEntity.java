package io.virjid.retirement.entity;

import java.util.List;


public class CareEntity extends AccountEntity {
	private static final long serialVersionUID = 1328332088526166466L;
	
	private List<OldmanEntity> oldmans;

	public List<OldmanEntity> getOldmans() {
		return oldmans;
	}

	public void setOldmans(List<OldmanEntity> oldmans) {
		this.oldmans = oldmans;
	}
}
