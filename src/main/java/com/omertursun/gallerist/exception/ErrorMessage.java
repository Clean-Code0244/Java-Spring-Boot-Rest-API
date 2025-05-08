package com.omertursun.gallerist.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private MessageType messageType;
    private String offStatic;

    public String prepareErrorMessage() {
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append(this.messageType.getMessage());
        if(offStatic != null) {
            errorMessage.append(" : " + offStatic);
        }
        return errorMessage.toString();

    }
}
