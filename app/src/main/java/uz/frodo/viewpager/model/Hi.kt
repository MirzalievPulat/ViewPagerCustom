package uz.frodo.viewpager.model

import android.os.Parcel
import android.os.Parcelable

class Hi(var image:Int,var name:String?,var text:String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
        parcel.writeString(text)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hi> {
        override fun createFromParcel(parcel: Parcel): Hi {
            return Hi(parcel)
        }

        override fun newArray(size: Int): Array<Hi?> {
            return arrayOfNulls(size)
        }
    }
}