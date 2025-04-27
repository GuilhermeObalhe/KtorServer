// src/main/kotlin/com/example/repositories/SubjectRepository.kt
package repositories

import models.Subject
import models.SubjectsTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class SubjectRepository {
    fun create(name: String): Int {
        return transaction {
            SubjectsTable.insert {
                it[SubjectsTable.name] = name
            }[SubjectsTable.id].value
        }
    }

    fun getAll(): List<Subject> {
        return transaction {
            SubjectsTable.selectAll()
                .map { row ->
                    Subject(
                        id = row[SubjectsTable.id].value,
                        name = row[SubjectsTable.name]
                    )
                }
        }
    }
}