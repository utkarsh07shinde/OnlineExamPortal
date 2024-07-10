package com.OnlineExamPortal.entity;

import java.util.HashSet;
import java.util.Set;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
@Entity
@Table(name = "roles")
public class Role {

	    @Id
	    @GeneratedValue(strategy= GenerationType.IDENTITY)
		private Long roleId;
	    
	    @Column(name="role_name")
	    private String roleName;

	    @Column(name="role_description")
	    private String roleDescription;
	    
	    @ManyToMany(mappedBy = "roles")
	    private Set<User> users = new HashSet<>();
}

