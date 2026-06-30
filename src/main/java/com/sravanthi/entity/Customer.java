package com.sravanthi.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="Customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long customerId;
	
	@NonNull
	@NotBlank(message="Enter the valid name")
	private String name;
	
	@NonNull
	@Email(message="Enter the valid email")
	private String email;
	
	@NonNull
	@Positive(message="Salary must be positive")
	private Double salary;
	
	@NonNull
	@Positive(message="Monthly expense must be greater than zero")
	private Double monthlyExpense;
	
	@NonNull
	@Positive(message="Esisting emi must be greater than zero")
	private Double existingEmi;
	
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;
}
