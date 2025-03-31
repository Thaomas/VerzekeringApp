package com.verzekeringapp.models

import java.util.UUID

interface User {
    val uid: UUID
    val name: String
    val email: String
    val password: String
}