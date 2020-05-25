package com.cda.menu.action;

public abstract class Action implements Comparable<Action> {
	
	protected final int id;
	protected final String description;
	
	protected Action(int pId, String pDescription) {
		this.id = pId;
		this.description = pDescription;
	}
	
	public abstract boolean executer();
	
	public int getId() {
		return this.id;
	}
	
	public String getDescription() {
		return this.description;
	}

	@Override
	public int compareTo(Action pAction) {
		return Integer.compare(this.id, pAction.id);
	}
}
