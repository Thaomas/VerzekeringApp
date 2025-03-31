package com.verzekeringapp.views

import androidx.room.DatabaseView
import java.util.UUID
@DatabaseView("SELECT policies.uid AS policyId, policies.name, policies.description, customers.uid AS customerId, customers.name AS customerName, insurers.uid AS insurerId, insurers.name AS insurerName " +
        "FROM policies JOIN customers ON policies.customerId = customers.uid JOIN insurers ON policies.insurerId = insurers.uid")
data class PolicyDetail(
    val policyId: UUID,
    val name: String,
    val description: String,
    val customerId: UUID,
    val customerName: String,
    val insurerId: UUID,
    val insurerName: String
)

