package com.sample.CodeSample.domain;

import com.sample.CodeSample.domain.enumeration.State;

import java.time.Instant;
import java.util.Objects;
import javax.persistence.*;

/**
 * A Doctor.
 */
@Entity
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;
	private String firstName;
	private String lastName;
	private String address;
	private State state;
	private Instant createdAt;
	private Instant modifiedAt;
	
	@PrePersist
	public void prePersist() {
		createdAt = Instant.now();
		modifiedAt = Instant.now();
	}
	
	@PreUpdate
	public void preUpdate() {
		modifiedAt = Instant.now();
	}
	
	// Empty constructor
	public Doctor() {}
	
	// Basic constructor
	public Doctor(String firstName, String lastName, String address, State state) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.state = state;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Doctor id(Long id) {
        this.id = id;
        return this;
    }
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Doctor firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Doctor lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Doctor address(String address) {
        this.address = address;
        return this;
    }
	
	public State getState() {
		return this.state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public Doctor state(State state) {
        this.state = state;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Doctor createdAt(Instant createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getModifiedAt() {
        return modifiedAt;
    }

    public Doctor modifiedAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
        return this;
    }

    public void setModifiedAt(Instant modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Doctor)) {
            return false;
        }
        return id != null && id.equals(((Doctor) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.address, this.state, this.createdAt, this.modifiedAt);
    }

    @Override
    public String toString() {
        return "Doctor{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", address='" + getAddress() + "'" +
            ", state='" + getState() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", modifiedAt='" + getModifiedAt() + "'" +
            "}";
    }
}
