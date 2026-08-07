package com.yauhescha.javashiki.model.domen;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

@Data
public class Dialog implements Serializable {

    @SerializedName("target_user")
    @Expose
    private User targetUser;

    @SerializedName("message")
    @Expose
    private com.yauhescha.javashiki.model.domen.message.Message message;

}
