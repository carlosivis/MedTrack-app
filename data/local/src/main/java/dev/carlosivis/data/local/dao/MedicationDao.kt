package dev.carlosivis.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.carlosivis.data.local.entity.MedicationEntity

@Dao
interface MedicationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedication(medication: MedicationEntity)

    @Query("SELECT * FROM medications WHERE isActive = 1")
    suspend fun getAllActiveMedications(): List<MedicationEntity>

    @Query("SELECT * FROM medications WHERE isActive = 0")
    suspend fun getAllInactiveMedications(): List<MedicationEntity>

    @Query("UPDATE medications SET isActive = :isActive WHERE id = :medicationId")
    suspend fun updateMedicationStatus(medicationId: Int, isActive: Boolean)

    @Delete
    suspend fun deleteMedication(medication: MedicationEntity)
}
