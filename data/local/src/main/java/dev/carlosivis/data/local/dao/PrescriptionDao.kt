package dev.carlosivis.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.carlosivis.data.local.entity.PrescriptionEntity

@Dao
interface PrescriptionDao {
    @Query("SELECT * FROM prescriptions WHERE medicationId = :medicationId")
    suspend fun getPrescriptionsByMedication(medicationId: Int): List<PrescriptionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrescription(prescription: PrescriptionEntity)

    @Delete
    suspend fun deletePrescription(prescription: PrescriptionEntity)
}
