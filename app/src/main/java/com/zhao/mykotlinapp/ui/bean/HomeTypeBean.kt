package com.zhao.mykotlinapp.ui.bean


import com.google.gson.annotations.SerializedName

data class HomeTypeBean(
    @SerializedName("RSPCOD")
    var rSPCOD: String,
    @SerializedName("RSPDATA")
    var rSPDATA: RSPDATA,
    @SerializedName("RSPMSG")
    var rSPMSG: String
) {
    data class RSPDATA(
        @SerializedName("LIST")
        var lIST: List<LIST>
    ) {
        data class LIST(
            @SerializedName("ID")
            var iD: String,
            @SerializedName("NAME")
            var nAME: String,
            @SerializedName("IMAGE")
            var iMAGE: String
        )
    }
}