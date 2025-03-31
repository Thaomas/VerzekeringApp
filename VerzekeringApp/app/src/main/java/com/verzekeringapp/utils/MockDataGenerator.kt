package com.verzekeringapp.utils

import com.verzekeringapp.models.Claim
import com.verzekeringapp.models.Customer
import com.verzekeringapp.models.InsurancePolicy
import com.verzekeringapp.models.Insurer
import java.util.Date
import java.util.UUID

object MockDataGenerator {

    fun generateCustomers(): List<Customer> {
        return listOf(
            Customer(
                uid = UUID.randomUUID(),
                name = "John Doe",
                email = "john.doe@example.com",
                password = "password123",
                birthdate = Date()
            ),
            Customer(
                uid = UUID.randomUUID(),
                name = "Jane Smith",
                email = "jane.smith@example.com",
                password = "password123",
                birthdate = Date()
            )
        )
    }

    fun generateInsurers(): List<Insurer> {
        return listOf(
            Insurer(
                uid = UUID.randomUUID(),
                name = "Insurer A",
                email = "contact@insurera.com",
                password = "password123",
                description = "Leading insurance provider"
            ),
            Insurer(
                uid = UUID.randomUUID(),
                name = "Insurer B",
                email = "contact@insurerb.com",
                password = "password123",
                description = "Trusted by millions"
            )
        )
    }

    fun generateInsurancePolicies(customers: List<Customer>, insurers: List<Insurer>): List<InsurancePolicy> {
        return listOf(
            InsurancePolicy(
                uid = UUID.randomUUID(),
                insurerId = insurers[0].uid,
                customerId = customers[0].uid,
                name = "Health Insurance",
                description = "Comprehensive health coverage"
            ),
            InsurancePolicy(
                uid = UUID.randomUUID(),
                insurerId = insurers[1].uid,
                customerId = customers[1].uid,
                name = "Car Insurance",
                description = "Full coverage for your vehicle"
            )
        )
    }

    fun generateClaims(policies: List<InsurancePolicy>): List<Claim> {
        return listOf(
            Claim(
                uid = UUID.randomUUID(),
                policyId = policies[0].uid,
                description = "Hospital visit",
                value = 500.0
            ),
            Claim(
                uid = UUID.randomUUID(),
                policyId = policies[1].uid,
                description = "Car accident repair",
                value = 1500.0
            )
        )
    }
} 