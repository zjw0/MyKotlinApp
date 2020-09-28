package com.zhao.mykotlinapp.ui.bean


import com.google.gson.annotations.SerializedName

data class DataListBean(
    @SerializedName("RSPCOD")
    var rSPCOD: String, // 000000
    @SerializedName("RSPDATA")
    var rSPDATA: RSPDATA,
    @SerializedName("RSPMSG")
    var rSPMSG: String // 成功
) {
    data class RSPDATA(
        @SerializedName("LIST")
        var lIST: List<LIST>
    ) {
        data class LIST(
            @SerializedName("NAME")
            var nAME: String = "", //名字
            var isLock:String = "00"
        )
    }
}