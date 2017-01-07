package pl.polsl.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subject_id")
	private long id;
	
	@Column(name = "subject_name")
	private String subjectName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
	private Set<Rates> rates = new HashSet<Rates>(0);

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Set<Rates> getRates() {
		return rates;
	}

	public void setRates(Set<Rates> rates) {
		this.rates = rates;
	}	
	
	
	
}
