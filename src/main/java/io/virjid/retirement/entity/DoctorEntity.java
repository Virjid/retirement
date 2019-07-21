package io.virjid.retirement.entity;

import java.util.List;

public class DoctorEntity extends AccountEntity {
	private static final long serialVersionUID = 5669005771852142879L;
	
	private List<OldmanEntity> oldmans;

	public List<OldmanEntity> getOldmans() {
		return oldmans;
	}

	public void setOldmans(List<OldmanEntity> oldmans) {
		this.oldmans = oldmans;
	}
}
