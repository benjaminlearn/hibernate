package org.benjamin.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="t_node")
public class Node {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	private String name;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="parent_id")
	private Node parentNode;
	
    @OneToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER, mappedBy="parentNode")
	private List<Node> childNodes=new ArrayList<Node>();

    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getParentNode() {
		return parentNode;
	}
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
	public List<Node> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Node> childNodes) {
		this.childNodes = childNodes;
	}
}
