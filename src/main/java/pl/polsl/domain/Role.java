package pl.polsl.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "role_name")
    private String roleName;
    
    @ManyToMany(mappedBy = "role")
    private Set<User> users;
    
    Role(){}
    
    public Role(Long id, String roleName, Set<User> users) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.users = users;
	}




	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}