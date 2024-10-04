package dev.carlosivis.medtrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.carlosivis.medtrack.data.local.entity.MedicationEntity

@Dao
interface MedicationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedication(medication: MedicationEntity)

    @Query("SELECT * FROM medications WHERE isActive = 1")
    fun getAllActiveMedications(): List<MedicationEntity>

    @Query("SELECT * FROM medications WHERE isActive = 0")
    fun getAllInactiveMedications(): List<MedicationEntity>

    @Query("UPDATE medications SET isActive = :isActive WHERE id = :medicationId")
    fun updateMedicationStatus(medicationId: Int, isActive: Boolean)

    @Delete
    fun deleteMedication(medication: MedicationEntity)
}
