package ca.mcgill.ecse321.TreePLE.dto;

import java.util.*;

import ca.mcgill.ecse321.TreePLE.model.Status.TreeState; 

public class StatusDto {
//	private TreeDto tree;

	private TreeState treeState;
	public  StatusDto() {
	
	}
	
	public  StatusDto(TreeState treeState) {
		this.treeState=treeState;
		//this.tree=tree;
	}
	
	public TreeState getTreeState() {
		return treeState;
	}
	/*public TreeDto getTree() {
		return this.tree;
	}*/
}
