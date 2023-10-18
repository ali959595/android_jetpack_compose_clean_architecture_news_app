package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.data.data_sources.local

import androidx.room.TypeConverter
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.domain.model.SourceEntity

class Converters {

    @TypeConverter
    fun fromSource(source: SourceEntity): String? = source.name

    @TypeConverter
    fun toSource(name: String): SourceEntity = SourceEntity(name, name)

}