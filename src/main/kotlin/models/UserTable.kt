// src/main/kotlin/com/example/models/UsersTable.kt
package models

import org.jetbrains.exposed.dao.id.IdTable

object UsersTable : IdTable<Int>("users") {
    override val id = integer("id").autoIncrement().entityId() // EntityID
    val username = varchar("username", 50).uniqueIndex()
    val passwordHash = varchar("password_hash", 60)

    override val primaryKey = PrimaryKey(id)
}