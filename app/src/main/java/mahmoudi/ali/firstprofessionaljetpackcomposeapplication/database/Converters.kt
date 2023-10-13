package mahmoudi.ali.firstprofessionaljetpackcomposeapplication.database

import androidx.room.TypeConverter
import mahmoudi.ali.firstprofessionaljetpackcomposeapplication.model.Source

class Converters {


    @TypeConverter
    fun fromSource(source: Source) : String? = source.name

    @TypeConverter
    fun toSource(name: String) : Source = Source(name, name)

}